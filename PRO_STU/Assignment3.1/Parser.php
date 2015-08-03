<?php

include 'XMLToArray.php';
include 'DirectoryClass.php';
include 'FileClass.php';
include 'LogEntry.php';

/*
 * This function will parse the svn_list.xml
 * and make them into dirObject or fileObject
 */
function parseList() {
    $xml_list = simplexml_load_file("svn_list.xml");
    $listArray = simpleXMLToArray($xml_list);
    $dirListArray = array();
    $fileListArray = array();
    $retArray = array();
    $curAssignment = null;
    $itr = 0;

    foreach($listArray["list"]["entry"] as $key) {
        if($listArray["list"]["entry"][$itr]["kind"] == "dir") {
            $dirName = $listArray["list"]["entry"][$itr]["name"];
            $newDirectoryObject = parseDir($listArray, $itr, $dirName);
            if($curAssignment == null || strpos($dirName, $curAssignment) === false){
                $curAssignment = $dirName;
                $dirListArray[$curAssignment] = $newDirectoryObject;
            }
            else {
                $dirListArray[$curAssignment] -> addSubDir($dirName, $newDirectoryObject);
            }
        }
        if($listArray["list"]["entry"][$itr]["kind"] == "file") {
            $fileListArray = parseFile($listArray, $itr, $fileListArray);
        }
        $itr += 1;
    }
    $retArray["dirArray"] = $dirListArray;
    $retArray["fileArray"] = $fileListArray;
    return $retArray;
}

/**
 * @param $listArray
 * @param $itr
 * @param $dirName
 * @return DirectoryClass
 *
 * Create a directory object
 */
function parseDir($listArray, $itr, $dirName)
{
    $dirRevision = $listArray["list"]["entry"][$itr]["commit"]["revision"];
    $dirAuthor = $listArray["list"]["entry"][$itr]["commit"]["author"];
    $dirDate = $listArray["list"]["entry"][$itr]["commit"]["date"];

    $newDirectoryObject = new DirectoryClass($dirName, $dirRevision, $dirAuthor, $dirDate);
    return $newDirectoryObject;
}

/**
 * @param $listArray
 * @param $itr
 * @param $fileListArray
 * @return mixed
 *
 * Create a file object
 */
function parseFile($listArray, $itr, $fileListArray)
{
    $fileName = $listArray["list"]["entry"][$itr]["name"];
    $fileSize = $listArray["list"]["entry"][$itr]["size"];
    $fileRevision = $listArray["list"]["entry"][$itr]["commit"]["revision"];
    $fileAuthor = $listArray["list"]["entry"][$itr]["commit"]["author"];
    $fileDate = $listArray["list"]["entry"][$itr]["commit"]["date"];

    $newFileObject = new FileClass($fileName, $fileSize, $fileRevision, $fileAuthor, $fileDate);
    $fileListArray[$fileName] = $newFileObject;
    return $fileListArray;
}

/*
 * This function will parse svn_log.xml
 * and make them into logEntry object.
 *
 * Create a log object
 * Push the new object into log array
 */
function parseLog() {
    $xml_log = simplexml_load_file("svn_log.xml");
    $logArray = array();
    foreach($xml_log->logentry as $entry) {
        $logRevision = (string)$entry['revision'];
        $logAuthor = (string)$entry-> author;
        $logDate = (string)$entry-> date;
        $logMsg = (string)$entry -> msg;
        $newLogEntry = new MyLogEntry($logRevision, $logAuthor, $logDate, $logMsg);
        foreach($entry->paths->path as $path) {
            if($path['kind'] == "file") {
                $newLogEntry -> addLogFilePath((string)$path);
            }
            else {
                $newLogEntry -> addLogDirPath((string)$path );
            }
        }
        $logArray[$logRevision] = $newLogEntry;
    }
    return $logArray;
}




