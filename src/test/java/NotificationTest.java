import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.*;
import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @abdullah
 * 1- first we grab the service-account json file from firebase admin -> settings
 * 2- we init firebase App [initFirebaseApp()]
 * 3- we grab the registration token from the client
 * 4- we create notification object :-
 *  Notification notification =  Notification.builder()
 *                 .setTitle("اشعار من البلدية")
 *                 .setBody("بيانات الاشعار")
 *                 .build();
 * 5- we create WebPushNotification object to set Icon for web
 *
 *          WebpushNotification webPushNotification =
 *          WebpushNotification
 *            .builder()
 *            .setIcon("https://firebasestorage.googleapis.com/v0/b/veemu-33e81.appspot.com/o/logo_1.png?alt=media&token=6cf8bb40-f332-4b2e-b2d5-c1bb85a7ef28")
 *            .build();
 *
 * 6- we create WebpushFcmOptions for creating the link which user click to notification for navigation
 *
 *       WebpushFcmOptions webpushFcmOptions = WebpushFcmOptions.withLink("https://dmt.gov.ae/");
 *
 * 7- we create WebpushConfig and add both [WebPushNotification] and [WebpushFcmOptions]
 *
 *              WebpushConfig config =
 *                 WebpushConfig
 *                         .builder()
 *                         .setNotification(webPushNotification) /// and this?
 *                         .setFcmOptions(webpushFcmOptions)
 *                         .build();
 *
 *  8- we then create Notification Message object
 *
 *            Message message = Message.builder()
 *                 .putData("key1", "data1")
 *                 .setWebpushConfig(config)
 *                 .putData("key2", "data2")
 *                 .putData("icon","https://firebasestorage.googleapis.com/v0/b/veemu-33e81.appspot.com/o/logo_1.png?alt=media&token=6cf8bb40-f332-4b2e-b2d5-c1bb85a7ef28")
 *                 .setToken(registrationToken)
 *                 .setNotification(notification)/// this ?
 *                 .build();
 *
 *         String response = FirebaseMessaging.getInstance().send(message);
 *
 *         System.out.println("Successfully sent message: " + response);
 *
 *  // DONE //
 *
 */

public class NotificationTest {



    @Test
    public void FcmTest() throws IOException, FirebaseMessagingException {

        initFirebaseApp();

        //@abdullah please be sure token is up to date
        String registrationToken
                = "cpJjSLI3pP9zhlzBUhZnvd:APA91bEpyMWL2il1NHFel8K3j6CZkRTLrZpeqG5UM8eItczyvujImpkUeRcgWRwupAvSdDmNDo83wfLwU-uZsu5pK1AfLiUTav0QbA3fPqC1EszKxAHnIe9jweRYIbBpIHG-VEyPfcKT";


        Notification notification =  Notification.builder()
                .setTitle("اشعار من البلدية")
                .setBody("بيانات الاشعار")
                .build();


        WebpushNotification webPushNotification =
                WebpushNotification
                        .builder()
                        .setIcon("https://firebasestorage.googleapis.com/v0/b/veemu-33e81.appspot.com/o/logo_1.png?alt=media&token=6cf8bb40-f332-4b2e-b2d5-c1bb85a7ef28")
                        .build();

        WebpushFcmOptions webpushFcmOptions = WebpushFcmOptions.withLink("https://dmt.gov.ae/");

        WebpushConfig config =
                WebpushConfig
                        .builder()
                        .setNotification(webPushNotification) /// and this?
                        .setFcmOptions(webpushFcmOptions)
                        .build();

        Message message = Message.builder()
                .putData("key1", "data1")
                .setWebpushConfig(config)
                .putData("key2", "data2")
                .putData("icon","https://firebasestorage.googleapis.com/v0/b/veemu-33e81.appspot.com/o/logo_1.png?alt=media&token=6cf8bb40-f332-4b2e-b2d5-c1bb85a7ef28")
                .setToken(registrationToken)
                .setNotification(notification)/// this ?
                .build();

        String response = FirebaseMessaging.getInstance().send(message);

        System.out.println("Successfully sent message: " + response);


    }



    void initFirebaseApp() throws IOException {

        FileInputStream serviceAccount =
                new FileInputStream("service_account.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://veemu-33e81.firebaseio.com")
                .build();

        FirebaseApp.initializeApp(options);

    }
}
