<?php
include_once 'Parser.php';
include_once 'XMLToArray.php';
include_once 'DirectClass.php';
include_once 'FileClass.php';
include_once 'LogEntry.php';

/**
 * This file test some functionality for the File Entry Class
 *
 * @author Haocheng Zhang
 */

class myTest extends \PHPUnit_Framework_TestCase {

    public function testDirName() {
        $dirObject = new DirectClass("/test", "1234", "hzhang91", "03-02-2013");
        $subDir = new DirectClass("/test/sub", "1234", "hzhang91", "03-02-2015");
        $dirObject -> addSubDir("mySub", $subDir);
        $subArray = $dirObject -> getSubDirArray();
        $dirName = null;
        foreach ($subArray as $name => $object){
            $dirName = $name;
            break;
        }
        $this->assertEquals($dirName, "mySub");
    }

    public function testAuthor() {
        $dirObject = new DirectClass("/test", "1234", "hzhang91", "03-04-2015");
        $subDir = new DirectClass("/test/sub", "1234", "hzhang91", "03-04-2015");
        $dirObject -> addSubDir("mySub", $subDir);
        $subArray = $dirObject -> getSubDirArray();
        $dirAuthor = null;
        foreach ($subArray as $name => $object){
            $dirAuthor = $object->getDirAuthor();
            break;
        }
        $this->assertEquals($dirAuthor, "hzhang91");
    }

    public function testParseDir() {
        $parser = parseList();
        $dirList = $parser["dirArray"];
        $dirname = "...";
        $dirAuthor = "...";
        $dirRevision = "...";
        $dirDate = "...";
        $tmp = null;
        foreach ($dirList as $object) {
            $tmp = $object;
            $tN = $tmp->getDirName();
            $tR = $tmp->getDirRevision();
            $tD = $tmp->getDirdate();
            $this->assertNotEquals($dirName, $tN);
            $this->assertNotEquals($dirRevision, $tR);
            $this->assertNotEquals($dirDate, $tD);
            $dirAuthor = $tmp->getDirAuthor();
            $dirRevision = $tR;
            $dirName = $tN;
            $dirDate = $tD;
            $this->assertEquals($dirAuthor, "hzhang91");
            $this->assertEquals($dirName, $tmp->getDirName());
            $this->assertEquals($dirRevision, $tmp->getDirRevision());
            $this->assertEquals($dirDate, $tmp->getDirdate());

        }
    }

    public function testParseLog() {
        $logList = parseLog();
        $logAuthor = "...";
        foreach ($logList as $revision => $object) {
            $logAuthor = $object->getLogAuthor();
            break;
        }
        $this->assertEquals($logAuthor, "hzhang91");
    }

    public function testinput() {
        $dirObject = new DirectClass("/test", "1234", "hzhang91", "03-02-2013");
        $dirName = "/test";
        $dirRevision = "2245";
        $dirAuthor = "hzhang91";
        $dirDate = "02-06-2014";
        $this->assertEquals($dirName, "/test");
        $this->assertEquals($dirRevision, "2245");
        $this->assertEquals($dirAuthor, "hzhang91");
        $this->assertEquals($dirDate, "02-06-2014");
        $subDir = new DirectClass("/test/sub", "1234", "hzhang91", "02-06-2014");
        $dirObject -> addSubDir("mySub", $subDir);
        $subArray = $dirObject -> getSubDirArray();
        $dirName = null;
        foreach ($subArray as $name => $object){
            $dirName = $name;
            break;
        }
        $this->assertEquals($dirName, "mySub");
    }

    public function testfile() {

    }
}

?>
