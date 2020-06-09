package com.sbt.jschool.lesson5.terminal;

import java.io.IOException;

public interface Terminal {
    void getMoney(String cardNumber, long amount) throws IOException;

    void putMoney(String cardNumber, long amount) throws IOException;

    long checkBalance(String cardNumber) throws IOException;

    boolean checkCardNumber(String cardNumber) throws IOException;

    boolean checkLock(String cardNumber) throws IOException;

    long getLockTime(String cardNumber) throws IOException;

    boolean checkPin(String cardNumber, String pin) throws IOException;

    void setBlock(String cardNumber) throws IOException;

}
