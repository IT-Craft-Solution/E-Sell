<?php

$conn=mysqli_connect("localhost","root","","olxdb");

if(mysqli_connect_errno()){
	die("Connection failded : ".$conn->connect_error);
}

$post_name=$_POST['cat_name'];
$post_title=$_POST['title'];
$post_desc=$_POST['description'];
$post_price=$_POST['price'];
$post_location=$_POST['location'];
$post_city_area=$_POST['city_area'];
$post_image=$_POST['item_img'];
$post_status=$_POST['status'];
$id=$_POST['id'];

$query="update sell set cat_name='{$post_name}',title='{$post_title}',description='{$post_desc}',price='{$post_price}',location='{$post_location}', city_area='{$post_city_area}',item_img='{$post_image}', status='{$post_status}' where id='{$id}'" or die("Query unsucessfull");
  
if(mysqli_query($conn, $query)){
	echo json_encode(array("status"=>"true","message"=>"Post successfully Updated"));
}else{
	echo json_encode(array("status"=>"false","message"=>"Post successfully Not Updated"));
}

?>