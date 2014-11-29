<?php
$con=mysqli_connect("server10.000webhost.com","a1501007_root","*58D8E6DE8C080CE0FC29DC6976663750184BDAD2","a4098197_tsdb");
if (mysqli_connect_errno($con))
{
   echo "Failed to connect to MySQL: " . mysqli_connect_error();
}
$username = $_POST['username'];
$password = $_POST['password'];
$result = mysqli_query($con,"SELECT Username, Password FROM a4098197_tsdb.CustomerInfoDB where 
Username='$username' and Password='$password'");
$row = mysqli_fetch_array($result);
$data = $row[0];
if($data){
echo $data;
}
mysqli_close($con);
?>