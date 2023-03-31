package com.example.foryou.Services.Classes;
import com.example.foryou.DAO.Entities.*;
import com.example.foryou.DAO.Repositories.ContractRepository;
import com.example.foryou.DAO.Repositories.NotificationRepository;
import com.example.foryou.Services.Interfaces.IContractService;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Properties;
@Service
@AllArgsConstructor
public class ContractService implements IContractService {
    private ContractRepository contractRepository;

    /////////////////////////Crud
    @Override
    public Contracts addContract(Contracts contract) {
        return contractRepository.save(contract);
    }

    @Override
    public List<Contracts> addAllContracts(List<Contracts> contractList) {
        return contractRepository.saveAll(contractList);
    }

    @Override
    public Contracts editContract(Contracts contract) {
        return contractRepository.save(contract);
    }

    @Override
    public void deleteContract(Contracts contract) {
        contractRepository.delete(contract);
    }

    @Override
    public void deleteContractById(int contractId) {
        contractRepository.deleteById(contractId);
    }

    @Override
    public void deleteAllContracts(List<Contracts> contractList) {
        contractRepository.deleteAll(contractList);
    }

    @Override
    public void deleteAllContracts() {
        contractRepository.deleteAll();
    }

    @Override
    public List<Contracts> selectAllContracts() {
        return contractRepository.findAll();
    }

    @Override
    public Contracts SelectContractById(int contractId) {
        return contractRepository.findById(contractId).get();
    }

    // ******************************** Filtrage des contracts par type de sinister
    @Override
    public List<Contracts> FilterContract(Type type) {
        return contractRepository.selectContractByType(type);
    }

    // ************** Affichage des contracts renouvelable dont la date d'expiration et la date d'aujourdhui
    @Override
    public List<Contracts> selectRenewableContract() {
        return contractRepository.selectRenewableContract();
    }

    // ********** Supprimer les contracts non renouvlable dont la date d'expiration et la date d'aujourdhui
    @Override
    public void deleteNonRenewableContract() {
        contractRepository.deleteNonRenewableContract();
    }

    // ********************************************************   Notifications
    private NotificationService notificationService;
    private NotificationRepository notificationRepository;

    // ********************************************************  Envoi du mail
    @Scheduled(cron = "0 0 8-9 * * ?")
    public void verifierContrats() throws MessagingException, javax.mail.MessagingException {
        Notification notification = new Notification();
        LocalDate localDate = LocalDate.now();
        Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        List<Contracts> contrats = contractRepository.findByExprirationDate(date);
        for (Contracts contrat : contrats) {
            String message = "Cher(e) client(e), Je vous informe par le biais mail que votre contrat numéro " + contrat.getContract_id() +
                    " a expiré aujourd'hui , Son état de renouvellement :" + contrat.isRenewable() +
                    "Nous restons à votre entière disposition pour toute information complémentaire, " +
                    "veuillez agréer, Monsieur,Madame, l'expression de nos salutations les plus distinguées";
            notification.setNotifDescription(message);
           // ArrayList<User> listReceivers = new ArrayList<>();
                User receiver = contrat.getUser();
                notificationService.sendEmail(receiver.getEmail(), "Contrat expiré", message);
            // *********** Ajout de notif
            notification.setTypeNotif(TypeNotif.CONTRACT);
            notification.setNotifDate(date);
            notification.setReceiver(receiver);
            notificationRepository.save(notification);
        }
    }
    // ********************************************************  Generer un contrat pdf
    public File genererContratPDF(Contracts contract) throws IOException, DocumentException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("contrat.pdf"));
        document.open();

        //Création d'une table avec deux colonnes pour les logos
        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(100);
        PdfPCell cell = new PdfPCell();

        //Ajouter le premier logo à la première cellule
        Image logo1 = Image.getInstance("image/logo1.png");
        logo1.scaleAbsolute(50f, 50f);
        logo1.setAlignment(Element.ALIGN_LEFT);
        cell.addElement(logo1);
        cell.setBorder(Rectangle.NO_BORDER);
        table.addCell(cell);

        //Ajouter le deuxième logo à la deuxième cellule
        Image logo2 = Image.getInstance("image/logo2.png");
        logo2.scaleAbsolute(70f, 70f);
        logo2.setAlignment(Element.ALIGN_RIGHT);
        cell = new PdfPCell();
        cell.addElement(logo2);
        cell.setBorder(Rectangle.NO_BORDER);
        table.addCell(cell);

        document.add(table);

        document.add(new Paragraph("Contrat"));
        document.add(new Paragraph("ID: " + contract.getContract_id()));
        document.add(new Paragraph("Date de création: " + contract.getCreationDate()));
        document.add(new Paragraph("Date d'expiration: " + contract.getExprirationDate()));
        // Ajouter d'autres informations du contrat
        document.close();
        return null;
    }


    // ******************************************************** Envoyer contrat par mail

    public void envoyerContratParEmail(User user, Contracts  contract) throws javax.mail.MessagingException {
        String smtpHost = "smtp.gmail.com";
        String smtpPort = "587";
        String smtpUsername = "lina.hermessi9@gmail.com";
        String smtpPassword = "vxuyjkgyopoliymx";
        String sender = "lina.hermessi9@gmail.com";
        String subject = "Nouveau contrat";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", smtpHost);
        props.put("mail.smtp.port", smtpPort);

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(smtpUsername, smtpPassword);
            }
        });

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(sender));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(user.getEmail()));
        message.setSubject(subject);

        // Créer le contenu du message
        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setText("Bonjour "+ user.getLastName()+" "+ user.getFirstName() + ",\n\nVeuillez trouver ci-joint le contrat \"" + contract.getContract_id() + "\".");

        // Créer la pièce jointe PDF
        MimeBodyPart pdfAttachment = new MimeBodyPart();
        DataSource source = new FileDataSource("contrat.pdf");
        pdfAttachment.setDataHandler(new DataHandler(source));
        pdfAttachment.setFileName("contrat.pdf");

        // Ajouter la pièce jointe PDF au message
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
        multipart.addBodyPart(pdfAttachment);
        message.setContent(multipart);
        // Envoyer le message
        Transport.send(message);
    }
    }

