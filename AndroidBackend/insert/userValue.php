<?php

	mysql_connect("localhost", "root", "");
	mysql_select_db("getme_db");
	$firstname = $_GET['firstname'];
	$lastname = $_GET['lastname'];
	$username = $_GET['username'];
	$email = $_GET['email'];
	$password = $_GET['password'];
	$role = $_GET['role'];
 	$query = "INSERT INTO usertable (FirstName, LastName, UserName, Email, Password, Role, Date) 
			VALUES ('".$firstname."', '".$lastname."', '".$username."', '".$email."', '".$password."', '".$role."', now())";
	echo($query);
	if (mysql_query($query)){
		echo "Value has been inserted";
	} else {
		echo "Value cant be inserted";
	}

?>