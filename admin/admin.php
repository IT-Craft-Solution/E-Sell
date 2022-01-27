<?php 

include ('header.php');
if(isset($_GET['type']) && $_GET['type']!=='' && isset($_GET['id']) && $_GET['id']>0){
	$type=get_safe_value($_GET['type']);
	$id=get_safe_value($_GET['id']);
	if($type=='delete'){
		mysqli_query($con,"delete from admin where id='$id'");
		redirect('admin.php');
	}
	if($type=='active' || $type=='deactive'){
		$status=1;
		if($type=='deactive'){
			$status=0;
		}
		mysqli_query($con,"update admin set status='$status' where id='$id'");
		redirect('admin.php');
	}

}

$sql="select * from admin";
$res=mysqli_query($con,$sql);

?>
       <div class="card">
            <div class="card-body">
              <h2 class="card-title">Admin List Table</h4>
              <a href="manage_admin.php" class="add_link">Add Admin</a>
              <div class="row">
                <div class="col-12">
                  <div class="table-responsive">
                  <?php
                  $conn=mysqli_connect('localhost','root','','olxdb') or die("Connection Failed");

                  $sql="SELECT * FROM admin";
                  $result=mysqli_query($conn,$sql) or die("Query unsuccessfull ");
                  
                  if(mysqli_num_rows($result)> 0){
                  ?>
                    <table id="order-listing" class="table">
                      <thead>
                        <tr>
                            <th>Admin #</th>
                            <th>Name</th>
                            <th>UserName</th>
                            <th>Email</th>
                            <th>Action</th>
                        </tr>
                      </thead>
                      <tbody>
                          <?php
                          while($row=mysqli_fetch_assoc($result)){
                        ?>
                        <tr>
                            <td><?php echo $row['id'] ?></td>
                            <td><?php echo $row['name'] ?></td>
                            <td><?php echo $row['username'] ?></td>
                            <td><?php echo $row['email'] ?></td>
                            <td>
                            <a href="?id=<?php echo $row['id']?>&type=delete"><label class="badge badge-danger delete_red hand_cursor">Delete</label></a>
                            </td>
                        </tr>
                        <?php } ?>
                      </tbody>
                    </table>
                    <?php } ?>
                  </div>
				</div>
              </div>
            </div>
          </div>
        
        
<?php include('footer.php');?>