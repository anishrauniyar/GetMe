<?php

	mysql_connect("localhost", "root", "");
	mysql_select_db("getme_db");
	$srid = $_GET['srid'];
	$xcoordinate = $_GET['xcoordinate'];
	$ycoordinate = $_GET['ycoordinate'];
	$title = $_GET['title'];
	$description = $_GET['description'];
 	$query = "INSERT INTO locationinfotable (SRID, XCoordinate, YCoordinate, Title, Description) 
			VALUES ('".$srid."', '".$xcoordinate."', '".$ycoordinate."', '".$title."', '".$description."')";
	echo($query);
	if (mysql_query($query)){
		echo "Value has been inserted";
	} else {
		echo "Value cant be inserted";
	}

?>