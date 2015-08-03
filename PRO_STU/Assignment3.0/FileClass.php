<?php

class FileClass
{
	private $fileName;
	private $fileSize;
	private $fileRevision;
    private $fileDate;
	private $fileAuthor;

	public function __construct($fileName, $fileSize, $fileRevision, $fileAuthor, $fileDate){
		$this -> fileName = $fileName;
		$this -> fileSize = $fileSize;
		$this -> fileRevision = $fileRevision;
		$this -> fileAuthor = $fileAuthor;
		$this -> fileDate = $fileDate;
	}

    /*
     * Getter and setter functions for the class
     */

	public function getFileName() {
		return $this -> fileName;
	}

	public function getFileSize() {
		return $this -> fileSize;
	}

	public function getFileRevision() {
		return $this -> fileRevision;
	}

	public function getFileAuthor() {
		return $this -> fileAuthor;
	}

	public function getFileDate() {
		return $this -> fileDate;
	}

	




}