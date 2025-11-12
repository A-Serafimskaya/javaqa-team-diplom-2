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
    public void shouldNotCreateCreditAccountIfNegativeInitialBalance() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(
                    -20,
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
    public void testPayPositive() {
        CreditAccount account = new CreditAccount(
                500,
                1000,
                10
        );

        Assertions.assertTrue(account.pay(800));
    }

    @Test
    public void testPositivePayMax() {
        CreditAccount account = new CreditAccount(
                500,
                1000,
                10
        );

        Assertions.assertTrue(account.pay(1500));
    }

    @Test
    public void testPayNegativeAmount() {
        CreditAccount account = new CreditAccount(
                500,
                1000,
                10
        );

        Assertions.assertFalse(account.pay(-1000));
    }

    @Test
    public void testNegativePayOverLimit() {
        CreditAccount account = new CreditAccount(
                500,
                1000,
                10
        );

        Assertions.assertFalse(account.pay(2000));
    }



    @Test
    public void testAddPositiveAmount() {
        CreditAccount account = new CreditAccount(
                500,
                1000,
                10
        );

        Assertions.assertTrue(account.add(1500));
    }

    @Test
    public void shouldAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                20,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(3_020, account.getBalance());
    }

    @Test
    public void testAddNegativeAmount() {
        CreditAccount account = new CreditAccount(
                500,
                1000,
                10
        );

        Assertions.assertFalse(account.add(-500));
        Assertions.assertFalse(account.add(0));
    }

        @Test
        public void shouldNotAddNegativeAmount() {
            CreditAccount account = new CreditAccount(
                    500,
                    1000,
                    10
            );

            account.add(-500);

        Assertions.assertEquals(0, account.getBalance() );
    }

    @Test
    public void shouldCalculateInterestIfBalanceBelow0() {
        CreditAccount account = new CreditAccount(
                -100,
                1000,
                10
        );
        int expected = -10;
        int actual = account.yearChange();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotCalculateInterestIfBalanceOver0() {
        CreditAccount account = new CreditAccount(
                500,
                1000,
                10
        );

        int expected = 0;
        int actual = account.yearChange();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotCalculateInterestIfBalanceO() {
        CreditAccount account = new CreditAccount(
                0,
                1000,
                10
        );

        int expected = 0;
        int actual = account.yearChange();
        Assertions.assertEquals(expected, actual);
    }
}

