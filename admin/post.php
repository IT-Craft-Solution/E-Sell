<?php 
include('header.php');

if(isset($_GET['type']) && $_GET['type']!=='' && isset($_GET['id']) && $_GET['id']>0){
	$type=get_safe_value($_GET['type']);
	$id=get_safe_value($_GET['id']);
	if($type=='delete'){
		mysqli_query($con,"delete from sell where id='$id'");
		redirect('post.php');
	}
	if($type=='active' || $type=='deactive'){
		$status=1;
		if($type=='deactive'){
			$status=0;
		}
		mysqli_query($con,"update sell set status='$status' where id='$id'");
		redirect('post.php');
	}

}

$sql="select * from sell";
$res=mysqli_query($con,$sql);

?>
   <div class="card">
            <div class="card-body">
              <h2 class="card-title">Seller Post Table</h4>
              <a href="manage_post.php" class="add_link">Add Post</a>
              <div class="row">
                <div class="col-12">
                  <div class="table-responsive">
                  <?php
                  $conn=mysqli_connect('localhost','root','','olxdb') or die("Connection Failed");

                  $sql="SELECT * FROM sell";
                  $result=mysqli_query($conn,$sql) or die("Query unsuccessfull ");
                  
                  if(mysqli_num_rows($result)> 0){
                  ?>
                    <table id="order-listing" class="table">
                      <thead>
                        <tr>
                            <th width="2%">Order #</th>
                            <th width="10%">Category Name</th>
                            <th width="5%" >Title</th>
                            <th width="10%">Description</th>
                            <th width="10%">Price</th>
                            <th width="10%">Location</th>
                            <th width="10%">city_area</th>
                            <th width="10%">item_img</th>
                            <th width="30%">Action</th>
                        </tr>
                      </thead>
                      <tbody>
                      <?php
                          while($row=mysqli_fetch_assoc($result)){
                        ?>
                        <tr>
                            <td><?php echo $row['id'] ?></td>
                            <td><?php echo $row['cat_name'] ?></td>
                            <td><?php echo $row['title'] ?></td>
                            <td><?php echo $row['description'] ?></td>
                            <td><?php echo $row['price'] ?></td>
                            <td><?php echo $row['location'] ?></td>
                            <td><?php echo $row['city_area'] ?></td>
                            <td><img src="assets/images/logo2.png"/></td>
                            <td>
                                <a href="manage_post.php?id=<?php echo $row['id']?>"><label class="badge badge-success hand_cursor">Edit</label></a>&nbsp;
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