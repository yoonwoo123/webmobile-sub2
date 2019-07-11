<template>
  <v-container>
      <v-layout>

      <v-flex>

        <h2 class="headline mb-3 font-weight-bold text-xs-center">Portfolio 작성</h2>
        <v-text-field label="Title" regular></v-text-field>
        <markdown-editor v-model="content" ref="markdownEditor"></markdown-editor>
        <div class="text-xs-right">
        <v-btn color="blue-grey lighten-4" @click="post">등록하기</v-btn>
        <v-btn>취소</v-btn>


        <!-- <img id="image" src="http://dy.gnch.or.kr/img/no-image.jpg" /> -->
        <!-- <input name="img" type="file"/> -->
        <Imgur></Imgur>
      </div>
      </v-flex>
    </v-layout>
  </v-container>
</template>

<script type="text/javascript">
import FirebaseService from '@/services/FirebaseService'
import Imgur from '../components/Imgur'

// function uploadImageByImgur(file, callback) {
//     var form = new FormData();
//     form.append('image', file);
//     $.ajax({
//         xhr: function(){
//             var xhr = new window.XMLHttpRequest();
//             xhr.upload.addEventListener("progress", function(evt){// 업로드상태이벤트리스너등록
//                 if (evt.lengthComputable) {
//                     console.log("업로드진행률:"+parseInt( (evt.loaded / evt.total * 100), 10)+"%");
//                 }
//             }, false);
//             return xhr;
//         },
//         url: 'https://api.imgur.com/3/image',// 업로드요청주소
//         headers: { Authorization: 'Client-ID 6c4e7e9374b1faf' },
//         type: 'POST',
//         data: form,
//         cache: false,
//         contentType: false,
//         processData: false
//     }).always(callback);
// }
//
// /*
// 파일 변경 이벤트가 감지되면 자동으로 이미지 업로드
// */
//
// $(document).ready(function(){ // document가 모두 로드되면 실행됨
//   $("input[name=img]").change(function(){// 사용자가 파일을 변경했을때 발생됨
//     var file = this.files[0];
//     uploadImageByImgur(file, function(result){
//       console.log(result);
//       console.log('업로드결과:'+result.status);
//
//       if(result.status!=200){
//       result = $.parseJSON(result.responseText);
//       }
//
//       if(result.data.error){
//       console.log('지원하지않는 파일형식..');
//
//       }else{
//       var image = document.getElementById('image');
//       var vim = image.getElementsByClassName('v-image__image--cover')
//       // var vim = document.getElementsByClassName('v-image')
//       console.log('업로드된 파일경로:'+result.data.link);
//       console.log(image);
//       // var vim = $(".vv").hide();
//       // console.log(vim[0].style['backgroundImage']);
//       // console.log(vim[0])
//       // vim[0].style['backgroundImage'] = 'url(' + result.data.link + ')';
//       image.src = result.data.link;
//       // console.log(image.src)
//       }
//     });
//   });
// });

export default {
	name: 'PortfolioWriterPage',
	components: {
    Imgur
	},
  methods:{
    post:function(){
      firebase.postPortfolio(this.title, this.body, "http://dy.gnch.or.kr/img/no-image.jpg")
    }
  },
  mounted () {
    FirebaseService.logging(this.$session.get("name"), this.$route['path'])
  }
}

</script>
