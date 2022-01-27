<?php

$conn=mysqli_connect("localhost","root","","olxdb");

if(mysqli_connect_errno()){
	die("Connection failded : ".mysqli_connect_error());
}

$post_name=$_POST['cat_name'];
$post_title=$_POST['title'];
$post_desc=$_POST['description'];
$post_price=$_POST['price'];
$post_location=$_POST['location'];
$post_city_area=$_POST['city_area'];
$post_image=$_POST['item_img'];
$post_status=$_POST['status'];

$query="insert into sell(cat_name,title,description,price,location,city_area,item_img,status) values('{$post_name}','{$post_title}','{$post_desc}','{$post_price}','{$post_location}','{$post_city_area}','{$post_image}','{$post_status}')";

if(mysqli_query($conn,$query)){
echo json_encode(array('message'=>'Record inserted','status'=>true));

}else{
    echo json_encode(array('message'=>'Record Not inserted','status'=>false));
}

?>