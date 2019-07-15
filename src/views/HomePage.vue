<template>
  <div>
    <!-- <Header></Header> -->
    <ImgBanner id="image" class="">
      <div style="line-height:1.2em;" slot="text" class="display-3 font-weight-black">
        <strong style="font-size:10vw">Stay hungry,<br> Stay foolish!</strong>
      </div>
    </ImgBanner>
    <ImgurBanner></ImgurBanner>

    <v-container>
      <!-- About Me -->
      <v-layout my-5>
        <v-flex xs12 sm8 text-xs-center text-sm-left>
          <h2 class="headline mb-3 font-weight-bold t-auto">About Me</h2>
          <p class="mr-4 c-auto">안녕하세요! 해피해킹조입니다.<br/>좋은 팀원들을 만나 프로젝트를 재밌게 진행중입니다. 저희의 이번 프로젝트 결과물을 잘 봐주세요. 감사합니다.</p>
        </v-flex>
        <v-flex sm4 class="hidden-xs-only">
          <v-img style="border-radius:15%" :src="getImgUrl('profile.jpg')" aspect-ratio="1.0"/>
        </v-flex>
      </v-layout>

      <!-- Portfolio -->
      <v-layout my-5>
        <v-flex xs12>
          <h2 class="headline my-5 text-xs-center font-weight-bold t-auto">Portfolio</h2>
          <PortfolioList></PortfolioList>
        </v-flex>
      </v-layout>

      <!-- Post -->
      <v-layout my-5>
        <v-flex xs12>
          <h2 class="headline my-5 text-xs-center font-weight-bold t-auto">Post</h2>
          <PostList :column="2"></PostList>
        </v-flex>
      </v-layout>


      <!-- Github -->
      <v-layout my-5>
        <v-flex xs12>
          <h2 class="headline my-5 text-xs-center font-weight-bold t-auto">Project</h2>
          <RepositoryList></RepositoryList>
        </v-flex>
      </v-layout>
    </v-container>
    <!-- <Footer>
    </Footer> -->
  </div>
</template>



<script>
import FirebaseService from '@/services/FirebaseService'
import ImgBanner from '../components/ImgBanner'
import PortfolioList from '../components/PortfolioList'
import PostList from '../components/PostList'
import RepositoryList from '../components/RepositoryList'
import Imgur from '../components/Imgur'
import ImgurBanner from '../components/ImgurBanner'

export default {
	name: 'HomePage',
	components: {
		ImgBanner,
		PortfolioList,
		PostList,
		RepositoryList,
    Imgur,
    ImgurBanner
	},
	methods: {
		getImgUrl(img) {
			return require('../assets/' + img)
		}
	},
  mounted () {
    FirebaseService.logging(this.$session.get("name"), this.$route['path'])
    console.log(this.$store.state.imgSrc)
  }
}
</script>

<style>
@media screen and (max-width: 600px){
  .c-auto{
    font-size: 18px!important;
  }
  .t-auto{
    font-size: 24px!important;
  }
}
@media screen and (max-width: 800px) and (min-width: 600px) {
  .c-auto{
    font-size: 3vw!important;
  }
  .t-auto{
    font-size: 4vw!important;
  }
}
@media screen and (min-width: 800px){
  .c-auto{
    font-size: 24px!important;
  }
  .t-auto{
    font-size: 32px!important;
  }
}
.filebox label {
  display: inline-block;
  padding: .5em .75em;
  color: #fff;
  font-size: inherit;
  line-height: normal;
  vertical-align: middle;
  background-color: #5cb85c;
  cursor: pointer;
  border: 1px solid #4cae4c;
  border-radius: .25em;
  -webkit-transition: background-color 0.2s;
  transition: background-color 0.2s;
}

.filebox label:hover {
  background-color: #6ed36e;
}

.filebox label:active {
  background-color: #367c36;
}

.filebox input[type="file"] {
  position: absolute;
  width: 1px;
  height: 1px;
  padding: 0;
  margin: -1px;
  overflow: hidden;
  clip: rect(0, 0, 0, 0);
  border: 0;
}
</style>
