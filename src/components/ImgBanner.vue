<template>
  <div>
    <!-- <img id="ban" src="https://source.unsplash.com/1600x900/?newyork" /> -->
    <v-img id="ban" v-bind:src="this.$store.state.imgSrc"
           aspect-ratio="1.7" v-resize="resize"  v-bind:style="{height:newHeight}">
      <v-layout align-center justify-center row fill-height>
        <v-flex text-xs-center >
          <span class="text-shadow display-2 font-weight-light">
            <slot name="text"/>
          </span>
        </v-flex>
      </v-layout>
    </v-img>
    <!-- <v-btn @click="customimage">선택 이미지 배너</v-btn> -->
    <!-- <input name="img" type="file"/> -->
  </div>
</template>

<script>

export default {
	name: 'ImgBanner',
	props: {
		res: {type: String,
             default: "https://source.unsplash.com/1600x900/?newyork"
    },
		text: {type: String}
	},
  data () {
    return {
      newHeight: null
    }
  },
  // mounted() {
  //   console.log(this.$store.state.imgSrc);
  //   var ban = document.getElementById('ban');
  //   var vim = ban.getElementsByClassName('v-image__image--cover');
  //   console.log(ban)
  //   console.log(vim[0].style['backgroundImage']);
  //   vim[0].style['backgroundImage'] = 'url(' + this.$store.state.imgSrc + ')';
  // },
	methods: {
    resize(){
      this.newHeight = window.innerWidth < 600 ? window.innerHeight-56 +'px' : null
    },
    // customimage() {
    //   console.log(document.getElementById('ban'));
    //   var ban = document.getElementById('ban');
    //   // console.log('업로드된 파일경로:'+result.data.link);
    //   // image.src = result.data.link;
    //   var vim = ban.getElementsByClassName('v-image__image--cover');
    //   //       // var vim = $(".vv").hide();
    //   console.log(vim[0].style['backgroundImage']);
    //   this.$store.state.imgSrc = vim[0].style['backgroundImage'];
    //   vim[0].style['backgroundImage'] = 'url(' + this.$store.state.imgSrc + ')';
    //   console.log(this.$store.state.imgSrc);
    // }
	},
  // mounted() {
  //   function uploadImageByImgur(file, callback) {
  //       var form = new FormData();
  //       form.append('image', file);
  //       $.ajax({
  //           xhr: function(){
  //               var xhr = new window.XMLHttpRequest();
  //               xhr.upload.addEventListener("progress", function(evt){// 업로드상태이벤트리스너등록
  //                   if (evt.lengthComputable) {
  //                       console.log("업로드진행률:"+parseInt( (evt.loaded / evt.total * 100), 10)+"%");
  //                   }
  //               }, false);
  //               return xhr;
  //           },
  //           url: 'https://api.imgur.com/3/image',// 업로드요청주소
  //           headers: { Authorization: 'Client-ID 6c4e7e9374b1faf' },
  //           type: 'POST',
  //           data: form,
  //           cache: false,
  //           contentType: false,
  //           processData: false
  //       }).always(callback);
  //   }
  //
  //   /*
  //
  //   파일 변경 이벤트가 감지되면 자동으로 이미지 업로드
  //
  //   */
  //
  //   $(document).ready(function(){ // document가 모두 로드되면 실행됨
  //
  //     $("input[name=img]").change(function(){// 사용자가 파일을 변경했을때 발생됨
  //
  //       var file = this.files[0];
  //
  //       uploadImageByImgur(file, function(result){
  //
  //         console.log(result);
  //
  //         console.log('업로드결과:'+result.status);
  //
  //         if(result.status!=200){
  //
  //         result = $.parseJSON(result.responseText);
  //
  //         }
  //
  //         if(result.data.error){
  //
  //         console.log('지원하지않는 파일형식..');
  //
  //         }else{
  //         console.log('업로드된 파일경로:'+result.data.link);
  //         var ban = document.getElementById('ban');
  //         console.log(ban)
  //         ban.src = result.data.link;
  //         }
  //       });
  //     });
  //   });
  // }
}
</script>
<style>
  .text-shadow {
    text-shadow: 0 0 15px rgb(255,255,255);
  }
</style>
