<template>
  <v-layout py-4 h-100>
    <v-flex row>
      <div class="caption">{{formatedDate}}</div>
      <h2 class="color-333 headline font-weight-light limit-title">{{title}}</h2>
      <p class="mb-1 color-666 font-weight-light subheading limit-body">{{body}}</p>
    </v-flex>
  </v-layout>
</template>

<script>
export default {
	name: 'Post',
	props: {
		date: {type: Date},
		title: {type: String},
		body: {type: String}
	},
  computed: {
		formatedDate() {
			return `${this.date.getFullYear()}년 ${this.date.getMonth()}월 ${this.date.getDate()}일`
    }
  }
}
</script>
<style>
  .color-666 {
    color: #666;
  }
  .color-333 {
    color: #333;
  }
  .h-100 {
    height: 100%;
  }

  .limit-title {
    overflow: hidden;
     text-overflow: ellipsis;
     display: -webkit-box;
     line-height: 30px;     /* fallback */
     max-height: 30px;      /* fallback */
     -webkit-line-clamp: 1; /* number of lines to show */
     -webkit-box-orient: vertical;
  }

  .limit-body{
    overflow: hidden;
     text-overflow: ellipsis;
     display: -webkit-box;
     line-height: 20px;     /* fallback */
     max-height: 80px;      /* fallback */
     -webkit-line-clamp: 4; /* number of lines to show */
     -webkit-box-orient: vertical;
  }
</style>
