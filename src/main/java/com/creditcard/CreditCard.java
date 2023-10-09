package com.creditcard;

public class CreditCard {
    private String number;
    private int expYear;
    private int expMonth;
    private String cvv;

    private final static int NUMBER_LENGTH = 16;
    private final static int CVV_LENGTH = 3;

    public CreditCard(String number, int expMonth, int expYear, String cvv) {
        this.number = number;
        this.expYear = expYear;
        this.expMonth = expMonth;
        this.cvv = cvv;
    }
    private boolean validateNumber() {
        if (number.length() != NUMBER_LENGTH) {
            return false;
        }
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            if (!Character.isDigit(number.charAt(i))) {
                return false;
            }
        }

        return (number.charAt(0) != '0');
    }

    private boolean validateCvv() {
        if (cvv.length() != CVV_LENGTH) {
            return false;
        }
        for (int i = 0; i < CVV_LENGTH; i++) {
            if (!Character.isDigit(cvv.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean validateExpMonth() {
        return expMonth >= 1 && expMonth <= 12;
    }

    private boolean validateExpYear() {
        return expYear >= 24 && expYear <= 30;
    }

    public boolean validateCreditCard() {
        return validateNumber() && validateCvv() && validateExpMonth() && validateExpYear();
    }
}
