<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<!--
Design by Free CSS Templates
http://www.freecsstemplates.org
Released for free under a Creative Commons Attribution 2.5 License

Name       : Workspace
Description: A two-column, fixed-width design with dark color scheme.
Version    : 1.0
Released   : 20132602
-->

<?php
include 'Parser.php';
include 'Connection.php';
include 'function.php';
$parser = parseList();
$dirList = $parser["dirArray"];
$fileList= $parser["fileArray"];
$logList = parseLog();
$file = $_GET['file'];
$sourcePath = "https://subversion.ews.illinois.edu/svn/sp15-cs242/hzhang91/";

$query = "SELECT * FROM Comment WHERE assignment_path ='" . $file . "' AND parent_id = 0";
$result = mysql_query($query) or die(mysql_error());

?>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<script type='text/javascript' src='//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js'></script>
<script type='text/javascript' src='JS.js'></script>

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>CS 242</title>
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700|Archivo+Narrow:400,700" rel="stylesheet" type="text/css">
    <link href="default.css" rel="stylesheet" type="text/css" media="all" />
    <!--[if IE 6]>
    <link href="default_ie6.css" rel="stylesheet" type="text/css" />
    <![endif]-->
    
</head>
<body>
<div id="header-wrapper">
    <div id="header" class="container">
        <div id="logo">
            <h1><a href="index.php">My CS242 Portfolio</a></h1>
        </div>
        <div id="menu">
            <ul>
                <li class="active"><a href="#" accesskey="1" title="">Home</a></li>
                <li><a href="#" accesskey="2" title="">My Work</a></li>
                <li><a href="#" accesskey="3" title="">About Me</a></li>
                <li><a href="#" accesskey="4" title="">Contact</a></li>
            </ul>
        </div>
    </div>
</div>
<div id="banner-wrapper">
    <div id="banner" class="container">
        <p>This is a portfolio website for my SP15 CS242 assignment</p>
        <p>It implements several functionalities and you can try to play with it</p>
    </div>
</div>
<div id="page-wrapper">
    <div id="page" class="container">
        <div id="content">
            <header><?php echo "<strong>" . $file . "</strong>";?></header>
            <div id="two-column">

                <?php   
                foreach ($fileList as $key => $value) {
                    if (strcmp($key, $file) === 0) {
                        echo "<div id='tbox1'>";
                        echo "<div class='box-style'>";
                        echo "<h3>" . $value->getFileName() . "</h3>";
                        echo "<p>Author: " . $value->getFileAuthor() . "</p>";
                        echo "<p>Data: " . $value->getFileDate() . "</p>";
                        echo "<p>Revision: " . $value->getFileRevision() . "</p>";
                        echo "<p>Size: " . $value->getFileSize() . "Kb</p>";
                        echo "<p>Type: " . strrchr($key, '.') . "</p>";

                        $name = $value->getFileName();
                        $revision = $value->getFileRevision();
                        $msg = null;
                        foreach ($logList as $logKey => $logEntry) {

                            if ($logKey === $revision) {
                                $msg = $value->getLogMsg();
                                break;
                            }
                        }
                        echo "<p>Commit Message: " . $msg . "</p>";
                        $fullPath = $sourcePath . $name;
                        //echo "<div id='iframe'><a href= $fullPath target='myIframe'>See the code</a></div></div></div>" ;
                        echo "<button id='See_Code' type='button' value='$name'>See Code</button></div></div>";
                        break;
                    }
                }?>

                <div id='tbox2' style='display:none'>
                    <div class='box-style'>
                        <iframe src="iframe.html" name = "myIframe" width="500" height="400" style='background-color:#D6D6FF'>
                            <p>Your browser does not support iframes.</p>
                        </iframe>
                        </div>
                </div>

                <div id='tbox1'>
                    <div class='box-style'>
                        <header>Comment</header>

                        <div id='wrapper'>
                            
                            <ul>
                            	<div id='comment_part'>
                                <?php 
                                	while($row = mysql_fetch_assoc($result)):
    						getComments($row);
					endwhile;
				?>
				</div>
                            </ul>
                                <label for="name">Name:</label><br>
                                <input id = "poster_name" type="text" name="name"/><br>
                                <label for="comment_body">Comment:</label>
                                <textarea name="comment_body" id='comment_body'></textarea>
                                <input type='hidden' name='parent_id' id='parent_id' value='0'/>
                                <input type='hidden' name='assignment_path' id='assignment_path' value=<?php echo "'" .$file . "'"?>/>
                                <button id="add_button" type="button">Add Comment</button>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>
<div id="featured-wrapper">
    <div id="featured" class="container">
        <header></header>
        <a href="#" class="button">what</a><a href="#" class="button button-alt">Fusce ultrices fringilla metus</a></div>
</div>
<div id="footer-wrapper">
    <div id="footer" class="container">
        <div id="fbox1">
            <header>About Us</header>
            <p>This is <strong>Workspace </strong>, a free, fully standards-compliant CSS template designed by <a href="http://www.freecsstemplates.org">FCT</a>. This free template is released under a <a href="http://creativecommons.org/licenses/by/3/">Creative Commons Attributions 3.0</a> license, so you’re pretty much free to do whatever you want with it (even use it commercially) provided you keep the links in the footer intact. Aside from that, have fun with it :)</p>
            <a href="#" class="button button-small">Fusce ultrices fringilla metus</a> </div>
        <div id="fbox2">
            <header>Get In Touch</header>
            <p>In posuere eleifend odio. Quisque semper augue mattis wisi. Maecenas ligula. Pellentesque viverra vulputate enim fermentum nibh in augue.</p>
            <ul class="style2">
                <li><a href="#"><img src="images/social03.png" width="32" height="32" alt="" /></a></li>
                <li><a href="#"><img src="images/social01.png" width="32" height="32" alt="" /></a></li>
                <li><a href="#"><img src="images/social04.png" width="32" height="32" alt="" /></a></li>
                <li><a href="#"><img src="images/social02.png" width="32" height="32" alt="" /></a></li>
            </ul>
        </div>
    </div>
</div>
<div id="copyright" class="container">
    <p>Copyright (c) 2013 <a href="#">Sitename.com</a>. Integer amet aliquet pretium. All rights reserved. Design by <a href="http://www.freecsstemplates.org">FCT</a>.</p>
</div>
</body>
</html>