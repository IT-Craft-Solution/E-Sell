<?php

$conn=mysqli_connect("localhost","root","","olxdb");

if(mysqli_connect_errno()){
	die("Connection failded : ".$conn->connect_error);
}

$category_name=$_POST['cat_name'];
$category_img=$_POST['cat_img'];
$id=$_POST['id'];
$category_status=$_POST['status'];


$query="update category set cat_name='{$category_name}', cat_img='{$category_img}', status='{$category_status}' where id='$id'" or die("query update filed");
  
if(mysqli_query($conn, $query)){
	echo json_encode(array("status"=>"true","message"=>"Category successfully Updated"));
}else{
	echo json_encode(array("status"=>"false","message"=>"Category successfully Not Updated"));
}


?>