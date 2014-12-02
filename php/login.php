<?php
$con=mysqli_connect("mysql3.000webhost.com","a9079921_se3a04","se3a04","a9079921_tsdb");
if (mysqli_connect_errno($con))
{
   echo "Failed to connect to MySQL: " . mysqli_connect_error();
}
$username = $_GET['username'];
$password = $_GET['password'];
$result = mysqli_query($con,"SELECT CONCAT(Username,', ',Password) FROM CustomerInfoDB where 
Username='$username' and Password='$password'");
$row = mysqli_fetch_row($result);
$data = $row[0];
if($data){
echo $data;
}
mysqli_close($con);
?>