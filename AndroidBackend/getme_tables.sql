CREATE TABLE userTable (
	UID INT(10) NOT NULL AUTO_INCREMENT,
	FirstName VARCHAR(30),
	LastName VARCHAR(30),
	UserName VARCHAR(50),
	Email VARCHAR(200),
	Password VARCHAR(50),
	Role VARCHAR(50),
	Date DATE,
	PRIMARY KEY(UID)
);

CREATE TABLE senderReceiverTable (
	SRID INT(10) NOT NULL AUTO_INCREMENT,
	SenderUsername VARCHAR(50),
	RecieverUSername VARCHAR(50),
	isSave VARCHAR(1),
	Date DATE,
	PRIMARY KEY(SRID)
);

CREATE TABLE locationInfoTable (
	SRID INT(10),
	XCoordinate FLOAT,
	YCoordinate FLOAT,
	Title VARCHAR(100),
	Description VARCHAR(600),
	FOREIGN KEY(SRID) REFERENCES senderReceiverTable(SRID)
);

/*

Map
http://code.tutsplus.com/tutorials/getting-started-with-google-maps-for-android-basics--cms-24635

Path
http://stackoverflow.com/questions/14710744/how-to-draw-road-directions-between-two-geocodes-in-android-google-map-v2

API Key
https://console.developers.google.com/apis/credentials?project=getme-1238

*/
