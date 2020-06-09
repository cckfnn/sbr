package com.sbt.jschool.lesson5.terminal;

import java.io.IOException;

public class TerminalImpl implements Terminal {

    private final TerminalServer server;
    private final PinValidator pinValidator;

    public TerminalImpl(TerminalServer server, PinValidator pinValidator) {
        this.server = server;
        this.pinValidator = pinValidator;
    }

    @Override
    public void getMoney(String cardNumber, long amount) throws IOException {
        server.getMoney(cardNumber, amount);
    }

    @Override
    public void putMoney(String cardNumber, long amount) throws IOException {
        server.putMoney(cardNumber, amount);
    }

    @Override
    public long checkBalance(String cardNumber) throws IOException {
        return server.checkBalance(cardNumber);
    }

    @Override
    public boolean checkCardNumber(String cardNumber) throws IOException {
        return server.checkCardNumber(cardNumber);
    }

    @Override
    public boolean checkLock(String cardNumber) throws IOException {
        return server.checkLock(cardNumber);
    }

    @Override
    public long getLockTime(String cardNumber) throws IOException {
        return server.getLockTime(cardNumber);
    }

    @Override
    public boolean checkPin(String cardNumber, String pin) throws IOException {
        return server.checkPin(cardNumber, pin);
    }

    @Override
    public void setBlock(String cardNumber) throws IOException {
        server.setBlock(cardNumber);
    }

    public boolean enterPinValid(String cardNumber) throws IOException {
        return pinValidator.enterPinValid(cardNumber);
    }
}

