package com.creditcard;

public class CreditCard {
    private String number;
    private int expYear;
    private int expMonth;
    private String cvv;

    public CreditCard(String number, int expMonth, int expYear, String cvv) {
        this.number = number;
        this.expYear = expYear;
        this.expMonth = expMonth;
        this.cvv = cvv;
    }

    public String getNumber() {
        return number;
    }

    public int getExpYear() {
        return expYear;
    }

    public int getExpMonth() {
        return expMonth;
    }

    public String getCvv() {
        return cvv;
    }

    private boolean validateNumber() {
        if (number.length() != 16) {
            return false;
        }
        for (int i = 0; i < 16; i++) {
            if (!Character.isDigit(number.charAt(i))) {
                return false;
            }
        }

        if (number.charAt(0) == '0') {
            return false;
        }

        return true;
    }

    private boolean validateCvv() {
        if (cvv.length() != 3) {
            return false;
        }
        for (int i = 0; i < 3; i++) {
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
