package com.example.appointment.apptapi.api;

import com.example.appointment.apptapi.pojo.Email;
import com.google.api.core.ApiFuture;
import com.google.protobuf.ByteString;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class EmailImpl implements EmailApi {

    private final Log logger = LogFactory.getLog(EmailImpl.class);

    /**
     * 
     * @return
     */
    @Override
    public boolean sendEmail(Email email) {

        // write your email send implementation here
        logger.info("sendEmail() - " + email);
        return true;

    }

}
