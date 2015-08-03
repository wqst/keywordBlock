/*
 * This function will find the parent id
 * of the new reply
 */
$(function(){
    $("#comment_part").on("click", "a.reply", function () {
        var id = $(this).attr("id");
        $("#parent_id").attr("value", id);
    });
});

/*
 * This function will fade the Iframe in
 * by clicking
 */
$(document).ready(function(){
    $("#iframe").click(function(){
        $("#tbox2").fadeIn("slow");
    });
});

/*
 * This function will past the comment body
 * to php. Then update the comment body
 */
$(function() {
    $('#add_button').click(function() {
        $.ajax({
            type: "POST",
            url: "post_comment.php",
            data: {name: $('#poster_name').val(), comment_body: $('#comment_body').val(), parent_id: $('#parent_id').val(), assignment_path: $('#assignment_path').val()}
            , beforeSend: function(){
            }
            , complete: function(){
            }
            , success: function(html){
                $("#comment_part").html(html);
            }
        });
    });
});

/*
 * This function will fetch the path of the file
 * to a php file. And fade the result into the page
 */
$(function() {
    $('#See_Code').click(function() {
        $.ajax({
            type: "POST",
            url: "getFile.php",
            data: {file: $('#See_Code').val()}
            , beforeSend: function(){
            }
            , complete: function(){
            }
            , success: function(html){
                $("#tbox2").html(html);
                $("#tbox2").fadeIn("slow");
            }
        });
    });
});

/*
 * This function will fade the directory detail in
 * when the mouse enter the area
 */
$(document).ready(function(){
    $(".assig").mouseenter(function(){
        $(this).children('div').fadeIn();
    });
});

/*
 * This function will fade the directory deail out
 * when the mouse leave the area
 */
$(document).ready(function(){
    $(".assig").mouseleave(function(){
        $(this).children('div').fadeOut();
    });
});