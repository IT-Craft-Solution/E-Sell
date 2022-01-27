<?php

$conn=mysqli_connect("localhost","root","","olxdb");

if(mysqli_connect_errno()){
	die("Connection failded : ".$conn->connect_error);
}

$user_phone=$_POST['phone'];
$user_email=$_POST['email'];
$user_img=$_POST['user_img'];
$user_name=$_POST['user_name'];
$user_bio=$_POST['user_bio'];
$user_location=$_POST['location'];
$user_area=$_POST['city_area'];
$user_status=$_POST['status'];
$id=$_POST['id'];

$query="update user_details set phone='{$user_phone}', email='{$user_email}', user_img='{$user_img}',user_name='{$user_name}',user_bio='{$user_bio}',location='{$user_location}',city_area='{$user_area}',status='{$user_status}' where id='$id'";
  
if(mysqli_query($conn, $query)){
	echo json_encode(array("status"=>"true","message"=>"User successfully Updated"));
}else{
	echo json_encode(array("status"=>"false","message"=>"User successfully Not Updated"));
}


?>