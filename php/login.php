<?php
$con=mysqli_connect("taxishare.web44.net","username","password","a4098197_tsdb");
if (mysqli_connect_errno($con))
{
   echo "Failed to connect to MySQL: " . mysqli_connect_error();
}
$username = $_POST['username'];
$password = $_POST['password'];
$result = mysqli_query($con,"SELECT Username, Password FROM CustomerInfoDB where 
Username='$username' and Password='$password'");
$row = mysqli_fetch_array($result);
$data = $row[0];
if($data){
echo $data;
}
mysqli_close($con);
?>