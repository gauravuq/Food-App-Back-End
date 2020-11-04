INSERT INTO MENU_INSTANCE(ID,Menu_Name,Created_By,Updated_By,last_Updated_Date,created_Date)VALUES(1000,'Lunch','Gaurav Sood','N/A',sysdate,sysdate);
INSERT INTO MENU_INSTANCE(ID,Menu_Name,Created_By,Updated_By,last_Updated_Date,created_Date)VALUES(1001,'Bara Kahana','Gaurav Sood','N/A',sysdate,sysdate);


INSERT INTO MENU_ITEM_INSTANCE(ID,Item_Name,Menu_Instance_Id,Created_By,Updated_By,last_Updated_Date,created_Date,Ingredients) VALUES (2000,'Item1',1000,'Gaurav Sood','N/A',sysdate,sysdate,'I1,I2,I3');
INSERT INTO MENU_ITEM_INSTANCE(ID,Item_Name,Menu_Instance_Id,Created_By,Updated_By,last_Updated_Date,created_Date,Ingredients) VALUES (2001,'Item2',1000,'Gaurav Sood','N/A',sysdate,sysdate,'I3,I4,I6');