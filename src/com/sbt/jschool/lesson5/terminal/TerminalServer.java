package com.sbt.jschool.lesson5.terminal;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TerminalServer implements Terminal {
    private final Map<String, Long> cards = new HashMap<>();
    private final Map<String, String> cardPin = new HashMap<>();
    private final Map<String, Long> cardLock = new HashMap<>();

    public TerminalServer() {
        cards.put("1111 1111 1111 1111", 100000L);
        cards.put("2222 2222 2222 2222", 100000L);
        cards.put("3333 3333 3333 3333", 100000L);
        cards.put("4444 4444 4444 4444", 100000L);
        cardPin.put("1111 1111 1111 1111", "1111");
        cardPin.put("2222 2222 2222 2222", "2222");
        cardPin.put("3333 3333 3333 3333", "3333");
        cardPin.put("4444 4444 4444 4444", "4444");
        cardLock.put("1111 1111 1111 1111", 0L);
        cardLock.put("2222 2222 2222 2222", 0L);
        cardLock.put("3333 3333 3333 3333", 0L);
        cardLock.put("4444 4444 4444 4444", 0L);
    }


    @Override
    public void getMoney(String cardNumber, long amount) throws IOException {
        ConnectionErrorSimulator();
        if (cards.get(cardNumber) - amount >= 0) {
            cards.put(cardNumber, cards.get(cardNumber) - amount);
        } else throw new InsufficientFundsExceptions("Недостаточно средств для выполнения данной операции");
    }

    @Override
    public void putMoney(String cardNumber, long amount) throws IOException {
        ConnectionErrorSimulator();
        cards.put(cardNumber, cards.get(cardNumber) + amount);
    }

    @Override
    public long checkBalance(String cardNumber) throws IOException {
        ConnectionErrorSimulator();
        return cards.get(cardNumber);
    }

    @Override
    public boolean checkCardNumber(String cardNumber) throws IOException {
        ConnectionErrorSimulator();
        return cards.containsKey(cardNumber);
    }

    @Override
    public boolean checkLock(String cardNumber) throws IOException {
        ConnectionErrorSimulator();
        return System.currentTimeMillis() - cardLock.get(cardNumber) < 30000;
    }

    @Override
    public long getLockTime(String cardNumber) throws IOException {
        ConnectionErrorSimulator();
        return cardLock.get(cardNumber);
    }

    @Override
    public boolean checkPin(String cardNumber, String pin) throws IOException {
        ConnectionErrorSimulator();
        return cardPin.get(cardNumber).equals(pin);
    }

    public void setBlock(String cardNumber) throws IOException {
        ConnectionErrorSimulator();
        cardLock.put(cardNumber, System.currentTimeMillis());
        System.err.println("Карта номер " + cardNumber + " заблокирована!");
    }

    /**
     * Метод симулирует проблемы со связью
     * С вероятностью 2% бросает IOException
     */
    private void ConnectionErrorSimulator() throws IOException {
        final Random rnd = new Random();
        if (rnd.nextInt(50) == 1) throw new IOException("Возникли проблемы с сетью. Сессия аварийно завершена.");
    }
}
