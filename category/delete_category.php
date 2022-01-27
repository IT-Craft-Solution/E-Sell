<?php

$conn=mysqli_connect("localhost","root","","olxdb");

if(mysqli_connect_errno()){
	die("Connection failded : ".mysqli_connect_error());
}

$p_id=$_POST['id'];


$query="DELETE FROM category WHERE id={$p_id}";

if(mysqli_query($conn, $query)){
	echo json_encode(array("status"=>"true","message"=>"Category successfully Deleted"));
}else{
	echo json_encode(array("status"=>"false","message"=>"Category successfully Not Deleted"));
}


?>