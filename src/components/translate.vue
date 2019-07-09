<template lang="html">

</template>

<script>
async function fetchData() {
  var list = await getUserList();
  console.log(list);
}

function getUserList() {
  return new Promise(function(resolve, reject) {
    var userList = ['user1', 'user2', 'user3'];
    resolve(userList);
  });
}

async function quickstart(
  projectId = 'blogdevelop-1562557566547' // Your GCP Project Id
) {
  // Imports the Google Cloud client library
  const {Translate} = require('@google-cloud/translate');

  // Instantiates a client
  const translate = new Translate({projectId});

  // The text to translate
  const text = 'Hello, world!';

  // The target language
  const target = 'ru';

  // Translates some text into Russian
  const [translation] = await translate.translate(text, target);
  console.log(`Text: ${text}`);
  console.log(`Translation: ${translation}`);
}

fetchData();
quickstart();
export default {
  name: 'TranslatePage'
}
</script>

<style lang="css" scoped>
</style>
