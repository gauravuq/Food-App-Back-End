

INSERT INTO ORDER_INSTANCE(ID,Order_Customer_Name,Order_Customer_Email,Order_Menu_Type,Order_For_Date,Order_Customer_Room,Created_By,Updated_By,last_Updated_Date,created_Date)VALUES(3000,'Gaurav Sood','X1XXXX@gmail.com','Lunch','2020-11-24','D1.2','Gaurav Sood','N/A',sysdate,sysdate);
INSERT INTO ORDER_INSTANCE(ID,Order_Customer_Name,Order_Customer_Email,Order_Menu_Type,Order_For_Date,Order_Customer_Room,Created_By,Updated_By,last_Updated_Date,created_Date)VALUES(3001,'Shakti Kumar','X2XXXX@gmail.com','Lunch','2020-11-25','F1.3','Gaurav Sood','N/A',sysdate,sysdate);


INSERT INTO ORDER_ITEM_INSTANCE(ID,Order_Item_Name,Order_Instance_Id,Order_Item_Type,Order_Item_Quantity,Created_By,Updated_By,last_Updated_Date,created_Date) VALUES (4000,'Item1',3000,'Main Course',1,'Gaurav Sood','N/A',sysdate,sysdate);
INSERT INTO ORDER_ITEM_INSTANCE(ID,Order_Item_Name,Order_Instance_Id,Order_Item_Type,Order_Item_Quantity,Created_By,Updated_By,last_Updated_Date,created_Date) VALUES (4001,'Item2',3000,'Sweet Dish',1,'Gaurav Sood','N/A',sysdate,sysdate);
INSERT INTO ORDER_ITEM_INSTANCE(ID,Order_Item_Name,Order_Instance_Id,Order_Item_Type,Order_Item_Quantity,Created_By,Updated_By,last_Updated_Date,created_Date) VALUES (4002,'Item3',3001,'Main Course',1,'Shakti Kumar','N/A',sysdate,sysdate);
INSERT INTO ORDER_ITEM_INSTANCE(ID,Order_Item_Name,Order_Instance_Id,Order_Item_Type,Order_Item_Quantity,Created_By,Updated_By,last_Updated_Date,created_Date) VALUES (4003,'Item4',3001,'Sweet Dish',1,'Shakti Kumar','N/A',sysdate,sysdate);


