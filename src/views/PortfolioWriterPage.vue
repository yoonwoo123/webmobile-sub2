<template>
  <v-container>
      <v-layout>

      <v-flex>

        <h2 class="headline mb-3 font-weight-bold text-xs-center">Portfolio 작성</h2>
        <v-text-field label="Title" regular></v-text-field>
        <markdown-editor v-model="content" ref="markdownEditor"></markdown-editor>
        <div class="text-xs-right">
        <v-btn color="blue-grey lighten-4">등록하기</v-btn>
        <v-btn>취소</v-btn>
      </div>
      </v-flex>
    </v-layout>
  </v-container>
</template>

<script>
export default {
	name: 'PortfolioWriterPage',
	components: {
	}
}

</script>
