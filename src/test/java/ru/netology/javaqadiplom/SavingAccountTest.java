package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class SavingAccountTest {

    SavingAccount accountPositive = new SavingAccount(
            5_000,
            3_000,
            20_000,
            10
    );

    //Негативные сценарии создания аккаунта
    @Test
    public void createErrorAccountForMaxBalance() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    5_000,
                    5_000,
                    2_000,
                    5
            );
        });
    }

    @Test
    public void createErrorAccountForMinBalance() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    5_000,
                    -5_000,
                    2_000,
                    5
            );
        });
    }

    @Test
    public void createErrorAccountForRateNegative() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    5_000,
                    5_000,
                    20_000,
                    -5
            );
        });
    }

    @Test
    public void createErrorAccountForInitBalanceHigh() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    35_000,
                    5_000,
                    20_000,
                    5
            );
        });
    }

    @Test
    public void createErrorAccountForInitBalanceLow() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    2_000,
                    5_000,
                    20_000,
                    5
            );
        });
    }

    //Позитивные тесты pay
    @Test
    public void purchaseForThousand() {
        accountPositive.pay(1_000);

        int expected = 4000;
        int actual = accountPositive.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void purchaseForMinBalance() {
        accountPositive.pay(2_000);

        int expected = 3000;
        int actual = accountPositive.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    //Негативные тесты pay
    @Test
    public void purchaseForMinusThousand() {
        accountPositive.pay(-1_000);

        int expected = 5000;
        int actual = accountPositive.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void purchaseForThreeThousand() {
        accountPositive.pay(3_000);

        int expected = 5000;
        int actual = accountPositive.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void purchaseForSixThousand() {
        accountPositive.pay(6_000);

        int expected = 5000;
        int actual = accountPositive.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    //Позитивные тесты add
    @Test
    public void shouldAddLessThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );


        account.add(3_000);

        int expected = 5000;
        int actual = account.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void addBalanceForMaxBalance() {
        accountPositive.add(15_000);

        int expected = 20000;
        int actual = accountPositive.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    //Негативные тесты add
    @Test
    public void addBalanceForSixtyThousand() {
        accountPositive.add(60_000);

        int expected = 5000;
        int actual = accountPositive.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void addBalanceForMinusThousand() {
        accountPositive.add(-1_000);

        int expected = 5000;
        int actual = accountPositive.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    //Позитивные тесты yearChange
    @Test
    public void findOutRevenue() {

        int expected = 500;
        int actual = accountPositive.yearChange();

        Assertions.assertEquals(expected, actual);
    }

    //Тесты получения баланса
    @Test
    public void getMaxBalanceTest() {

        int expected = 20_000;
        int actual = accountPositive.getMaxBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getMinBalanceTest() {

        int expected = 3_000;
        int actual = accountPositive.getMinBalance();

        Assertions.assertEquals(expected, actual);
    }
}
