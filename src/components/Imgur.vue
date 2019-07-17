<template>
  <div class="up">
    <img id="image" :src="url" style="width: 200px; height: auto;"/>
    <v-text-field label="Select Image" @click='pickFile' v-model='imageName' prepend-icon='attach_file'></v-text-field>
    <input name="img" ref="inputFile" type="file" style="display: none" @change="onFileChagne"/>
  </div>
</template>

<script type="text/javascript">
export default {
    name: 'Imgur',
    data () {
      return {
        imageName: '',
        url: 'http://dy.gnch.or.kr/img/no-image.jpg'
      }
    },
    methods: {
      pickFile() {
        this.$refs.inputFile.click()
      },
      onFileChagne(e) {
        const file = e.target.files[0];
        this.imageName = file.name;
        this.url = URL.createObjectURL(file);
        this.$emit('pass', file);
      }
    }
}
</script>
