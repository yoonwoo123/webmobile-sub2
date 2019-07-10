const functions = require('firebase-functions');

// The Firebase Admin SDK to access the Firebase Realtime Database.
const admin = require('firebase-admin');
admin.initializeApp();

// exports.pageview = functions.analytics.event('click').onLog((event) => {
//   const user = event.user;
//   // const uid = user.userId; // The user ID set via the setUserId API.
//   // const purchaseValue = event.valueInUSD; // Amount of the purchase in USD.
//   // const userLanguage = user.deviceInfo.userDefaultLanguage; // The user language in language-country format.
//
//   // For purchases above 500 USD, we send a coupon of higher value.
//   // if (purchaseValue > 500) {
//   //   return sendHighValueCouponViaFCM(uid, userLanguage);
//   // }
//   // return sendCouponViaFCM(uid, userLanguage);
//   console.log(user)
// });

exports.sendWelcomeEmail = functions.auth.user().onCreate((user) => {
  console.log('log')
  console.error('error')
});


exports.addMessage = functions.https.onRequest(async (req, res) => {
  // Grab the text parameter.
  const original = req.query.text;
  // Push the new message into the Realtime Database using the Firebase Admin SDK.
  const snapshot = await admin.database().ref('/messages').push({original: original});
  // Redirect with 303 SEE OTHER to the URL of the pushed object in the Firebase console.
  res.redirect(303, snapshot.ref.toString());
  console.log('1log')
  console.error('1error')
});

// exports.pv1 = functions.https.onRequest((req, res) => {
//   console.log('pv1')
// });
//
// exports.pv2 = functions.https.onCall((data, context) => {
//   console.log('data: ', data)
// });

exports.pv3 = functions.database.ref('/translate').onCreate(evnet => {
  console.log('log')
  console.error('error')
});

// exports.pv4 = functions.database.ref('/translate').on( event => {
//   console.log('log')
//   console.error('error')
// });

exports.pv5 = functions.database.ref('/translate', event => {
  console.log('log')
  console.error('error')
});

// // Create and Deploy Your First Cloud Functions
// // https://firebase.google.com/docs/functions/write-firebase-functions
//
// exports.helloWorld = functions.https.onRequest((request, response) => {
//  response.send("Hello from Firebase!");
// });
