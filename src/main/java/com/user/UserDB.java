package com.user;

import com.creditcard.CreditCard;

import java.util.HashMap;
import java.util.Map;

public class UserDB {

    private Map<Integer, CreditCard> ccInfo;

    public UserDB () {
        ccInfo = new HashMap<>();
    }

    public CreditCard getCCFromUserID(int id) {
        if (ccInfo.containsKey(id)) {
            return ccInfo.get(id);
        }
        return null;
    }

    public void addCCToUserID(int id, CreditCard creditCard) {
        ccInfo.put(id, creditCard);
    }
}
