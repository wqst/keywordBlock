<?php

include 'Parser.php';
$parser = parseList();
$dirList = $parser["dirArray"];
$fileList= $parser["fileArray"];
$logList = parseLog();

?>


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
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
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
            <h1><a href="#">My CS242 Portfolio</a></h1>
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
        <p>This website contains all my assignments for CS242.</p>
        <p>Please take a look and let me know what you think.</p>
    </div>
</div>
<div id="page-wrapper">
    <div id="page" class="container">
        <div id="content">
            <header><strong>My Latest Work</strong></header>
            <div id="two-column">

                        <?php
                        /*
                         * The Following code will get all the assignment from
                         * Parser(), and format them into html.
                         */
                        $i = 0;
                        foreach ($dirList as $key => $value) {
                            if ($i%2 == 0){
                                echo "<div id='tbox1'>";
                            }
                            else {
                                echo "<div id='tbox2'>";
                            }
                            echo "<div class='box-style'>";
                            echo "<h3>" . $value->getDirName() . "</a></h3>";
                            echo "<p>Author: " . $value->getDirAuthor() . "</p>";
                            echo "<p>Data: " . $value->getDirDate() . "</p>";
                            echo "<p>Revision: " . $value->getDirRevision() . "</p>";
                            echo "<p>Type: Directory</p>";

                            $name = $value->getDirName();
                            $revision = $value->getDirRevision();
                            $link = "projects.php?assignment=" . $name;
                            $msg = null;
                            foreach ($logList as $key => $value) {

                                if ($key == $revision) {
                                    $msg = $value->getLogMsg();
                                    break;
                                }
                            }
                            echo "<p>Commit Message: " . $msg . "</p>";
                            echo "<a href=$link>See the Full Files</a></div></div>";
                            $i += 1;
                        }
                        ?>
            </div>
        </div>
    </div>
</div>
<div id="featured-wrapper">
    <div id="featured" class="container">
        <header></header>
        <a href="#" class="button">Nulla luctus eleifend purus</a><a href="#" class="button button-alt">Fusce ultrices fringilla metus</a></div>
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




