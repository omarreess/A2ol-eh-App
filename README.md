# A2ol-eh-App
App for Replies and Comments for social media posts.
 
 App Published on Google Play :
https://play.google.com/store/apps/details?id=com.omaressam.a2oleh

<p float="left">
  <img src="https://github.com/omarreess/A2ol-eh-App/blob/master/screenshots/screenshot_1.png" width="190" />
  <img src="https://github.com/omarreess/A2ol-eh-App/blob/master/screenshots/screenshot_2.png" width="190" /> 
  <img src="https://github.com/omarreess/A2ol-eh-App/blob/master/screenshots/screenshot_3.png" width="190" /> 
  <img src="https://github.com/omarreess/A2ol-eh-App/blob/master/screenshots/screenshot_4.png" width="190" /> 
</p>



Code Features :
 - It is written with Kotlin Programming language 
 - Whole threads in the app are Coroutines and managed by its scopes
 - App's Data stored in SqlLite Database mapped by Room DB
 - Screens are Fragments for re-usability managed by Navigation graph and app contains only one activity 
 - Build with MVP Design Pattern ( Model–View–Presenter ) By classifying Code into 2 packages UI and Data (Package By Feature )
 - UI Package contains packages of each ui component 
  ( like Home package have Home fragment screen , Home View , Home Contract and Home Presenter )
 - Data Package conatains Room Database layer and Whole data of app
 - Bottom sheet dialog Fragment is used
 - Share Feature for whatsapp , messenger , Linkedin and gmail.
 - Applied The single-responsibility principle  of OOD
 - Shimmer facebook library used for progress loading 
 - Layouts made with constraint layout 
 - Fonts used from google fonts  
 - Material theme used 
 - Views used from Material Type 
 - An Interstitial and Banner Ad by Admob used 
 


Used libraries :
 -  Room Database
 -  Android Material
 -  Navigation Fragment
 -  Facebook Shimmer
 -  Firebase Ads
 -  Recyclerview
 -  Constraintlayout
