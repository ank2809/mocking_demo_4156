package com.user;

import com.creditcard.CreditCard;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


public class TestPayment {

    @Test
    public void testNoMock() {

        UserDB db = new UserDB();

        CreditCard valid = new CreditCard("1234567890123456", 9, 28, "111");
        CreditCard invalidNumber = new CreditCard("1234", 7, 24, "222");
        CreditCard invalidMonth = new CreditCard("1234567890123456", 13, 28, "333");

        User user1 = new User(1);
        User user2 = new User(2);
        User user3 = new User(3);
        User user4 = new User(4);

        assertFalse(user2.processPayment(db));
        assertFalse(user3.processPayment(db));
        assertFalse(user1.processPayment(db));
        assertFalse(user4.processPayment(db));

        db.addCCToUserID(1, valid);
        db.addCCToUserID(2, invalidNumber);
        db.addCCToUserID(3, invalidMonth);

        assertTrue(user1.processPayment(db));
        assertFalse(user2.processPayment(db));
        assertFalse(user3.processPayment(db));
        assertFalse(user4.processPayment(db));

    }

    @Test
    public void testWithMock() {

        UserDB db = mock(UserDB.class);

        CreditCard valid = new CreditCard("1234567890123456", 9, 28, "111");
        CreditCard invalidCvv = new CreditCard("1234567890123456", 7, 24, "abc");
        CreditCard invalidYear = new CreditCard("1234567890123456", 10, 20, "333");

        User user1 = new User(1);
        User user2 = new User(2);
        User user3 = new User(3);
        User user4 = new User(4);

        when(db.getCCFromUserID(1)).thenReturn(valid);
        when(db.getCCFromUserID(2)).thenReturn(invalidCvv);
        when(db.getCCFromUserID(3)).thenReturn(invalidYear);
        when(db.getCCFromUserID(4)).thenReturn(null);

        assertTrue(user1.processPayment(db));
        assertFalse(user2.processPayment(db));
        assertFalse(user3.processPayment(db));
        assertFalse(user4.processPayment(db));


    }
}
