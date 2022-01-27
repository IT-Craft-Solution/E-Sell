<?php 

include('header.php');

$msg="";
$user_phone="";
$user_email="";
$user_img="";
$user_name="";
$user_bio="";
$user_location="";
$user_area="";
$user_status="";
$id="";

if(isset($_GET['id']) && $_GET['id']>0){
	$id=get_safe_value($_GET['id']);
	$row=mysqli_fetch_assoc(mysqli_query($con,"select * from user_details where id='$id'"));
	$user_phone=$row['phone'];
	$user_email=$row['email'];
    $user_img=$row['user_img'];
    $user_name=$row['user_name'];
    $user_bio=$row['user_bio'];
    $user_location=$row['location'];
    $user_area=$row['city_area'];
    $user_status=$row['status'];


if(isset($_POST['submit'])){
	$user_phone=get_safe_value($_POST['phone']);
	$user_email=get_safe_value($_POST['email']);
    $user_img=get_safe_value($_POST['user_img']);
    $user_name=get_safe_value($_POST['user_name']);
    $user_bio=get_safe_value($_POST['user_bio']);
    $user_location=get_safe_value($_POST['location']);
    $user_area=get_safe_value($_POST['city_area']);
    $user_status=get_safe_value($_POST['status']);
	$added_on=date('Y-m-d h:i:s');
	
	if($id==''){
		$sql="select * from user_details where phone='{$user_phone}' && email='{$user_email}'";
	}else{
		$sql="select * from user_details where phone='{$user_phone}' && email='{$user_email}'";
	}	
	if(mysqli_num_rows(mysqli_query($con,$sql))>0){
		$msg="User already added";
	}else{
		if($id==''){
			mysqli_query($con,"insert into user_details(phone,email,user_img,user_name,user_bio,location,city_area,status) values('{$user_phone}','{$user_email}','{$user_img}','{$user_name}','{$user_bio}','{$user_location}','{$user_area}','{$user_status}')")or die("Query Unsuceessfull");
		}else{
			mysqli_query($con,"update user_details set phone='{$user_phone}', email='{$user_email}' where id='$id'");
		}
		redirect('user.php');
	}
}
}
?>
<div class="row">
			<h1 class="grid_title ml10 ml15">Manage User</h1>
            
            <div class="col-12 grid-margin stretch-card">
              <div class="card">
                <div class="card-body">
                  <form class="forms-sample" method="post">
                    <div class="form-group">
                      <label for="exampleInputName1">Phone</label>
                      <input type="text" class="form-control" placeholder="user_phone" name="phone" value="<?php echo $user_name; ?>" />
                    </div>
                    <div class="form-group">
                      <label for="exampleInputName1">Email</label>
                      <input type="text" class="form-control" placeholder="user_email" name="email" value="<?php echo $user_email; ?>" />
                    </div>
                    <div class="form-group">
                      <label for="exampleInputName1">User Image</label>
                      <input type="text" class="form-control" placeholder="user_img" name="user_img" value="<?php echo $user_img; ?>" />
                    </div>
                    <div class="form-group">
                      <label for="exampleInputName1">Username</label> 
                      <input type="text" class="form-control" placeholder="user_name" name="user_name" value="<?php echo $user_name; ?>" />
                    </div>
                    <div class="form-group">
                      <label for="exampleInputName1">User Bio</label>
                      <input type="text" class="form-control" placeholder="user_bio" name="user_bio" value="<?php echo $user_bio; ?>" />
                    </div>
                    <div class="form-group">
                      <label for="exampleInputName1">Location</label>
                      <input type="text" class="form-control" placeholder="user_location" name="location" value="<?php echo $user_location; ?>" >
                    </div>
                    <div class="form-group">
                      <label for="exampleInputName1">City Area</label>
                      <input type="text" class="form-control" placeholder="user_area" name="city_area" value="<?php echo $user_area; ?>" />
                    </div>
                    <div class="form-group">
                      <label for="exampleInputName1">Status</label>
                      <input type="text" class="form-control" placeholder="user_status" name="status" value="<?php echo $user_status; ?>" />
                    </div>
                    <button type="submit" class="btn btn-primary mr-2" name="submit">Submit</button>
                  </form>
                </div>
              </div>
            </div>
            
		 </div>
         <?php include('footer.php'); ?>