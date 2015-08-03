<?php

include_once '../Parser.php';
include_once '../DirectClass.php';

class test extends PHPUnit_Framework_TestCase {
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
assert($author === "hzhang91");


/*function assertTrue($condition)
{
    if (!$condition) {
        throw new Exception('Assertion failed.');
    }
}*/
}
?>
