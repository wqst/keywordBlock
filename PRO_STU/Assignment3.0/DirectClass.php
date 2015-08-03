<?php

class DirectClass
{
	private $dirName;
	private $dirRevision;
	private $dirAuthor;
	private $dirDate;
    private $subDir;

	public function __construct($dirName, $dirRevision, $dirAuthor, $dirDate){
		$this -> dirName = $dirName;
		$this -> dirRevision = $dirRevision;
		$this -> dirAuthor = $dirAuthor;
		$this -> dirDate = $dirDate;
        $this -> subDir = array();

	}

    /*
     * getter and setter functions for the class
     */

	public function getDirName() {
		return $this -> dirName;
	}

	public function getDirRevision() {
		return $this -> dirRevision;
	}

	public function getDirAuthor() {
		return $this -> dirAuthor;
	}

    public function getDirDate() {
        return $this -> dirDate;
    }

    public function addSubDir($subDir, $dirObject) {
        $this ->subDir[$subDir] = $dirObject;
    }

    public function getSubDirArray() {
        return $this -> subDir;
    }





}