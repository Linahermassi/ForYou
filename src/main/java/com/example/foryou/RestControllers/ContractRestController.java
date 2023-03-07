package com.example.foryou.RestControllers;

import com.example.foryou.DAO.Entities.Contracts;
import com.example.foryou.DAO.Entities.Type;
import com.example.foryou.Services.Interfaces.IContractService;
import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Contract")
public class ContractRestController {
    private IContractService iContractService;
    @PostMapping("/ajouterContract")
    public ResponseEntity<String> addContract(@RequestBody Contracts contract){
        iContractService.addContract(contract);
        return ResponseEntity.ok("Added successfully.");
    }
    @PostMapping("ajouterAllContracts")
    public ResponseEntity<String> addAllContract(@RequestBody List<Contracts> contractList){
         iContractService.addAllContracts(contractList);
        return ResponseEntity.ok("Added successfully.");
    }
    @PutMapping("/ModifierContract")
    public ResponseEntity<String> editContract(@RequestBody Contracts contract){
        iContractService.editContract(contract);
        return ResponseEntity.ok("Edited successfully.");
    }
    @DeleteMapping("SupprimerContract")
    public ResponseEntity<String> deleteContract(@RequestBody Contracts contract){
        iContractService.deleteContract(contract);
        return ResponseEntity.ok("Deleted successfully.");
    }
    @DeleteMapping("/SupprimerContractById")
    public ResponseEntity<String> supprimerContractById(@RequestParam int contractId){
        iContractService.deleteContractById(contractId);
        return ResponseEntity.ok("Deleted successfully.");
    }
    @DeleteMapping("/SupprimerAllContracts")
    public ResponseEntity<String> supprimerAllContracts(@RequestBody List<Contracts> contractList){
        iContractService.deleteAllContracts(contractList);
                return ResponseEntity.ok("Deleted successfully.");
}
    @DeleteMapping("/SupprimerAll")
    public ResponseEntity<String> SupprimerAll() {
        iContractService.deleteAllContracts();
        return ResponseEntity.ok("Deleted successfully.");
    }
    //////
    @GetMapping("/afficherContractById")
    public Contracts afficherContractById(@PathVariable int contractId ) {

        return iContractService.SelectContractById(contractId);
    }
    @GetMapping("/afficherAll")
    public List<Contracts> afficherAll(){
        return iContractService.selectAllContracts();
    }
    //////////////////////////////////////
    @GetMapping("/FilterContractByType")
    public List<Contracts> FilterContract(Type type){
        return iContractService.FilterContract(type);
    }
    @GetMapping("/afficherRenewableContract")
    public List<Contracts> AfficherRenewableContract(){
        return iContractService.selectRenewableContract();
    }
    @DeleteMapping("SupprimerNonRenewableContract")
    public ResponseEntity<String> deleteNonRenewableContract(@RequestBody Date todayDate){
        iContractService.deleteNonRenewableContract(todayDate);
        return ResponseEntity.ok("Deleted successfully.");
    }
    /////////////////////////////////////
        @GetMapping("/verifier")
        public ResponseEntity<String> verifierContrats() throws MessagingException, javax.mail.MessagingException {
            iContractService.verifierContrats();
            return ResponseEntity.ok("La vérification des contrats a été effectuée avec succès.");
        }

    }


