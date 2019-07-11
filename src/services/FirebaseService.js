import firebase from 'firebase/app'
import 'firebase/firestore'
import 'firebase/auth'

const POSTS = 'posts'
const PORTFOLIOS = 'portfolios'

// Setup Firebase
const config = {
	apiKey: "AIzaSyA2cVZgLvIuzxpt9T-Ugv4T-cmTcdOVsZs",
  authDomain: "vue-web2-5fd3f.firebaseapp.com",
  databaseURL: "https://vue-web2-5fd3f.firebaseio.com",
  projectId: "vue-web2-5fd3f",
  storageBucket: "vue-web2-5fd3f.appspot.com",
  messagingSenderId: "806725036229",
  appId: "1:806725036229:web:18080892a667aaec"
}

firebase.initializeApp(config)
const firestore = firebase.firestore()

export default {
	getPosts() {
		const postsCollection = firestore.collection(POSTS)
		return postsCollection
				.orderBy('created_at', 'desc')
				.get()
				.then((docSnapshots) => {
					return docSnapshots.docs.map((doc) => {
						let data = doc.data()
						data.created_at = new Date(data.created_at.toDate())
						return data
					})
				})
	},
	postPost(title, body) {
		return firestore.collection(POSTS).add({
			title,
			body,
			created_at: firebase.firestore.FieldValue.serverTimestamp()
		})
	},
	getPortfolios() {
		const postsCollection = firestore.collection(PORTFOLIOS)
		return postsCollection
				.orderBy('created_at', 'desc')
				.get()
				.then((docSnapshots) => {
					return docSnapshots.docs.map((doc) => {
						let data = doc.data()
						data.created_at = new Date(data.created_at.toDate())
						return data
					})
				})
	},
	postPortfolio(title, body, img) {
		return firestore.collection(PORTFOLIOS).add({
			title,
			body,
			img,
			created_at: firebase.firestore.FieldValue.serverTimestamp()
		})
	},
	logging(path) {
		return firestore.collection('LOG').add({
			path,
			created_at: firebase.firestore.FieldValue.serverTimestamp()
		})
	},
	loginWithGoogle() {
		let provider = new firebase.auth.GoogleAuthProvider()
		console.log(provider)
		return firebase.auth().signInWithPopup(provider).then(function(result) {
			let accessToken = result.credential.accessToken
			let user = result.user
			return result
		}).catch(function(error) {
			console.error('[Google Login Error]', error)
		})
	},
	loginWithFacebook() {
		let provider = new firebase.auth.FacebookAuthProvider()
		console.log(provider)
		return firebase.auth().signInWithPopup(provider).then(function(result) {
			let accessToken = result.credential.accessToken
			let user = result.user
			return result
		// ...
		}).catch(function(error) {
			console.error('[Facebook Login Error]', error)
		});
	},
	loginWithEmail(email, password){
      return firebase.auth().signInWithEmailAndPassword(email, password).catch(function(error) {
      // Handle Errors here.
      var errorCode = error.code;
      var errorMessage = error.message;
      // ...
    });
    console.log(r)
  },
	registerWithEmail(email, password, name){
		console.log(email+password+name)
    return firebase.auth().createUserWithEmailAndPassword(email, password)
		.catch(function(error) {
      // Handle Errors here.
      var errorCode = error.code;
      var errorMessage = error.message;
      // ...
    })
	},
	logout(text){
		firebase.auth().signOut().then(function() {
			console.log(text)
			firestore.state.accessToken = ""
			firestore.state.user = ""
		  // Sign-out successful.
		}).catch(function(error) {
		  // An error happened.
		});
	}
}
