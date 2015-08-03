<?php
/**
 * Created by JetBrains PhpStorm.
 * User: shengchao
 * Date: 3/14/13
 * Time: 2:23 PM
 * To change this template use File | Settings | File Templates.
 */


include 'Connection.php';
include 'function.php';

/*
 * By calling mysql_real_escape_string 
 * to lock things down avoiding Injection attack
 */
$author = mysql_real_escape_string($_POST['name']);
$comment_body = mysql_real_escape_string($_POST['comment_body']);
$parent_id = mysql_real_escape_string($_POST['parent_id']);
$assignment_path = mysql_real_escape_string(($_POST['assignment_path']));

/*
 * Replace the comment content 
 * If find a red word in the filter table
 */

$filter = "SELECT replace_word FROM RedFlag WHERE red_word = '" . $comment_body . "'";
$result = mysql_query($filter);
if(mysql_num_rows($result)) {
	$row = mysql_fetch_assoc($result);
	$comment_body = $row['replace_word'];
}


$q = "INSERT INTO Comment (parent_id, writer_name, assignment_path, content)
        VALUES ('$parent_id', '$author', '$assignment_path', '$comment_body')";
$r = mysql_query($q);

$query = "SELECT * FROM Comment WHERE assignment_path ='" . $assignment_path . "' AND parent_id = 0";
$result = mysql_query($query) or die(mysql_error());

/*
 * Print threaded comments
 */
while($row = mysql_fetch_assoc($result)):
    	getComments($row);
endwhile;

?>