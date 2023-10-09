package com.user;

import com.creditcard.CreditCard;

public class User {

    private int id;

    public User(int id) {
        this.id = id;
    }

    public boolean processPayment(UserDB db) {
        CreditCard creditCard = db.getCCFromUserID(id);
        if (creditCard == null) {
            return false;
        }
        return creditCard.validateCreditCard();
    }
}
