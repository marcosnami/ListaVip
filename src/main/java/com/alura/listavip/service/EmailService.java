package com.alura.listavip.service;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Service;

/**
 * Created by MarcosNami on 10/14/2017.
 */
@Service
public class EmailService {

    public void enviar(String nome, String emailConvidado){
        try {
            Email email = new SimpleEmail();
            email.setHostName("smtp.googlemail.com");
            email.setSmtpPort(465);
            email.setAuthenticator(new DefaultAuthenticator("marcosnami41@gmail.com", "Prusca33"));
            email.setSSLOnConnect(true);

            email.setFrom("marcosnami41@gmail.com");
            email.setSubject("Você foi convidado pelo ListaVIP");
            email.setMsg("Olá " + nome + ". Você acaba de ser convidado pelo ListaVIP.");
            email.addTo(emailConvidado);
            email.send();

        } catch (EmailException e) {
            e.printStackTrace();
        }
    }
}
