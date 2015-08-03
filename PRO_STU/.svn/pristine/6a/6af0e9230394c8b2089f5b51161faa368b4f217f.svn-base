<?php
/**
 * To change this template use File | Settings | File Templates.
 */
class MyLogEntry
{
    private $logRevision;
    private $logAuthor;
    private $logDate;
    private $logMsg;
    private $logRootDir;
    private $filePathArray;
    private $dirPathArray;

    public function __construct($logRevision, $logAuthor, $logDate, $logMsg) {
        $this -> logRevision = $logRevision;
        $this -> logAuthor = $logAuthor;
        $this -> logDate = $logDate;
        $this -> logMsg = $logMsg;
        $this -> filePathArray = array();
        $this -> dirPathArray = array();


    }

    /*
     * getter and setter for the class
     */

    public function getLogRevision() {
        return $this -> logRevision;
    }

    public function getLogAuthor() {
        return $this -> logAuthor;
    }

    public function getLogDate() {
        return $this -> logDate;
    }

    public function getLogMsg() {
        return $this -> logMsg;
    }

    public function getFilePathArray() {
        return $this -> filePathArray;
    }

    public function getDirPathArray() {
        return $this -> dirPathArray;
    }

    public function addLogFilePath($filePath) {
        array_push($this -> filePathArray, $filePath);
    }

    public function addLogDirPath($dirPath) {
        array_push($this -> dirPathArray, $dirPath);
    }







}
