<?php

$conn=mysqli_connect("localhost","root","","olxdb");

if(mysqli_connect_errno()){
	die("Connection failded : ".mysqli_connect_error());
}


$category_name=$_POST['cat_name'];
$category_img=$_POST['cat_img'];
$category_status=$_POST['status'];


$query="insert into category(cat_name,cat_img,status) values('{$category_name}','{$category_img}','{$category_status}')" or die("query insert filed");

if(mysqli_query($conn,$query)){
echo json_encode(array('message'=>'Record inserted','status'=>true));

}else{
    echo json_encode(array('message'=>'Record Not inserted','status'=>false));
}


?>