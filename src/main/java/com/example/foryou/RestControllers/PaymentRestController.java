package com.example.foryou.RestControllers;

import com.example.foryou.DAO.Entities.Contracts;
import com.example.foryou.DAO.Repositories.ContractRepository;
import com.example.foryou.Services.Classes.StripeClient;
import com.example.foryou.Services.Interfaces.IContractService;
import com.stripe.model.Charge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/payment")
public class PaymentRestController {
    ContractRepository contractRepository;
    private StripeClient stripeClient;

    @Autowired
    PaymentRestController(StripeClient stripeClient) {
        this.stripeClient = stripeClient;
    }

    @PostMapping("/charge")
    public Charge chargeCard(HttpServletRequest request) throws Exception {
        String token = request.getHeader("token");
        Double amount = Double.parseDouble(request.getHeader("amount"));
        return this.stripeClient.chargeCreditCard(token, amount);
    }
   /* @PostMapping("/charge/1")
    public Charge chargeCard(HttpServletRequest request) throws Exception {
        String token = request.getHeader("token");
        Double amount = Double.parseDouble(request.getHeader("amount"));
        Contracts contract = contractRepository.findById(1).get();
        stripeClient.createCustomer(token);
        return this.stripeClient.chargeCustomerCard(contract);
    }*/
}
