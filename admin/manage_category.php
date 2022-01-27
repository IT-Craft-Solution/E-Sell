<?php 
include('header.php');
$msg="";
$category_name="";
$category_img="";
$category_status="";
$id="";

if(isset($_GET['id']) && $_GET['id']>0){
	$id=get_safe_value($_GET['id']);
	$row=mysqli_fetch_assoc(mysqli_query($con,"select * from category where id='$id'"));
	
	$category_name=$row['cat_name'];
	$category_img=$row['cat_img'];
	$category_status=$row['status'];
}

if(isset($_POST['submit'])){
	$category_name=get_safe_value($_POST['cat_name']);
	$category_img=get_safe_value($_POST['cat_img']);
	$category_status=get_safe_value($_POST['status']);
	$added_on=date('Y-m-d h:i:s');
	
	if($id==''){
		$sql="select * from category where cat_name='$category_name'";
	}else{
		$sql="select * from category where cat_name='$category_name' and id!='$id'";
	}	
	if(mysqli_num_rows(mysqli_query($con,$sql))>0){
		$msg="Category already added";
	}else{
		if($id==''){
            //insert into category(cat_name,cat_img,status) values('{$add_category}','{$add_image}','{$add_status}')
			mysqli_query($con,"insert into category(cat_name,cat_img,status) values('{$category_name}','{$category_img}','{$category_status}')")or die("query insert filed");
		}else{
			mysqli_query($con,"update category set cat_name='{$category_name}', cat_img='{$category_img}',status='{$category_status}' where id='$id'")or die("query update filed");
		}
		
		redirect('category.php');
	}
}
?>
<div class="row">
			<h1 class="grid_title ml10 ml15">Manage Category</h1>
            <div class="col-12 grid-margin stretch-card">
              <div class="card">
                <div class="card-body">
                  <form class="forms-sample" method="post">
                    <div class="form-group">
                      <label for="exampleInputName1">Category Name</label>
                      <input type="text" class="form-control" placeholder="category_name" name="cat_name" value="<?php echo $category_name?>">
					  <div class="error mt8"><?php echo $msg?></div>
                    </div>
                    <div class="form-group">
                      <label for="exampleInputEmail3">Category Image</label>
                      <input type="file" class="form-control" placeholder="category_img" name="cat_img"  value="<?php echo $category_img?>">
                    </div>
                    <div class="form-group">
                      <label for="exampleInputName1">Post Status</label>
                      <input type="text" class="form-control" placeholder="status" name="status" value="<?php echo $category_status ?>" />
                    </div>
                    <button type="submit" class="btn btn-primary mr-2" name="submit">Submit</button>
                  </form>
                </div>
              </div>
            </div>
            
		 </div>
        
<?php include('footer.php');?>