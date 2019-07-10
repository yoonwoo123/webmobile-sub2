<template>
  <div>
    <!-- <Header></Header> -->
    <ImgBanner id="image" class="" imgSrc="https://source.unsplash.com/1600x900/?newyork">
      <div style="line-height:1.2em;" slot="text" class="display-3 font-weight-black">
        <strong style="font-size:10vw">Stay hungry,<br> Stay foolish!</strong>
      </div>
    </ImgBanner>
    <div class="filebox">
      <label for="ex-file">배너 변경하기</label>
      <input id="ex-file" name="img" type="file"/>
    </div>

    <v-container>
      <!-- About Me -->
      <v-layout my-5>
        <v-flex xs12 sm8 text-xs-center text-sm-left>
          <h2 class="headline mb-3 font-weight-bold t-auto">About Me</h2>
          <p class="mr-4 c-auto">안녕하세요! 윤현규입니다.<br/>함께 프로젝트를 진행하게 되어서 기쁩니다. Vue는 어렵지만. 차근차근 하나씩 따라하다보면 어느새 멋진 블로그를
            만들수 있지 않을까요? 화이팅하고 열심히 하도록 하겠습니다.</p>
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

import ImgBanner from '../components/ImgBanner'
import PortfolioList from '../components/PortfolioList'
import PostList from '../components/PostList'
import RepositoryList from '../components/RepositoryList'

export default {
	name: 'HomePage',
	components: {
		ImgBanner,
		PortfolioList,
		PostList,
		RepositoryList
	},
	methods: {
		getImgUrl(img) {
			return require('../assets/' + img)
		}
	},
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
