package com.fanniemae.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBTestData {
	
	
	public void FetchDBData() throws Exception{
		 
		 String connectionString=null;
		 String DBSqlServerDriver=null;
		 String sqlQuery=null;
		 
		 String DBDataInLocalArray[][]=null;
		 int numOfRows = 0;
		
		 connectionString = "jdbc:sqlserver://sql2k801.discountasp.net:1433;databasename=SQL2008_841902_tr;user=SQL2008_841902_tr_user;password=52645264hrm";
		 DBSqlServerDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	 
		 sqlQuery="select * from TRCustTestData order by CustFirstName";
		 
	 try{
			 
			 Class.forName(DBSqlServerDriver);
			 Connection oConn = DriverManager.getConnection(connectionString);
			 Statement oStmt = oConn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			 
			 ResultSet oRslt =   oStmt.executeQuery(sqlQuery);
			 
			 oRslt.last();
			 numOfRows =  oRslt.getRow();
			 
			 System.out.println("Total Records from DB: " + numOfRows);
			 oRslt.beforeFirst();
			 
			 
			 
			 DBDataInLocalArray = new String[numOfRows][6];
			 
			 int i=0;
			 while(oRslt.next()){
				 
				 System.out.println("Reading from DB: " + oRslt.getString("CustFirstName"));
				 DBDataInLocalArray[i][0] =   oRslt.getString("CustFirstName");
				 
				 System.out.println("Reading from DB: " + oRslt.getString("CustLastName"));
				 DBDataInLocalArray[i][1] =   oRslt.getString("CustLastName");
				 
				 System.out.println("Reading from DB: " + oRslt.getString("CustEmail"));
				 DBDataInLocalArray[i][2] =   oRslt.getString("CustEmail");
				 
				 System.out.println("Reading from DB: " + oRslt.getString("CustPassword"));
				 DBDataInLocalArray[i][3] =   oRslt.getString("CustPassword");
				 
				 System.out.println("Reading from DB: " + oRslt.getString("CustHomePhone"));
				 DBDataInLocalArray[i][4] =   oRslt.getString("CustHomePhone");
				 
				 System.out.println("Reading from DB: " + oRslt.getString("CustInstructions"));
				 DBDataInLocalArray[i][5] =   oRslt.getString("CustInstructions");
				 i=i+1;
			 }
			 
			// oRslt.close();
			// oConn.close();
			 
		 }
		 catch(Exception e){
			 System.err.println("Error occured while connecting to the DB: " + e.getMessage());
		 }
		 
		 
	 }

}
