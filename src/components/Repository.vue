<template>
  <div class="py-3">
    <v-layout>

      <v-flex xs12>
        <h2 class="font-weight-regular limit-line"><a v-bind:href="repos.http_url_to_repo">{{repos.path_with_namespace}}</a></h2>
        <p class="subheading mb-1 grey--text text--darken-1 font-weight-light">{{repos.namespace.name}}</p>
      </v-flex>

    </v-layout>
  </div>
</template>

<script>
import GitlabService from '@/services/GitlabService'

export default {
	name: 'Repository',
	props: {
		repos: {type: null}
	},
	data() {
		return {
			stats: {}
		}
	},
  mounted() {
		// this.drawStatGraph()
  },
	methods: {
		async drawStatGraph() {
			this.commits = await GitlabService.getCommits(this.repos.id)
		}
	}
}
</script>

<style>
  .limit-line{
    overflow: hidden;
   text-overflow: ellipsis;
   display: -webkit-box;
   line-height: 30px;     /* fallback */
   max-height: 30px;      /* fallback */
   -webkit-line-clamp: 1; /* number of lines to show */
   -webkit-box-orient: vertical;
  }

</style>
