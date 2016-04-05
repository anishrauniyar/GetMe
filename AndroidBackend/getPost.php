<?php

	if (mysql_connect("localhost", "root", "")) {
		mysql_select_db("getme_db");
		$username = $_GET['username'];
		$password = $_GET['password'];
		$query = "SELECT Role FROM usertable WHERE UserName='".$username."' and Password = '".$password."'";
		$result = mysql_query($query);
		$row = mysql_fetch_array($result);
		$data = $row[0];
		
		header('Content-Type: application/json');
		echo json_encode(array("role"=>$data));
		mysql_close();
		
	}
	

?>