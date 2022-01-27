<?php 
include('header.php');
$msg="";
$admin_name="";
$admin_username="";
$admin_pass="";
$admin_email="";
$id="";

if(isset($_GET['id']) && $_GET['id']>0){
	$id=get_safe_value($_GET['id']);
	$row=mysqli_fetch_assoc(mysqli_query($con,"select * from admin where id='$id'"));
	$admin_name=$row['name'];
	$admin_username=$row['username'];
    $admin_pass=$row['password'];
    $admin_email=$row['email'];
}

if(isset($_POST['submit'])){
	$admin_name=get_safe_value($_POST['name']);
	$admin_username=get_safe_value($_POST['username']);
    $admin_pass=get_safe_value($_POST['password']);
    $admin_email=get_safe_value($_POST['email']);
	$added_on=date('Y-m-d h:i:s');
	
	if($id==''){
		$sql="select * from admin where name='$admin_name' or username='$admin_username'";
	}else{
		$sql="select * from admin where name='$admin_name' or username='$admin_username'";
	}	
	if(mysqli_num_rows(mysqli_query($con,$sql))>0){
		$msg="Admin already added";
	}else{
		if($id==''){
			mysqli_query($con,"insert into admin(name,username,password,email) values('{$admin_name}','{$admin_username}','{$admin_pass}','{$admin_email}')");
		}else{
			mysqli_query($con,"update admin set name='$admin_name', username='$admin_username' where id='$id'");
		}
		
		redirect('admin.php');
	}
}
?>

<div class="row">
			<h1 class="grid_title ml10 ml15">Manage User</h1>
            
            <div class="col-12 grid-margin stretch-card">
              <div class="card">
                <div class="card-body">
                  <form class="forms-sample" action="save_admin.php" method="post">
                    <div class="form-group">
                      <label for="exampleInputName1">Admin Name</label>
                      <input type="text" class="form-control" placeholder="admin_name" name="admin_name"/>
                    </div>
                    <div class="form-group">
                      <label for="exampleInputName1">UserName</label>
                      <input type="text" class="form-control" placeholder="admin_username" name="admin_username"/>
                    </div>
                    <div class="form-group">
                      <label for="exampleInputName1">Password</label>
                      <input type="password" class="form-control" placeholder="admin_pass" name="admin_pass"/>
                    </div>
                    <div class="form-group">
                      <label for="exampleInputName1">Email</label>
                      <input type="email" class="form-control" placeholder="admin_email" name="admin_email"/>
                    </div>
                    <button type="submit" class="btn btn-primary mr-2" name="submit">Submit</button>
                  </form>
                </div>
              </div>
            </div>
            
		 </div>
<?php include('footer.php');?>