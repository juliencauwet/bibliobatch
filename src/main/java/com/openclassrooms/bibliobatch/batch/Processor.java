package com.openclassrooms.bibliobatch.batch;

import com.openclassrooms.biblioback.ws.test.Borrowing;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

@Component
public class Processor implements ItemProcessor<Borrowing,SimpleMailMessage>{


    @Override
    public SimpleMailMessage process(Borrowing borrowing) throws Exception {
        SimpleMailMessage email = new SimpleMailMessage();
        String content = "Bonjour M./ Mme " + borrowing.getAppUser().getName() + ".\n" +
                "Vous avez emprunté le livre de " + borrowing.getBook().getAuthorFirstName() + " " + borrowing.getBook().getAuthorName() +
                ", qui s'intitule " + borrowing.getBook().getTitle() + "." + '\'' +
                "Le livre aurait dû être restitué avant le " + borrowing.getDueReturnDate() + " mais il ne nous a pas été retourné à ce jour." +
                "Nous vous prions de bien vouloir le rapporter dès que possible.\nCordialement, \n" +
                "L'équipe de Biblioweb.";
        System.out.println("dans le processor: " + borrowing.getAppUser().getEmail());
        email.setTo(borrowing.getAppUser().getEmail());
        email.setFrom("jaycecordon@gmail.com");
        email.setText(content);
        email.setSubject("Date de retour de livre expirée");

        return email;
    }

}
