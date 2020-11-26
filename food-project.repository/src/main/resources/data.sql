

INSERT INTO MENU_INSTANCE(ID,Menu_Name,Menu_Type,Menu_For_Date,Order_Time_Limit,Created_By,Updated_By,last_Updated_Date,created_Date)VALUES(1000,'Lunch','Lunch','2020-11-24','03:00:00','Gaurav Sood','N/A',sysdate,sysdate);
INSERT INTO MENU_INSTANCE(ID,Menu_Name,Menu_Type,Menu_For_Date,Order_Time_Limit,Created_By,Updated_By,last_Updated_Date,created_Date)VALUES(1001,'Bara Kahana','Lunch','2020-11-25','03:00:00','Gaurav Sood','N/A',sysdate,sysdate);


INSERT INTO MENU_ITEM_INSTANCE(ID,Item_Name,Menu_Instance_Id,Created_By,Updated_By,last_Updated_Date,created_Date,Ingredients,Item_Max_Limit) VALUES (2000,'Item1',1000,'Gaurav Sood','N/A',sysdate,sysdate,'I1,I2,I3',1);
INSERT INTO MENU_ITEM_INSTANCE(ID,Item_Name,Menu_Instance_Id,Created_By,Updated_By,last_Updated_Date,created_Date,Ingredients,Item_Max_Limit) VALUES (2001,'Item2',1000,'Gaurav Sood','N/A',sysdate,sysdate,'I3,I4,I6',1);
INSERT INTO MENU_ITEM_INSTANCE(ID,Item_Name,Menu_Instance_Id,Created_By,Updated_By,last_Updated_Date,created_Date,Ingredients,Item_Max_Limit) VALUES (2002,'Item3',1001,'Gaurav Sood','N/A',sysdate,sysdate,'I1,I2,I3',1);
INSERT INTO MENU_ITEM_INSTANCE(ID,Item_Name,Menu_Instance_Id,Created_By,Updated_By,last_Updated_Date,created_Date,Ingredients,Item_Max_Limit) VALUES (2003,'Item4',1001,'Gaurav Sood','N/A',sysdate,sysdate,'I3,I4,I6',1);