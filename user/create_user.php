<?php

$conn=mysqli_connect("localhost","root","","olxdb");

if(mysqli_connect_errno()){
	die("Connection failded : ".mysqli_connect_error());
}

$user_phone=$_POST['phone'];
$user_email=$_POST['user_email'];
$user_img=$_POST['user_img'];
$user_name=$_POST['user_name'];
$user_bio=$_POST['user_bio'];
$user_location=$_POST['user_location'];
$user_area=$_POST['user_area'];
$user_status=$_POST['user_status'];

$query="insert into user_details(phone,email,user_img,user_name,user_bio,location,city_area,status) values('{$user_phone}','{$user_email}','{$user_img}','{$user_name}','{$user_bio}','{$user_location}','{$user_area}','{$user_status}')";

if(mysqli_query($conn,$query)){
echo json_encode(array('message'=>'Record inserted','status'=>true));

}else{
    echo json_encode(array('message'=>'Record Not inserted','status'=>false));
}


?>