package databasePackage;

public final class DBInfo {
	//DB 
	static final String DB_NAME="librarymanagementsystem";
	static final String DRIVER ="com.mysql.cj.jdbc.Driver";
	static final String DB_URL ="jdbc:mysql://localhost/librarymanagementsystem";
	static final String DB_USERNAME ="root";
	static final String DB_PASSWORD="1234";
	
	//Table Names
	static final String ADMIN_TABLE="Admin";
	static final String AUTHOR_TABLE="Author";
	static final String BOOK_TABLE="Book";
	static final String USER_TYPE ="UserType";
	static final String USER_TABLE="User";
	static final String BOOK_USER_ASSOCIATION_TABLE="BookUserAssociation";
	
	//Create Table queries
	static final String CREATE_ADMIN_TABLE = "create table "+ ADMIN_TABLE +"(Id int primary key NOT NULL auto_increment,userName varchar(20) NOT NULL,password varchar(20) NOT NULL,date_created datetime)";
	static final String CREATE_AUTHOR_TABLE = "create table "+ AUTHOR_TABLE +"(Id int primary key auto_increment NOT NULL, Name varchar(20))";
	static final String CREATE_BOOK_TABLE = "create table "+ BOOK_TABLE +"(Id int primary key NOT NULL auto_increment,Quantity int,Name varchar(20),Price int,Price_loan int,authorId int,foreign key (authorId) references "+ AUTHOR_TABLE +"(Id))";
	static final String CREATE_USER_TYPE = "create table "+ USER_TYPE +"(Id int primary key NOT NULL auto_increment,Type varchar(20))";
	static final String CREATE_USER_TABLE = "create table "+ USER_TABLE +"(Id int primary key NOT NULL auto_increment,Name varchar(20),Email varchar(30) unique,userType_id int,foreign key (userType_id) references "+ USER_TYPE +"(Id))";
	static final String CREATE_BOOK_USER_ASSOCIATION_TABLE = "create table "+ BOOK_USER_ASSOCIATION_TABLE +"(Id int primary key NOT NULL auto_increment,user_id int,book_id int,Quantity int,Price int,foreign key (user_id) references "+ USER_TABLE +"(Id),foreign key (book_id) references "+ BOOK_TABLE +"(Id))";
	
	//select
	
	
	//insert
	
	//UserType Data
	static final String[] USER_TYPES = new String[] {"Student","Teacher"};
	
}
