package com.example.foryou.RestControllers;

import com.example.foryou.DAO.Entities.ChargeRequest;
import com.example.foryou.DAO.Entities.Contracts;
import com.example.foryou.DAO.Entities.Paiement;
import com.example.foryou.DAO.Repositories.ContractRepository;
import com.example.foryou.DAO.Repositories.PaiementRepository;
import com.example.foryou.Services.Interfaces.IStripeService;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.NoSuchElementException;

@RestController
@AllArgsConstructor
@RequestMapping("/Paiement")
public class PaiementRestController {
    private ContractRepository contratRepository;
    private PaiementRepository paiementRepository;
    private IStripeService iStripeService;
/*
    @GetMapping("/{id}")
    public String afficherFormulairePaiement(@PathVariable int id, Model model) {
        Contracts contrat = contratRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Contrat invalide : " + id));
        model.addAttribute("contrat", contrat);
        model.addAttribute("montant", contrat.getCeilingAmount());
        return "paiement/formulaire-paiement";
    }

    @PostMapping("/{id}")
    public String effectuerPaiement(@PathVariable int id, @RequestParam("stripeToken") String stripeToken) throws StripeException {
        Contracts contrat = contratRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Contrat invalide : " + id));
        double montant = contrat.getCeilingAmount();

        // Créer un client Stripe pour le paiement
        String stripeCustomerId = iStripeService.createCustomer(contrat.getUser().getEmail(), stripeToken);

        // Effectuer le paiement via Stripe
        String stripeChargeId = iStripeService.createCharge(stripeCustomerId, montant);

        // Enregistrer le paiement dans la base de données
        Paiement paiement = new Paiement();
        paiement.setContrat(contrat);
        paiement.setStripeCustomerId(stripeCustomerId);
        paiement.setStripeChargeId(stripeChargeId);
        paiement.setMontant(montant);
        paiementRepository.save(paiement);

        return "paiement/paiement-effectue";
    }
//////////
@GetMapping("/paiements/formulaire/{contratId}")
public ModelAndView afficherFormulairePaiement(@PathVariable int contratId) {
    Contracts contrat = contratRepository.findById(contratId)
            .orElseThrow(() -> new NoSuchElementException("Contrat non trouvé"));
    double montant = contrat.getCeilingAmount();
    String stripePublicKey = iStripeService.getPublicKey();
    ModelAndView modelAndView = new ModelAndView("formulaire_paiement");
    modelAndView.addObject("contrat", contrat);
    modelAndView.addObject("montant", montant);
    modelAndView.addObject("stripePublicKey", stripePublicKey);
    return modelAndView;
}
    @GetMapping("/paiements/confirmation/{contratId}/{paiementId}")
    public ModelAndView afficherConfirmationPaiement(@PathVariable Long contratId, @PathVariable String paiementId) {
        ModelAndView modelAndView = new ModelAndView("confirmation_paiement");
        return modelAndView;
    }*/

    @PostMapping("/charge")
    public ResponseEntity<Charge> chargeCard(@RequestBody ChargeRequest chargeRequest) throws StripeException {
        Charge charge = IStripeService.chargeCreditCard(chargeRequest.getToken(), chargeRequest.getAmount());
        return ResponseEntity.ok(charge);
    }
}