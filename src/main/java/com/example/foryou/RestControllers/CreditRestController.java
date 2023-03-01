package com.example.foryou.RestControllers;

import com.example.foryou.DAO.Entities.Credit;
import com.example.foryou.Services.Interfaces.ICreditService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Credit")


public class CreditRestController {
    private ICreditService iCreditService;
    @PostMapping("/ajouterCredit")
    public ResponseEntity<String> add(@RequestBody Credit credit){
        iCreditService.add(credit);
        return ResponseEntity.ok("Added successfully.");
    }
    @PostMapping("/ajouterAllCredits")
    public ResponseEntity<String> addAll(@RequestBody List<Credit> creditList){
        iCreditService.addAll(creditList);
        return ResponseEntity.ok("Added successfully.");
    }
    @PutMapping("/ModifierCredit")
    public ResponseEntity<String> edit(@RequestBody Credit credit){
        iCreditService.edit(credit);
        return ResponseEntity.ok("Edited successfully.");
    }
    @DeleteMapping("/SupprimerCredit")
    public ResponseEntity<String> delete(@RequestBody Credit credit){
        iCreditService.delete(credit);
        return ResponseEntity.ok("Deleted successfully.");
    }
    @DeleteMapping("/SupprimerCreditById")
    public ResponseEntity<String> deleteCreditById(@RequestParam int creditId){
        iCreditService.deleteById(creditId);
        return ResponseEntity.ok("Deleted successfully.");
    }
    @DeleteMapping("/SupprimerAllCredits")
    public ResponseEntity<String> supprimerAllContracts(@RequestBody List<Credit> creditList){
        iCreditService.deleteAll(creditList);
        return ResponseEntity.ok("Deleted successfully.");
    }
    @DeleteMapping("/SupprimerCredits")
    public ResponseEntity<String> SupprimerAll() {
        iCreditService.deleteAll();
        return ResponseEntity.ok("Deleted successfully.");
    }
    @GetMapping("/afficherCreditById")
    public Credit afficherCreditById(@PathVariable int creditId ) {

        return iCreditService.selectById(creditId);
    }
    @GetMapping("/afficherAllCredits")
    public List<Credit> afficherAll(){
        return iCreditService.selectAll();
    }
}