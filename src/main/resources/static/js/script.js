let title = document.querySelectorAll(".chat-list-header");
let totalHeight = 0;

for (let i = 0; i < title.length; i++) {
  let totalHeight = 0;
  title[i].addEventListener("click", function () {
    let result = this.nextElementSibling;
    let activeSibling = this.nextElementSibling.classList.contains('active');
    this.classList.toggle('active');
    result.classList.toggle("active");
    if (!activeSibling) {
      for (i = 0; i < result.children.length; i++) {
        totalHeight = totalHeight + result.children[i].scrollHeight + 40;
      }
    } else {
      totalHeight = 0;
    }
    result.style.maxHeight = totalHeight + "px";
  });
}

const themeColors = document.querySelectorAll('.theme-color');

themeColors.forEach(themeColor => {
  themeColor.addEventListener('click', e => {
    themeColors.forEach(c => c.classList.remove('active'));
    const theme = themeColor.getAttribute('data-color');
    document.body.setAttribute('data-theme', theme);
    themeColor.classList.add('active');
  });
});


const editors = document.querySelectorAll('.icon-editor');
editors.forEach(editor =>{
  editor.addEventListener('click',e=>{
    if ($(editor).hasClass('talk-switch-item')){
      $(editor).toggleClass('talk-switch-item');
      $(editor).css('color','red');
      $(editor).prev().addClass('talk-border').removeAttr('readonly').focus();
    }else{
      //TODO 提交修改请求
      $(editor).toggleClass('talk-switch-item');
      $(editor).css('color','');
      $(editor).prev().removeClass('talk-border').attr('readonly','readonly').blur();
    }

  })
});
//修改用户状态
$("#switchStatus").click(function(){
  var status = $(this).is(':checked')?1:0;
  var id = $("#userinfo_id").text().split(':')[1];
  console.log(id);
  var talk = new Talk();
  $.ajax({
    url:'/user/setonline',
    data:{
      online:status,
      id:id
    },
    type:'get',
    dataType:'json',
    success:function(obj){
      if (obj){
        talk.alert({content:'修改成功！',time:2,style:'success'})
      }else{
        talk.alert({content:'修改失败！', time:2, style:'danger'})
      }
    },
    error:function(){
      talk.alert({content:'请求失败！', time:2, style:'danger'})
    }
  })
})
//获取星期
var date = new Date();
var day = $(".activity-days-wrapper .day");
day.eq(date.getDay()-1).addClass('current');