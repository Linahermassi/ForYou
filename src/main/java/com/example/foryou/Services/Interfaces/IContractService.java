package com.example.foryou.Services.Interfaces;

import com.example.foryou.DAO.Entities.Contracts;
import com.example.foryou.DAO.Entities.Type;
import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface IContractService {
    Contracts addContract (Contracts contract);
    Contracts editContract (Contracts contract);
    List<Contracts> selectAllContracts();
    Contracts SelectContractById(int contractId);
    void deleteContractById(int ContractId);
    void deleteContract (Contracts contract);
    List<Contracts> addAllContracts(List<Contracts> contractList);
    void deleteAllContracts (List<Contracts> contractList);
    void deleteAllContracts();
    // ************** Filtrage des contracts par type de sinister
    List<Contracts> FilterContract(Type type);
    // ************** Affichage des contracts renouvelable dont la date d'expiration est aujourdhui
    List<Contracts> selectRenewableContract();
    // ********** Supprimer les contracts non renouvlable dont la date d'expiration est aujourdhui
    void deleteNonRenewableContract ();
     void verifierContrats() throws MessagingException , javax.mail.MessagingException ;


}
