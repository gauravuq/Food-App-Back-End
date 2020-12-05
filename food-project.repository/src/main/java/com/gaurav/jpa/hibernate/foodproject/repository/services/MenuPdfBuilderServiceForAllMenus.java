package com.gaurav.jpa.hibernate.foodproject.repository.services;

import com.gaurav.jpa.hibernate.foodproject.repository.entities.MenuInstance;
import com.gaurav.jpa.hibernate.foodproject.repository.entities.MenuItemInstance;
import com.gaurav.jpa.hibernate.foodproject.repository.pdf.RoundedCornersCellRenderer;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS, scopeName = "prototype")
public class MenuPdfBuilderServiceForAllMenus {

    Logger logger = LoggerFactory.getLogger(this.getClass());
    private ByteArrayOutputStream outStream;
    private PdfWriter pdfWriter;
    private PdfDocument pdfDocument;
    private Document document;
    private Table table;
    private PdfFont font;

    public MenuPdfBuilderServiceForAllMenus() {
        outStream = new ByteArrayOutputStream();
        pdfWriter = new PdfWriter(outStream);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        document = new Document(pdfDocument, PageSize.A4.rotate());
        document.setMargins(20, 20, 20, 20);
        try {
            font = PdfFontFactory.createFont(FontConstants.HELVETICA);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ByteArrayInputStream pdfMenuBuilder(List<MenuInstance> menuInstances){
        setMenuHeadersForThePdf(menuInstances.get(0));
        for (MenuInstance menuInstance: menuInstances) {
            setMenuFieldsForThePdf(menuInstance);
        }
        getThePreparedMenuPdf();
        return new ByteArrayInputStream(outStream.toByteArray());
    }

    //TODO: make headers dynamic by reading from MenuItemType table
    private void setMenuHeadersForThePdf(MenuInstance menuInstance) {
        List<String> headersForTheMenu = new ArrayList<>();
        String[] pdfColumnHeadersForTheMenu = {"Menu Name", "Menu Type", "Menu_For_Date", "Order_Time_Limit"};
        headersForTheMenu.addAll(Arrays.asList(pdfColumnHeadersForTheMenu));
        List<MenuItemInstance> menuItemInstances = getOrderedMenuItemInstances(menuInstance);
        menuItemInstances.forEach((item) -> {
            headersForTheMenu.add(item.getItemType());
        });
        float[] columnsColSpan = new float[headersForTheMenu.size()];
        Arrays.fill(columnsColSpan, 1f);
        table = new Table(columnsColSpan);
        table.setWidth(UnitValue.createPercentValue(100))
                .setTextAlignment(TextAlignment.CENTER)
                .setHorizontalAlignment(HorizontalAlignment.CENTER);
        headersForTheMenu.forEach((item) -> {
            Cell cell = new Cell().add(new Paragraph(item));
            cell.setNextRenderer(new RoundedCornersCellRenderer(cell));
            cell.setPadding(5).setBorder(null);
            table.addHeaderCell(cell);
        });
    }


    //TODO: make fields dynamic later
    private void setMenuFieldsForThePdf(MenuInstance menuInstance) {
        Cell cell1 = new Cell().add(new Paragraph(menuInstance.getMenuForDate().getDayOfWeek() + " " + menuInstance.getMenuName()));
        cell1.setFont(font).setBorder(new SolidBorder(0.5f));
        table.addCell(cell1);
        Cell cell2 = new Cell().add(new Paragraph(menuInstance.getMenuType()));
        cell2.setFont(font).setBorder(new SolidBorder(0.5f));
        table.addCell(cell2);
        Cell cell3 = new Cell().add(new Paragraph(menuInstance.getMenuForDate().toString()));
        cell3.setFont(font).setBorder(new SolidBorder(0.5f));
        table.addCell(cell3);
        Cell cell4 = new Cell().add(new Paragraph(menuInstance.getOrderTimeLimit().toString()));
        cell4.setFont(font).setBorder(new SolidBorder(0.5f));
        table.addCell(cell4);
        List<MenuItemInstance> menuItemInstances = getOrderedMenuItemInstances(menuInstance);
        menuItemInstances.forEach((item) -> {
            Cell cell = new Cell().add(new Paragraph(item.getItemName()));
            cell.setFont(font).setBorder(new SolidBorder(0.5f));
            table.addCell(cell);
        });
    }

    private void getThePreparedMenuPdf() {
        document.add(table);
        document.close();
    }

    private List<MenuItemInstance> getOrderedMenuItemInstances(MenuInstance menuInstance) {
        return menuInstance.getMenuItemInstances().stream().sorted(Comparator.comparing(MenuItemInstance::getItemType)).collect(Collectors.toList());
    }


}
