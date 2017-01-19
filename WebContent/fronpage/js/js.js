jQuery(document).ready(function() {

    var targetOffset = $(".wen-anchor").offset().top;

    var $w = $(window).scroll(function() {
        if ($w.scrollTop() > targetOffset) {
            $('.nav-bottom').css({
                "background-color": "white",
                "box-shadow": "0 0 10px rgba(100,100,100,.5)"
            });
            // $('.nav-bottom').css({"border-bottom": "3px solid black"});
        } else {
            $('.nav-bottom').css({
                "background-color": "rgba(255, 255, 255, 0.8)",
                "box-shadow": "none"
            });
            // $('.nav-bottom').css({"border-bottom": "3px solid white"});
        }
    });



});


$('.hambergur').click(function() {
    $('.wen-menu-mobile').show();
    $('#content').hide();
    $(this).hide();
});

$('.wen-close').click(function() {
    $('.wen-menu-mobile').hide();
    $('#content').show();
    $('.hambergur').show();
});


  