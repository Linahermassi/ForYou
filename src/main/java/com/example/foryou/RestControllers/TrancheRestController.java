package com.example.foryou.RestControllers;

import com.example.foryou.DAO.Entities.Tranche;
import com.example.foryou.Services.Interfaces.ITrancheService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Tranche")


public class TrancheRestController {
    private ITrancheService iTrancheService;
    @PostMapping("/ajouterTranche")
    public ResponseEntity<String> add(@RequestBody Tranche tranche){
        iTrancheService.add(tranche);
        return ResponseEntity.ok("Added successfully.");
    }
    @PostMapping("/ajouterAllTranches")
    public ResponseEntity<String> addAll(@RequestBody List<Tranche> TrancheList){
        iTrancheService.addAll(TrancheList);
        return ResponseEntity.ok("Added successfully.");
    }
    @PutMapping("/ModifierTranche")
    public ResponseEntity<String> edit(@RequestBody Tranche Tranche){
        iTrancheService.edit(Tranche);
        return ResponseEntity.ok("Edited successfully.");
    }
    @DeleteMapping("/SupprimerTranche")
    public ResponseEntity<String> delete(@RequestBody Tranche Tranche){
        iTrancheService.delete(Tranche);
        return ResponseEntity.ok("Deleted successfully.");
    }
    @DeleteMapping("/SupprimerTrancheById")
    public ResponseEntity<String> deleteTrancheById(@RequestParam int TrancheId){
        iTrancheService.deleteById(TrancheId);
        return ResponseEntity.ok("Deleted successfully.");
    }
    @DeleteMapping("/SupprimerAllTranches")
    public ResponseEntity<String> supprimerAllContracts(@RequestBody List<Tranche> TrancheList){
        iTrancheService.deleteAll(TrancheList);
        return ResponseEntity.ok("Deleted successfully.");
    }
    @DeleteMapping("/SupprimerTranches")
    public ResponseEntity<String> SupprimerAll() {
        iTrancheService.deleteAll();
        return ResponseEntity.ok("Deleted successfully.");
    }
    @GetMapping("/afficherTrancheById")
    public Tranche afficherTrancheById(@PathVariable int TrancheId ) {

        return iTrancheService.selectById(TrancheId);
    }
    @GetMapping("/afficherAllTranches")
    public List<Tranche> afficherAll(){
        return iTrancheService.selectAll();
    }
}