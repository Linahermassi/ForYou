package com.example.foryou.Services.Classes;

import com.example.foryou.Services.Interfaces.IStripeService;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.Customer;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class StripeService implements IStripeService {/*
    @Value("${stripe.secretKey}")
    private String secretKey;
    @Value("${stripe.publicKey}")
    private String stripePublicKey;

    public String getPublicKey() {
        return stripePublicKey;
    }

    public String createCustomer(String email, String stripeToken) throws StripeException {
        Stripe.apiKey = secretKey;

        Map<String, Object> customerParams = new HashMap<>();
        customerParams.put("email", email);
        customerParams.put("source", stripeToken);

        Customer customer = Customer.create(customerParams);

        return customer.getId();
    }
    public String createCharge(String customerId, double montant) throws StripeException {
        Stripe.apiKey = secretKey;

        Map<String, Object> chargeParams = new HashMap<>();
        chargeParams.put("amount", (int) (montant * 100));
        chargeParams.put("currency", "EUR");
        chargeParams.put("customer", customerId);

        Charge charge = Charge.create(chargeParams);

        return charge.getId();
    }*/
    @Value("${stripe.secret.key}")
    private String secretKey;

    public Charge chargeCreditCard(String token, int amount) throws StripeException {
        Stripe.apiKey = secretKey;

        Map<String, Object> chargeParams = new HashMap<>();
        chargeParams.put("amount", amount);
        chargeParams.put("currency", "usd");
        chargeParams.put("source", token);

        Charge charge = Charge.create(chargeParams);
        return charge;
    }
}
