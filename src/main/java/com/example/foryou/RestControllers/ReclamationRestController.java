package com.example.foryou.RestControllers;

import com.example.foryou.DAO.Entities.Reclamation;
import com.example.foryou.Services.Interfaces.IReclamationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Reclamation")
public class ReclamationRestController {
    private IReclamationService iReclamationService;
    @PostMapping("/ajouterReclamation")
    public ResponseEntity<String> addReclamation(@RequestBody Reclamation reclamation) {
        iReclamationService.add(reclamation);
        return ResponseEntity.ok("Added successfully.");
    }

    @PostMapping("ajouterAllReclamations")
    public ResponseEntity<String> addAllReclamation(@RequestBody List<Reclamation> reclamationList) {
        iReclamationService.addAll(reclamationList);
        return ResponseEntity.ok("Added successfully.");
    }

    @PutMapping("/ModifierReclamation")
    public ResponseEntity<String> editReclamation(@RequestBody Reclamation reclamation) {
        iReclamationService.edit(reclamation);
        return ResponseEntity.ok("Edited successfully.");
    }

    @DeleteMapping("SupprimerReclamation")
    public ResponseEntity<String> delete(@RequestBody Reclamation reclamation) {
        iReclamationService.delete(reclamation);
        return ResponseEntity.ok("Deleted successfully.");
    }

    @DeleteMapping("/SupprimerReclamationById")
    public ResponseEntity<String> supprimerReclamationById(@RequestParam int ReclamationId) {
        iReclamationService.deleteById(ReclamationId);
        return ResponseEntity.ok("Deleted successfully.");
    }

    @DeleteMapping("/SupprimerAllReclamations")
    public ResponseEntity<String> supprimerAllReclamations(@RequestBody List<Reclamation> ReclamationList) {
        iReclamationService.deleteAll(ReclamationList);
        return ResponseEntity.ok("Deleted successfully.");
    }

    @DeleteMapping("/SupprimerAll")
    public ResponseEntity<String> SupprimerAll() {
        iReclamationService.deleteAll();
        return ResponseEntity.ok("Deleted successfully.");
    }
}
