<?php

$conn=mysqli_connect("localhost","root","","olxdb");

if(mysqli_connect_errno()){
	die("Connection failded : ".mysqli_connect_error());
}

$query="SELECT * FROM user_details";

$result= mysqli_query($conn,$query)or die ("SQL Query Failed");


if(mysqli_num_rows($result)> 0){
	$output=mysqli_fetch_all($result,MYSQLI_ASSOC);
	echo json_encode($output);
}else{
	echo json_encode(array('message'=>'No record Found','status'=>false));
}


?>
