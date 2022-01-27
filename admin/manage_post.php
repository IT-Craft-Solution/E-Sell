<?php 
include('header.php');
$msg="";
$post_name="";
$post_title="";
$post_desc="";
$post_price="";
$post_location="";
$post_city_area="";
$post_image="";
$post_status="";
$id="";


if(isset($_GET['id']) && $_GET['id']>0){
	$id=get_safe_value($_GET['id']);
	$row=mysqli_fetch_assoc(mysqli_query($con,"select * from sell where id='$id'"));
    $post_name=$row['cat_name'];
    $post_title=$row['title'];
    $post_desc=$row['description'];
    $post_price=$row['price'];
    $post_location=$row['location'];
    $post_city_area=$row['city_area'];
    $post_image=$row['item_img'];
    $post_status=$row['status'];
}

if(isset($_POST['submit'])){
	$post_name=get_safe_value($_POST['cat_name']);
	$post_title=get_safe_value($_POST['title']);
    $post_desc=get_safe_value($_POST['description']);
    $post_price=get_safe_value($_POST['price']);
    $post_location=get_safe_value($_POST['location']);
    $post_city_area=get_safe_value($_POST['city_area']);
    $post_image=get_safe_value($_POST['item_img']);
    $post_status=get_safe_value($_POST['status']);
	$added_on=date('Y-m-d h:i:s');
	
	if($id==''){
		$sql="select * from sell where cat_name='$post_name'";
	}else{
		$sql="select * from sell where cat_name='$post_name' and id!='$id'";
	}	
	if(mysqli_num_rows(mysqli_query($con,$sql))>0){
		$msg="Post already added";
	}else{
		if($id==''){
			mysqli_query($con,"insert into sell(cat_name,title,description,price,location,city_area,item_img,status) values('{$post_name}','{$post_title}','{$post_desc}','{$post_price}','{$post_location}','{$post_city_area}','{$post_image}','{$post_status}')");
		}else{
			mysqli_query($con,"update sell set cat_name='$post_name' where id='$id'");
		}
		
		redirect('post.php');
	}
}
?>
<div class="row">
			<h1 class="grid_title ml10 ml15">Manage Post</h1>
            <div class="col-12 grid-margin stretch-card">
              <div class="card">
                <div class="card-body">
                  <form class="forms-sample" method="post">
                    <div class="form-group">
                      <label for="exampleInputName1">Post Name</label>
                      <input type="text" class="form-control" placeholder="cat_name" name="cat_name" value="<?php echo $post_name ?>"/>
                    </div>

                    <div class="form-group">
                      <label for="exampleInputName1">Post Title</label>
                      <input type="text" class="form-control" placeholder="title" name="title" value="<?php echo $post_title ?>" />
                    </div>

                    <div class="form-group">
                      <label for="exampleInputName1">Post Desc</label>
                      <input type="text" class="form-control" placeholder="description" name="description" value="<?php echo $post_desc?>" />
                    </div>
                    <div class="form-group">
                      <label for="exampleInputName1">Post Price</label>
                      <input type="text" class="form-control" placeholder="price" name="price" value="<?php echo $post_price ?>" />
                    </div>
                    <div class="form-group">
                      <label for="exampleInputName1">Post Location</label>
                      <input type="text" class="form-control" placeholder="location" name="location" value="<?php echo $post_location ?>" />
                    </div>
                    <div class="form-group">
                      <label for="exampleInputName1">Post City Area</label>
                      <input type="text" class="form-control" placeholder="city_area" name="city_area" value="<?php echo $post_city_area ?>" />
                    </div>
                    <div class="form-group">
                      <label for="exampleInputName1">Post Image</label>
                      <input type="file" class="form-control" name="item_img">
                      <input type="file" class="form-control" name="item_img">
                      <input type="file" class="form-control" name="item_img">
                      <input type="file" class="form-control" name="item_img">
                      <input type="file" class="form-control" name="item_img">
                      <input type="file" class="form-control" name="item_img">
                    </div>
                    <div class="form-group">
                      <label for="exampleInputName1">Post Status</label>
                      <input type="text" class="form-control" placeholder="status" name="status" value="<?php echo $post_status ?>" />
                    </div>
                    <button type="submit" class="btn btn-primary mr-2" name="submit">Submit</button>
                  </form>
                </div>
              </div>
            </div>
            
		 </div>
        
<?php include('footer.php');?>