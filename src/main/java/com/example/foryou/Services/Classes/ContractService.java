package com.example.foryou.Services.Classes;
import com.example.foryou.DAO.Entities.Contracts;
import com.example.foryou.DAO.Entities.Notification;
import com.example.foryou.DAO.Entities.Type;
import com.example.foryou.DAO.Entities.User;
import com.example.foryou.DAO.Repositories.ContractRepository;
import com.example.foryou.Services.Interfaces.IContractService;
import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    // ********************************  Notifications
        private NotificationService notificationService;

        public void verifierContrats() throws MessagingException, javax.mail.MessagingException {
            List<Contracts> contrats = contractRepository.findByExprirationDate(LocalDate.now());
            for (Contracts contrat : contrats) {
                String message = "Cher(e) client(e), Je vous informe par le biais mail que votre contrat numéro " + contrat.getContract_id()+
                        " a expiré aujourd'hui , Son état de renouvellement :" + contrat.isRenewable() +
                        "Nous restons à votre entière disposition pour toute information complémentaire, " +
                        "veuillez agréer, Monsieur,Madame, l'expression de nos salutations les plus distinguées";
                Notification notification = new Notification();
                notification.setNotifDescription(message);
                ArrayList<User> listReceivers= new ArrayList<>();
                listReceivers.add(contrat.getUser());
                notification.setReceivers(listReceivers) ;
                for (User receiver: listReceivers){
                    notificationService.sendEmail(receiver.getEmail(), "Contrat expiré", message);
                }
            }
        }


}

