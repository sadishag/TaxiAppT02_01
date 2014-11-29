<?php
mysql_connect("sql206.byethost22.com","b22_15602567","se3a04") or  die(mysql_error());
mysql_select_db("b22_15602567_tsdb");
$sql=mysql_query("select * from CustomerInfoDB");
while($row=mysql_fetch_assoc($sql))
$output[]=$row;
print(json_encode($output));
mysql_close();
?>