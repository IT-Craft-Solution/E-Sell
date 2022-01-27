<?php 
include ('header.php');

if(isset($_GET['type']) && $_GET['type']!=='' && isset($_GET['id']) && $_GET['id']>0){
	$type=get_safe_value($_GET['type']);
	$id=get_safe_value($_GET['id']);
	if($type=='delete'){
		$query=mysqli_query($con,"delete from user_details where id='$id'");
    if(mysqli_query($con, $query)){
      echo json_encode(array("status"=>"true","message"=>" successfully Deleted"));
    }else{
      echo json_encode(array("status"=>"false","message"=>"successfully Not Deleted"));
    }
		redirect('user.php');
	}
	if($type=='active' || $type=='deactive'){
		$status=1;
		if($type=='deactive'){
			$status=0;
		}
		$query=mysqli_query($con,"update user_details set status='$status' where id='$id'");
    if(mysqli_query($con, $query)){
      echo json_encode(array("status"=>"true","message"=>"Updated successfully "));
    }else{
      echo json_encode(array("status"=>"false","message"=>"Not Update successfully"));
    }
		redirect('user.php');
	}

}

$sql="select * from user_details";
$res=mysqli_query($con,$sql);

?>
  <div class="card">
            <div class="card-body">
              <h1 class="card-title">User List Table</h4>
              <a href="manage_user.php" class="add_link">Add User</a>
              <div class="row">
                <div class="col-12">
                  <div class="table-responsive">
                  <?php
                  $conn=mysqli_connect('localhost','root','','olxdb') or die("Connection Failed");

                  $sql="SELECT * FROM user_details";
                  $result=mysqli_query($conn,$sql) or die("Query unsuccessfull ");
                  
                  if(mysqli_num_rows($result)> 0){
                  ?>
                    <table id="order-listing" class="table">
                      <thead>

                        <tr>
                            <th width="2%">User #</th>
                            <th width="2%">Phone</th>
                            <th width="2%">Email</th>
                            <th width="2%">User Image</th>
                            <th width="2%">User Name</th>
                            <th width="2%">User Bio</th>
                            <th width="2%">Location</th>
                            <th width="2%">City Area</th>
                            <th width="40%">Action</th>
                        </tr>
                      </thead>
                      <tbody>
                      <?php
                          while($row=mysqli_fetch_assoc($result)){
                        ?>
                        <tr>
                            <td><?php echo $row['id'] ?></td>
                            <td><?php echo $row['phone'] ?></td>
                            <td><?php echo $row['email'] ?></td>
                            <td><img src="assets/images/logo2.png"/></td>
                            <td><?php echo $row['user_name'] ?></td>
                            <td><?php echo $row['user_bio'] ?></td>
                            <td><?php echo $row['location'] ?></td>
                            <td><?php echo $row['city_area'] ?></td>
                            <td>
                                <a href="manage_user.php?id=<?php echo $row['id']?>"><label class="badge badge-success hand_cursor">Edit</label></a>&nbsp;
                                <?php
                                if($row['status']==1){
                                ?>
                                <a href="?id=<?php echo $row['id']?>&type=deactive"><label class="badge badge-danger hand_cursor">Active</label></a>
                                <?php
                                }else{
                                ?>
                                <a href="?id=<?php echo $row['id']?>&type=active"><label class="badge badge-info hand_cursor">Deactive</label></a>
                                <?php
                                }
                                
                                ?>
                                &nbsp;
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