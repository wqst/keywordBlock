<?php

include_once 'XMLToArray.php';
include_once 'DirectClass.php';
include_once 'FileClass.php';
include_once 'LogEntry.php';

function parseList() {

    /*
     * This function will parse the svn_list.xml
     * and make them into dirObject or fileObject
     */
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
            $dirRevision = $listArray["list"]["entry"][$itr]["commit"]["revision"];
            $dirAuthor = $listArray["list"]["entry"][$itr]["commit"]["author"];
            $dirDate = $listArray["list"]["entry"][$itr]["commit"]["date"];

            $newDirectoryObject = new DirectClass($dirName, $dirRevision, $dirAuthor, $dirDate);

            if($curAssignment == null || strpos($dirName, $curAssignment) === false){
                $curAssignment = $dirName;
                $dirListArray[$curAssignment] = $newDirectoryObject;
            }
            else {
                $dirListArray[$curAssignment] -> addSubDir($dirName, $newDirectoryObject);
            }


        }

        if($listArray["list"]["entry"][$itr]["kind"] == "file") {
            $fileName = $listArray["list"]["entry"][$itr]["name"];
            $fileSize = $listArray["list"]["entry"][$itr]["size"];
            $fileRevision = $listArray["list"]["entry"][$itr]["commit"]["revision"];
            $fileAuthor = $listArray["list"]["entry"][$itr]["commit"]["author"];
            $fileDate = $listArray["list"]["entry"][$itr]["commit"]["date"];

            $newFileObject = new FileClass($fileName, $fileSize, $fileRevision, $fileAuthor, $fileDate);
            $fileListArray[$fileName] = $newFileObject;
        }

        $itr += 1;

    }
    $retArray["dirArray"] = $dirListArray;
    $retArray["fileArray"] = $fileListArray;
    return $retArray;
}

function parseLog() {

    /*
     * This function will parse svn_log.xml
     * and make them into logEntry object.
     */

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









