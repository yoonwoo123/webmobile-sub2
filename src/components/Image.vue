<template>
  <div class="up">
    <img id="image" src="http://dy.gnch.or.kr/img/no-image.jpg" />
    <input name="img" type="file"/>
  </div>
</template>

<script type="text/javascript">

function uploadImageByImgur(file, callback) {
    var form = new FormData();
    form.append('image', file);
    $.ajax({
        xhr: function(){
            var xhr = new window.XMLHttpRequest();
            xhr.upload.addEventListener("progress", function(evt){// 업로드상태이벤트리스너등록
                if (evt.lengthComputable) {
                    console.log("업로드진행률:"+parseInt( (evt.loaded / evt.total * 100), 10)+"%");
                }
            }, false);
            return xhr;
        },
        url: 'https://api.imgur.com/3/image',// 업로드요청주소
        headers: { Authorization: 'Client-ID 6c4e7e9374b1faf' },
        type: 'POST',
        data: form,
        cache: false,
        contentType: false,
        processData: false
    }).always(callback);
}

/*

파일 변경 이벤트가 감지되면 자동으로 이미지 업로드

*/

$(document).ready(function(){ // document가 모두 로드되면 실행됨

  $("input[name=img]").change(function(){// 사용자가 파일을 변경했을때 발생됨

    var file = this.files[0];

    uploadImageByImgur(file, function(result){

      console.log(result);

      console.log('업로드결과:'+result.status);

      if(result.status!=200){

      result = $.parseJSON(result.responseText);

      }

      if(result.data.error){

      console.log('지원하지않는 파일형식..');

      }else{
      var image = document.getElementById('image');
      console.log('업로드된 파일경로:'+result.data.link);
      image.src = result.data.link;
      }
    });
  });
});
</script>
