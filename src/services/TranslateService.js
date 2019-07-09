// import Translate from '@google-cloud/translate'

const projectId = 'blogdevelop-1562557566547';
const Translate = require('@google-cloud/translate');
const translate = new Translate.Translate({ projectId: projectId, });

const text = 'Hello, world!';
const target = 'ru';

export default {
  quickstart () {
    translate
      .translate(text, target)
      .then(results => {
        const translation = results[0];

        console.log(`Text: ${text}`);
        console.log(`Translation: ${translation}`);
      })
      .catch(err => {
        console.error('ERROR:', err);
    });
  }
}
// translate
//   .translate(text, target)
//   .then(results => {
//     const translation = results[0];
//
//     console.log(`Text: ${text}`);
//     console.log(`Translation: ${translation}`);
//   })
//   .catch(err => {
//     console.error('ERROR:', err);
//   });
