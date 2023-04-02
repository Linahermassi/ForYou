package com.example.foryou.Services.Interfaces;

import com.stripe.exception.StripeException;
import com.stripe.model.Charge;

public interface IStripeService {
    /*String createCustomer(String email, String stripeToken) throws StripeException;
    String createCharge(String customerId, double montant) throws StripeException;
    String getPublicKey();*/
     Charge chargeCreditCard(String token, int amount) throws StripeException;
}
