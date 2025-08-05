package com.example.appointment.apptapi.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.io.IOException;

@Configuration
public class FirestoreConfig {

    private static final Log logger = LogFactory.getLog(FirestoreConfig.class);

    /**
     * Get connection to Firestore managed instance database
     */
    @Bean
    public Firestore getFirestore() {
        logger.info("Initializing Firestore connection.");
        try {
        // The SDK will automatically find the credentials and project ID from the
        // environment. This works in most GCP environments (e.g., App Engine,
        // Cloud Run, GKE, Compute Engine) when Application Default Credentials are set up.
        GoogleCredentials credentials = GoogleCredentials.getApplicationDefault();

        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(credentials)
                .build();

        // Initialize the app if not already initialized
        if (FirebaseApp.getApps().isEmpty()) {
            FirebaseApp.initializeApp(options);
            logger.info("FirebaseApp has been initialized.");
        }
    }catch (IOException ioe) {
        logger.error("FireStore",ioe);
    }
        return FirestoreClient.getFirestore();
    }

}
