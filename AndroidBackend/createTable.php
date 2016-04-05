<?php

	mysql_connect("localhost", "root", "");
	mysql_select_db("getme_db");

	//User Table
	$usertable = "CREATE TABLE userTable 
				(UID INT(10) NOT NULL AUTO_INCREMENT,
				FirstName VARCHAR(30),
				LastName VARCHAR(30),
				UserName VARCHAR(50),
				Email VARCHAR(200),
				Password VARCHAR(50),
				Role VARCHAR(50),
				DATE,PRIMARY KEY(UID))";
	if (mysql_query($usertable)) {
		echo "User Table have been created successfully";
	} else {
		echo "User Table couldn't be created";
	}

	//Sender Reciever Table
	$senderRecievertable = "CREATE TABLE senderReceiverTable (
							SRID INT(10) NOT NULL AUTO_INCREMENT,
							SenderUsername VARCHAR(50),
							RecieverUSername VARCHAR(50),
							Date DATE,
							PRIMARY KEY(SRID))";
	if (mysql_query($senderRecievertable)) {
		echo "Sender Reciever Table have been created successfully";
	} else {
		echo "Sender Reciever Table couldn't be created";
	}

	//Location Info Table
	$locationInfotable = "CREATE TABLE locationInfoTable (
						SRID INT(10),
						XCoordinate FLOAT,
						YCoordinate FLOAT,
						Title VARCHAR(100),
						Description VARCHAR(600),
						FOREIGN KEY(SRID) REFERENCES senderReceiverTable(SRID)
						)";
	if (mysql_query($locationInfotable)) {
		echo "Location Info Table have been created successfully";
	} else {
		echo "Location Info Table couldn't be created";
	}

?>