<?php
$con=mysqli_connect("mysql3.000webhost.com","a9079921_se3a04","se3a04","a9079921_tsdb");
if (mysqli_connect_errno($con))
{
   echo "Failed to connect to MySQL: " . mysqli_connect_error();
}
$username = $_GET['username'];
$email = $_GET('email');
$result = mysqli_query($con,"SELECT CONCAT(Username, ',', EmailAddress) FROM CustomerInfoDB WHERE Username = $username OR EmailAddress = $email")
$row = mysqli_fetch_row($result);
$data = $row[0];
if($data){
echo $data;
}
mysqli_close($con);
?>