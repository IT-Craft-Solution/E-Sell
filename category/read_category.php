<?php 

$con=mysqli_connect("localhost","root","","olxdb");

if(mysqli_connect_errno()){
	die("Connection failded : ".mysqli_connect_error());
}

$query="SELECT * FROM category" or die("Query Unsuccessfull");

$result= mysqli_query($con,$query)or die ("SQL Query Failed");


if(mysqli_num_rows($result)> 0){
	$output=mysqli_fetch_all($result,MYSQLI_ASSOC);
	echo json_encode($output);
}else{
	echo json_encode(array('message'=>'No record Found','status'=>false));
} 

?>