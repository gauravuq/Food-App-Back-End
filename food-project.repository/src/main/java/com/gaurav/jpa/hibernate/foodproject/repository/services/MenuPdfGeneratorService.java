package com.gaurav.jpa.hibernate.foodproject.repository.services;

import com.gaurav.jpa.hibernate.foodproject.repository.entities.MenuInstance;
import com.gaurav.jpa.hibernate.foodproject.repository.entities.MenuItemInstance;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS,scopeName ="prototype")
public class MenuPdfGeneratorService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    // needs to be refactored
    public ByteArrayInputStream generateMenuWithMenuItems(MenuInstance menuInstance)  {

        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            PdfPCell menuInstanceHeaderCell;
            PdfPCell menuInstanceCell;
            PdfPCell menuItemInstanceHeaderCell;
            Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

            PdfPTable menuInstanceHeaderTable = new PdfPTable(3);
            menuInstanceHeaderTable.setWidthPercentage(100);
            menuInstanceHeaderTable.setWidths(new int[]{1, 4, 4});

            PdfPTable menuItemInstanceHeaderTable = new PdfPTable(3);
            menuItemInstanceHeaderTable.setWidthPercentage(100);
            menuItemInstanceHeaderTable.setWidths(new int[]{1, 4, 4});

            // Menu
            menuInstanceHeaderCell = new PdfPCell(new Phrase("ID", headFont));
            menuInstanceHeaderCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            menuInstanceHeaderTable.addCell(menuInstanceHeaderCell);

            menuInstanceHeaderCell = new PdfPCell(new Phrase("MENU NAME", headFont));
            menuInstanceHeaderCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            menuInstanceHeaderTable.addCell(menuInstanceHeaderCell);

            menuInstanceHeaderTable.completeRow();

            menuInstanceCell = new PdfPCell(new Phrase(menuInstance.getId().toString()));
            menuInstanceCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            menuInstanceCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            menuInstanceHeaderTable.addCell(menuInstanceCell);

            menuInstanceCell = new PdfPCell(new Phrase(menuInstance.getMenuName()));
            menuInstanceCell.setPaddingLeft(5);
            menuInstanceCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            menuInstanceCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            menuInstanceHeaderTable.addCell(menuInstanceCell);

            menuInstanceHeaderTable.completeRow();

            //Menu Items
            menuItemInstanceHeaderCell = new PdfPCell(new Phrase("ID", headFont));
            menuItemInstanceHeaderCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            menuItemInstanceHeaderTable.addCell(menuItemInstanceHeaderCell);

            menuItemInstanceHeaderCell = new PdfPCell(new Phrase("MENU ITEM", headFont));
            menuItemInstanceHeaderCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            menuItemInstanceHeaderTable.addCell(menuItemInstanceHeaderCell);

            menuItemInstanceHeaderCell = new PdfPCell(new Phrase("INGREDIENTS", headFont));
            menuItemInstanceHeaderCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            menuItemInstanceHeaderTable.addCell(menuItemInstanceHeaderCell);

            menuItemInstanceHeaderTable.completeRow();

            for (MenuItemInstance menuItemInstance : menuInstance.getMenuItemInstances()) {

                PdfPCell menuItemInstanceCell;

                menuItemInstanceCell = new PdfPCell(new Phrase(menuItemInstance.getId().toString()));
                menuItemInstanceCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                menuItemInstanceCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                menuItemInstanceHeaderTable.addCell(menuItemInstanceCell);

                menuItemInstanceCell = new PdfPCell(new Phrase(menuItemInstance.getItemName()));
                menuItemInstanceCell.setPaddingLeft(5);
                menuItemInstanceCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                menuItemInstanceCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                menuItemInstanceHeaderTable.addCell(menuItemInstanceCell);

                menuItemInstanceCell = new PdfPCell(new Phrase(String.valueOf(menuItemInstance.getIngredients())));
                menuItemInstanceCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                menuItemInstanceCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                menuItemInstanceCell.setPaddingRight(5);
                menuItemInstanceHeaderTable.addCell(menuItemInstanceCell);

                menuItemInstanceHeaderTable.completeRow();
            }
            PdfWriter.getInstance(document, out);
            document.open();
            document.add(menuInstanceHeaderTable);

            document.add(menuItemInstanceHeaderTable);
            document.close();

        } catch (DocumentException ex) {
            throw new RuntimeException("Error in Fetching Menu Pdf",ex);
        }

        return new ByteArrayInputStream(out.toByteArray());
    }


}
