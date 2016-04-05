<?php

	mysql_connect("localhost", "root", "");
	mysql_select_db("getme_db");
	$senderusername = $_GET['senderusername'];
	$recieverusername = $_GET['recieverusername'];
	$query = "INSERT INTO senderreceivertable (SenderUsername, RecieverUsername, Date) 
			VALUES ('".$senderusername."', '".$recieverusername."', now())";
	echo($query);
	if (mysql_query($query)){
		echo "Value has been inserted";
	} else {
		echo "Value cant be inserted";
	}

?>