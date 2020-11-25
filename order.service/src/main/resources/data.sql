

INSERT INTO ORDER_INSTANCE(ID,Order_Customer_Name,Order_Menu_Type,Order_For_Date,Created_By,Updated_By,last_Updated_Date,created_Date)VALUES(3000,'Gaurav Sood','Lunch','2020-11-24','Gaurav Sood','N/A',sysdate,sysdate);
INSERT INTO ORDER_INSTANCE(ID,Order_Customer_Name,Order_Menu_Type,Order_For_Date,Created_By,Updated_By,last_Updated_Date,created_Date)VALUES(3001,'Shakti Kumar','Lunch','2020-11-25','Gaurav Sood','N/A',sysdate,sysdate);


INSERT INTO ORDER_ITEM_INSTANCE(ID,Order_Item_Name,Order_Instance_Id,Order_Item_Type,Order_Item_Quantity,Created_By,Updated_By,last_Updated_Date,created_Date) VALUES (4000,'Item1',3000,'Main Course',1,'Gaurav Sood','N/A',sysdate,sysdate);
INSERT INTO ORDER_ITEM_INSTANCE(ID,Order_Item_Name,Order_Instance_Id,Order_Item_Type,Order_Item_Quantity,Created_By,Updated_By,last_Updated_Date,created_Date) VALUES (4001,'Item2',3000,'Sweet Dish',1,'Gaurav Sood','N/A',sysdate,sysdate);
INSERT INTO ORDER_ITEM_INSTANCE(ID,Order_Item_Name,Order_Instance_Id,Order_Item_Type,Order_Item_Quantity,Created_By,Updated_By,last_Updated_Date,created_Date) VALUES (4002,'Item3',3001,'Main Course',1,'Shakti Kumar','N/A',sysdate,sysdate);
INSERT INTO ORDER_ITEM_INSTANCE(ID,Order_Item_Name,Order_Instance_Id,Order_Item_Type,Order_Item_Quantity,Created_By,Updated_By,last_Updated_Date,created_Date) VALUES (4003,'Item4',3001,'Sweet Dish',1,'Shakti Kumar','N/A',sysdate,sysdate);



INSERT INTO ORDER_ITEM_INSTANCE_RULES(ID,Order_Menu_Type,Order_Item_Type,Max_Limit,Created_By,Updated_By,last_Updated_Date,Created_Date) VALUES (5000,'Lunch','Item1',1,'Gaurav Sood','N/A',sysdate,sysdate);
INSERT INTO ORDER_ITEM_INSTANCE_RULES(ID,Order_Menu_Type,Order_Item_Type,Max_Limit,Created_By,Updated_By,last_Updated_Date,Created_Date) VALUES (5001,'Lunch','Item2',1,'Gaurav Sood','N/A',sysdate,sysdate);

