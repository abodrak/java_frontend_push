
importScripts('https://www.gstatic.com/firebasejs/7.9.1/firebase-app.js')
importScripts('https://www.gstatic.com/firebasejs/7.9.1/firebase-messaging.js')




//<script src="https://www.gstatic.com/firebasejs/7.9.1/firebase-app.js"></script>


var firebaseConfig = {
    apiKey: "AIzaSyBXKceVrHw1fAGnudO2sD0LUZfLxe6U360",
    authDomain: "veemu-33e81.firebaseapp.com",
    databaseURL: "https://veemu-33e81.firebaseio.com",
    projectId: "veemu-33e81",
    storageBucket: "veemu-33e81.appspot.com",
    messagingSenderId: "63754329345",
    appId: "1:63754329345:web:0ffc398085d108e6a14f00"
  };

  firebase.initializeApp(firebaseConfig);

  const messaging = firebase.messaging();
//   messaging.requestPermission( )
//   .then(function( ){
//       console.log('Permission granted')
//   })
//   .catch(function(err){
//       console.log('Permission not granted')
//   })
