/*
 * 	JDBC is an API for the JAVA programming language that defines how a client may access a Database
 *  
 *  
 *  JDBC API uses JDBC driver to connect with the database
 *  
 *  Released by Sun Micro System in 1997 as a part of JDK 1.1
 *  The JDBC classes are contained in a java package  - java.sql and javax.sql
 *  
 */

/*
 * 	Architecture of JDBC
 * 		      Two Tier Architecture
 * 			  --------------------	
 * 			  |	Java Application |
 * 			  |  --------------	 |	Client Machine
 * 			  |  |    JDBC	  |  |
 *			  |  --------------	 |
 *			  --------------------
 *						|
 *						|    DBMS - proprietary protocol
 *					---------
 *					|		|
 *					|  DB	|
 *					|		|
 *					---------	
 * 		/////////////////////////////////////////////////////
 * 
 * 			 Three Tier Architecture
 * 
 * 				 Java Application    Client Machine(GUI)
 * 						|
 * 						|
 * 						| 	
 * 			  ---------------------	
 * 			  |	Application Server|
 * 			  |      (Java)       |	
 * 			  |  --------------	  |	 Server machine
 * 			  |  |    JDBC	  |   |	 (Business Logic/Middle Tier)	
 *			  |  --------------	  |
 *			  ---------------------
 *						|
 *						|    DBMS - proprietary protocol
 *					---------
 *					|		|
 *					|  DB	|
 *					|		|
 *					---------
 */

/*
 * 	 so Architecture of JDBC consists of two layers
 * 		JDBC API
 * 			provides an application to JDBC Manager Connection
 * 		JDBC Driver API
 * 			supports the JDBC Manager-to-Driver Connection
 */

/*
 * 	Whenever a Java App has to interact with any database using JDBC, it uses JDBC api which 
 * 	which provides the application to JDBC Manager Connection. JDBC API uses a Driver Manager
 * 	and data specific drivers to provide the database specific connectivity to heterogenous
 * 	databases.The Driver Manager is capable of supporting multiple concurrent drivers 
 * 	connected to multiple heterogenous databases. The JDBC Driver API which supports the JDBC database
 * 	connectivity, are provided by various database vendors.i.e.,
 * 			Oracle JDBC Driver API for 	Oracle
 * 			SQL Server JDBC Driver API for SQL
 * 			JDBC Driver API for MYSQL, et cetera.
 */

/*
 * 	Role of Driver Manager
 * 		The basic service for managing a set of jdbc drivers
 * 		it is used to match a connection request from a java program with a speicfic 
 * 		driver using the communication sub-protocol.
 */

/*
 * 	How Driver Manager Works?
 * 		First step is loading the relevant driver to the Driver Manager.
 * 			for Mysql(  Class.forName("com.mysql.jdbc.Driver");  )
 * 			for Oracle(  Class.forName("oracle.jdbc.driver.OracleDriver");  )
 * 			for Sql(  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  )
 * 
 * 	The Driver Manager methods from Driver Manager updates from JDBC 4.0
 * 		getConnection and getDrivers methods have been enhanced
 * 		No need to load JDBC explicitly using ClassforName from 4.0
 */

/*
 * 	Understanding JDBC Driver Types
 * 		A JDBC driver is a set of Java cases that implement the JDBC interfaces, targeting 
 * 		a specific Database.
 * 		The JDBC interfaces comes with standard Java
 * 		
 * 		Types of JDBC drivers
 * 			Type 1 : JDBC-ODBC bridge
 * 			Type 2 : Native-API driver
 * 			Type 3 : Network-Protocol driver(Middleware driver)
 * 			Type 4 : Database-Protocol driver(Pure Java driver)
 * 
 */

/*
 * 	Type 1 : JDBC-ODBC bridge
 * 		Whenever a java application uses a JDBC connection it uses an ODBC driver to connect the
 * 		database. JDBC ODBC bridge driver converts JDBC method calls into the ODBC calls and
 * 		redirects the request to ODBC driver. ODBC driver converts the ODBC calls into native 
 * 		native database specific calls using the vendor database library and redirects the request
 * 		to the database for processing. 
 * 		
 * 		Advantages
 * 			It is very easy to use
 * 			Almost any database is supported
 * 			
 * 		Limitations
 * 			Performance will not be efficient
 * 			ODBC Driver needs to be installed
 * 			Type 1 drivers are not portable
 * 			Not suitable for Applets
 */

/*
 * 	Type 2 : Native-API driver
 * 		Here the native-API driver converts the JDBC method calls into native API calls
 * 		of the database using the client side libraries of the database
 * 		
 * 		Advantages
 * 			Faster than Type 1 Driver
 * 		
 * 		Limitations
 * 			Client Side Library is not available for all databases
 * 			Vendor Client Library needs to be installed
 * 			It is a Platform Dependent
 * 			Not Thread Safe
 */

/*
 * 	Type 3 : Network-Protocol driver(Middleware driver)
 * 		It converts the JDBC calls into a database server independent and Middleware 
 * 		specific calls, and that will be passed to the Middleware. Middleware, which acts
 * 		like an application server, converts the Middleware server specific calls into 
 * 		database specific calls.
 * 
 * 		Advantages
 * 			No additional library installation is required on client system
 * 			No changes are required at client for any DB
 * 			Supports Caching of Connection, Query Results, Load Balancing, Logging and Auditing etc.
 * 			A Single Driver can handle any database provided the middleware supports it
 * 
 * 		Limitations
 * 			Performance will be slow
 * 			Requires Database-specific coding
 * 			Maintenance of Network Protocol driver becomes costly
 * 			
 */

/*
 * 	Type 4 : Database-Protocol driver(Pure Java driver)
 * 		Here the JDBC method calls will be passed to the Native Protocol driver, which converts the JDBC calls directly 
 * 		into a vendor specific database protocol. As the database protocol is vendor speicfic
 * 		the JDBC client requires separate drivers, usually vendor supplied to connect to different types of databases.
 * 		For example Oracle Thin Driver
 * 
 * 		Advantages
 * 			Platform Independent
 * 			No intermediate format is required 
 * 			Application connects directly to the database server
 * 			Performance will be very fast
 * 			JVM manages all aspects
 * 
 *  	Limitations
 *  		Drivers are database dependent	
 */

/*
 * 								OVERVIEW
 * 		
 * 		If you are accessing one type of database such as Oracle,SQL Server,MYSQL etc. then the preferred driver type is 4
 * 		If your Java application is accessing multiple types of databases at the same time, type 3 is the preferred driver
 * 		Type 2 drivers are useful in situations where a type 3 or type 4 is not available yet for your database
 * 		The type 1 driver is not considered a deployment-level driver and it is typically use for development and testing purposes only
 * 
 */

package onlineCoaching.course3.JDBC;

public class Introduction {
	
}
















