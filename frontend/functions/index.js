const functions = require('firebase-functions');

// The Firebase Admin SDK to access the Firebase Realtime Database.
const admin = require('firebase-admin');
admin.initializeApp();

exports.sendWelcome = functions.auth.user().onCreate((user) => {
  console.log('log')
});
