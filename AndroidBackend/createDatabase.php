<?php

	$con = mysql_connect("localhost", "root", "");
	$sql = "CREATE DATABASE getme_db";
	if (mysql_query($con, $sql)) {
		echo "Database created successfully";
	}

?>