<?php
/**
 * Created by JetBrains PhpStorm.
 * Cite from http://www.technabled.com/2009/06/how-to-multi-level-comments-in-php.html
 * User: shengchao
 * Date: 3/14/13
 * Time: 2:19 PM
 * To change this template use File | Settings | File Templates.
 */

/**
 * This function prints out 
 * threaded comments by recursion
 */
function getComments($row) {
    echo "<li class='comment'>";
    echo "<div class='aut'>".$row['writer_name']."</div>";
    echo "<div class='comment-body'>".$row['content']."</div>";
    echo "<div class='timestamp'>".$row['create_time']."</div>";
    echo "<a href='#comment_form' class='reply' id='".$row['comment_id']."'>Reply</a>";
    /* The following sql checks whether there's any reply for the comment */
    $q = "SELECT * FROM Comment WHERE parent_id = ".$row['comment_id']."";
    $r = mysql_query($q);
    if ($r != FALSE) {
        if (mysql_num_rows($r) > 0) // there is at least reply
        {
            echo "<ul>";
            while ($row = mysql_fetch_assoc($r)) {
                getComments($row);
            }
            echo "</ul>";
        }
    }
    echo "</li>";
}