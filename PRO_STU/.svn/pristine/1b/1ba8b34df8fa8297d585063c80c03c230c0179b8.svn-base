<?php

$host = 'engr-cpanel-mysql.engr.illinois.edu';
$user = 'hzhang91_wqst';
$password = 'Zhc19950501';
$dbconn = mysql_connect($host, $user, $password) or die ('Could not connect to database: ' . mysql_error());
mysql_select_db('hzhang91_portfolio', $dbconn) or die("Cannot select the database");


// Test if a comment is posted successfully

echo "First POST...";
$q = "INSERT INTO Comment (parent_id, writer_name, assignment_path, content)
        VALUES ('2', 'test1', 'Assignment0/include/plus.h', 'test_succeed?')";
$r = mysql_query($q);
$query = "SELECT * FROM Comment WHERE assignment_path = 'Assignment0/include/plus.h'";
$result = mysql_query($query);
$row = mysql_fetch_assoc($result);
if($row['content'] == "test_succeed?"){
    echo "Content...pass<br>";
}
if($row['parent_id'] == "2"){
    echo "Parent_id...pass<br>";
}
if($row['writer_name'] == 'test1'){
    echo "Writer_name...pass<br>";
}

echo "<br><br>";

echo "Post Testing...";
$query = "SELECT * FROM Comment WHERE assignment_path = 'Assignment0/include/operation.h' AND parent_id = 0";
$result = mysql_query($query);
$row = mysql_fetch_assoc($result);
if($row['content'] == "good"){
    echo "pass<br>";
}

echo "<br><br>";

// Test if a reply is posted successfully
echo "Reply Testing...";
$query = "SELECT * FROM Comment WHERE assignment_path = 'Assignment0/include/operation.h' AND parent_id = ''";
$result = mysql_query($query);
$row = mysql_fetch_assoc($result);
if($row['content'] == "nice"){
    echo "pass<br>";
}

echo "<br><br>";


// Test if the red flag works

echo "Filter Testing...";
$red_word = "mom";
$query = "SELECT * FROM RedFlag WHERE red_word = '" .$red_word. "'";
$result = mysql_query($query);
$row = mysql_fetch_assoc($result);
if($row['replace_word'] == "dad"){
    echo "pass<br>";
}

echo "<br><br>";


//  Test if escape string works

echo "Escape Testing...";
$writer_name = "hao'cheng";
$saft_name = mysql_real_escape_string($writer_name);
$saft_content = mysql_real_escape_string($content);
if($saft_name <> $writer_name){
    echo "pass<br>";
}

