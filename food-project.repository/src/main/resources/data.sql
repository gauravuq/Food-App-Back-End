

INSERT INTO MENU_INSTANCE(ID,Menu_Name,Menu_Type,Menu_For_Date,Order_Time_Limit,Created_By,Updated_By,last_Updated_Date,created_Date)VALUES(1000,'LUNCH','LUNCH','2020-11-24','03:00:00','Gaurav Sood','N/A',sysdate,sysdate);
INSERT INTO MENU_INSTANCE(ID,Menu_Name,Menu_Type,Menu_For_Date,Order_Time_Limit,Created_By,Updated_By,last_Updated_Date,created_Date)VALUES(1001,'Bara Kahana','LUNCH','2020-11-25','03:00:00','Gaurav Sood','N/A',sysdate,sysdate);


INSERT INTO MENU_ITEM_INSTANCE(ID,Item_Name,Item_Type,Menu_Instance_Id,Created_By,Updated_By,last_Updated_Date,created_Date,Ingredients,Item_Max_Limit) VALUES (2000,'Chicken Biryani','Main Course',1000,'Gaurav Sood','N/A',sysdate,sysdate,'I1,I2,I3',1);
INSERT INTO MENU_ITEM_INSTANCE(ID,Item_Name,Item_Type,Menu_Instance_Id,Created_By,Updated_By,last_Updated_Date,created_Date,Ingredients,Item_Max_Limit) VALUES (2001,'Cola','Drink',1000,'Gaurav Sood','N/A',sysdate,sysdate,'I3,I4,I6',1);
INSERT INTO MENU_ITEM_INSTANCE(ID,Item_Name,Item_Type,Menu_Instance_Id,Created_By,Updated_By,last_Updated_Date,created_Date,Ingredients,Item_Max_Limit) VALUES (2002,'Juice','Drink',1000,'Gaurav Sood','N/A',sysdate,sysdate,'I3,I4,I6',1);
INSERT INTO MENU_ITEM_INSTANCE(ID,Item_Name,Item_Type,Menu_Instance_Id,Created_By,Updated_By,last_Updated_Date,created_Date,Ingredients,Item_Max_Limit) VALUES (2003,'Grilled Lamb Chops','Main Course',1000,'Gaurav Sood','N/A',sysdate,sysdate,'I3,I4,I6',1);
INSERT INTO MENU_ITEM_INSTANCE(ID,Item_Name,Item_Type,Menu_Instance_Id,Created_By,Updated_By,last_Updated_Date,created_Date,Ingredients,Item_Max_Limit) VALUES (2004,'Beans','Veg Main Course',1000,'Gaurav Sood','N/A',sysdate,sysdate,'I3,I4,I6',1);
INSERT INTO MENU_ITEM_INSTANCE(ID,Item_Name,Item_Type,Menu_Instance_Id,Created_By,Updated_By,last_Updated_Date,created_Date,Ingredients,Item_Max_Limit) VALUES (2005,'Chicken Chops','Main Course',1001,'Gaurav Sood','N/A',sysdate,sysdate,'I1,I2,I3',1);
INSERT INTO MENU_ITEM_INSTANCE(ID,Item_Name,Item_Type,Menu_Instance_Id,Created_By,Updated_By,last_Updated_Date,created_Date,Ingredients,Item_Max_Limit) VALUES (2006,'Cake','Dessert',1001,'Gaurav Sood','N/A',sysdate,sysdate,'I3,I4,I6',1);