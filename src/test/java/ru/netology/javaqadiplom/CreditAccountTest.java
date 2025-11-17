package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {


    @Test
    public void shouldCreateAccountWithValidParameters() {
        CreditAccount account = new CreditAccount(
                100,
                5000,
                10);
        Assertions.assertNotNull(account);

        Assertions.assertEquals(100, account.getBalance());
        Assertions.assertEquals(5000, account.getCreditLimit());
        Assertions.assertEquals(10, account.getRate());
    }

    @Test
    public void shouldCreateAccountWith0() {
        CreditAccount account = new CreditAccount(
                0,
                0,
                0);
        Assertions.assertNotNull(account);

        Assertions.assertEquals(0, account.getBalance());
        Assertions.assertEquals(0, account.getCreditLimit());
        Assertions.assertEquals(0, account.getRate());

    }

    @Test
    public void shouldNotCreateCreditAccountIfNegativeInitialBalance() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(
                    -500,
                    3000,
                    10);
        });
    }

    @Test
    public void shouldNotCreateCreditAccountIfNegativeCreditLimit() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(
                    500,
                    -3000,
                    10);
        });
    }

    @Test
    public void shouldNotCreateCreditAccountIfNegativeRate() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(
                    500,
                    3000,
                    -10);
        });
    }

    @Test
    public void testPayBalanceOver0() {
        CreditAccount account = new CreditAccount(
                500,
                1000,
                10
        );

        Assertions.assertTrue(account.pay(300));
        Assertions.assertEquals(200, account.getBalance());
    }

    @Test
    public void testPayBalanceBelow0() {
        CreditAccount account = new CreditAccount(
                500,
                1000,
                10
        );


        Assertions.assertTrue(account.pay(800));
        Assertions.assertEquals(-300, account.getBalance());
    }


    @Test
    public void testPositivePayMax() {
        CreditAccount account = new CreditAccount(
                500,
                1000,
                10
        );

        Assertions.assertTrue(account.pay(1500));
        Assertions.assertEquals(-1000, account.getBalance());
    }

    @Test
    public void testNegativePayOverLimit() {
        CreditAccount account = new CreditAccount(
                500,
                1000,
                10
        );

        Assertions.assertFalse(account.pay(2000));
        Assertions.assertEquals(500, account.getBalance());
    }

    @Test
    public void testPayNegativeAmount() {
        CreditAccount account = new CreditAccount(
                500,
                1000,
                10
        );

        Assertions.assertFalse(account.pay(-1000));
        Assertions.assertEquals(500, account.getBalance());
    }

    @Test
    public void testAddPositiveAmount() {
        CreditAccount account = new CreditAccount(
                500,
                1000,
                10
        );

        Assertions.assertTrue(account.add(1500));
        Assertions.assertEquals(2000, account.getBalance());
    }

    @Test
    public void testAddNegativeAmount() {
        CreditAccount account = new CreditAccount(
                500,
                1000,
                10
        );

        Assertions.assertFalse(account.add(0));
        Assertions.assertFalse(account.add(-500));
        Assertions.assertEquals(500, account.getBalance());
    }

    @Test
    public void shouldCalculateInterestIfBalanceBelow0() {
        CreditAccount account = new CreditAccount(
                500,
                1000,
                10
        );

        account.pay(1000);

        Assertions.assertEquals(-50, account.yearChange());
    }

    @Test
    public void shouldNotCalculateInterestIfBalanceOver0() {
        CreditAccount account = new CreditAccount(
                500,
                1000,
                10
        );

        Assertions.assertEquals(0, account.yearChange());
    }
}
