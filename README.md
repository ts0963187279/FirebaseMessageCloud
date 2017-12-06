<br>使用此專案需執行下步驟</br>
<br>setp1.</br>
<br>在Firebase上新增專案,進入專案設定中選擇CLOUD MESSAGING標籤,複製伺服器金鑰至./example/src/resources/local.properties中並命名為authorizationKey</br>
<br>setp2.</br>
<br>在Android上使用FirebaseInstanceId.getInstance().getToken()取得registrationToken,將registrationToken複製至./example/src/resources/local.properties並命名為registrationToken</br>
<br>link : Firebase Console https://console.firebase.google.com/u/1/?pli=1</br>

