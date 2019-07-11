<template>
  <v-layout column px-4>
    <v-flex v-for="i in repositories.length > limits ? limits : repositories.length">
      <v-divider v-if="i === 1"></v-divider>
      <Repository :repos="repositories[i - 1]"></Repository>
      <v-divider></v-divider>
    </v-flex>

    <v-flex mt-2 xs12 class="hidden-xs-only">
      <h2>Commit Graph</h2>
      <div class="network-graph" data-url="./gitlab-network-graph/.data/data.json" data-commit-url="https://lab.ssafy.com/tlswhd1020/webmobile-sub2/commit/%s"></div>
    </v-flex>
  </v-layout>
</template>

<script>
import Repository from '@/components/Repository'
import GitlabService from '@/services/GitlabService'

export default {
	name: 'RepositoryList',
	props: {
		limits: {type: Number, default: 5},
		loadMore: {type: Boolean, default: false}
	},
	data() {
		return {
			repositories: []
    }
	},
	components: {
		Repository
	},
	mounted() {
		this.getGitlabRepos('hyungyu')
	},
	methods: {
		async getGitlabRepos(userName) {
			const response = await GitlabService.getRepos(userName)
			if(response.status !== 200) {
				return
			}

			this.repositories = response.data
		}
	}
}
</script>
