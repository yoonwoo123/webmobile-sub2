<template>
  <div>
    <ImgBanner id="image" imgSrc="https://source.unsplash.com/1600x900/?newyork">
      <div style="line-height:1.2em;font-size:1.2em;" slot="text">Post</div>
    </ImgBanner>
    <!-- <ImgurBanner></ImgurBanner> -->
    <v-container>

      <!-- Post -->
      <v-layout>
        <v-flex xs12>
          <PostList :limits="6" :load-more="true"></PostList>
        </v-flex>
        <!-- <Imgur></Imgur> -->
      </v-layout>

    </v-container>
  </div>
</template>

<script>
import FirebaseService from '@/services/FirebaseService'
import ImgBanner from '../components/ImgBanner'
import PostList from '../components/PostList'
import Imgur from '../components/Imgur'
import ImgurBanner from '../components/ImgurBanner'

export default {
	name: 'PostPage',
	components: {
		ImgBanner,
		PostList,
    Imgur,
    ImgurBanner
	},
  mounted () {
    FirebaseService.logging(this.$session.get("name"), this.$route['path'])
  }
}
</script>
