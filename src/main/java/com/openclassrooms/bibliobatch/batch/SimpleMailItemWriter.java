package com.openclassrooms.bibliobatch.batch;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SimpleMailItemWriter implements ItemWriter<SimpleMailMessage> {

    private JavaMailSender javaMailSender;

    @Autowired
    public void setJavaMailSender(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void write(List<? extends SimpleMailMessage> messages) throws Exception {
        System.out.println("dans le write du writer");
        for (SimpleMailMessage message: messages
             ) {
            System.out.println(message.getText());
            System.out.println(message.getFrom());
            System.out.println(message.getTo());
            if(javaMailSender!= null) {
                System.out.println("mailsender: " + javaMailSender.toString());
                System.out.println(message.getSubject());
                javaMailSender.send(message);
            }else {
                System.out.println("Mailsender n'est pas défini");
            }
        }
    }
}
