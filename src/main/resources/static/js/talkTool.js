function Talk(){

}
Talk.prototype = {
    alert:function(obj){
        const body = $('body');
        var element = $('<div class="talk-alert animate__animated animate__bounceIn" talk-style="'+obj.style+'" ></div>').text(obj.content);
        body.prepend(element);
        setInterval(function() {
            element.removeClass('animate__bounceIn');
            element.addClass('animate__fadeOutUp');
        }, obj.time*1000);
    }
}
Talk.prototype.constructor=Talk;