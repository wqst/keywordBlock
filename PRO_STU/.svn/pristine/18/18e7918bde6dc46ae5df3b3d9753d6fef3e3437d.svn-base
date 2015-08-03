<?php

include '../Parser.php';
include '../DirectoryClass.php';
$parser = parseList();
$dirList = $parser["dirArray"];
$fileList= $parser["fileArray"];
$logList = parseLog();

//$fixture[] = 'element';
//assertTrue(count($fixture) == 1);

// check author name
$author = null;
foreach ($dirList as $name => $object) {
    $author = $object->getDirAuthor();
    break;
}
asserTrue($author === "huangfu");


function assertTrue($condition)
{
    if (!$condition) {
        throw new Exception('Assertion failed.');
    }
}
?>
