package com.sbt.jschool.lesson5.terminal;

import java.io.IOException;
import java.util.Scanner;

public class PinValidator {
    private final TerminalUI terminalUI;

    PinValidator(TerminalUI terminalUI) {
        this.terminalUI = terminalUI;
    }

    public boolean enterPinValid(String cardNumber) throws IOException {
        Scanner sc = new Scanner(System.in);
        int error = 0;
        String pin;
        try {
            while (true) {
                System.out.println("Введите пин-код");
                System.out.println("Для выхода введите q");
                long startTime = System.currentTimeMillis();
                pin = sc.next();

                if (pin.equals("q")) break;
                if (terminalUI.terminal.checkLock(cardNumber)){
                    throw new AccountIsLockedException((int) (30000 - (System.currentTimeMillis()
                            - terminalUI.terminal.getLockTime(cardNumber)))/1000);
                }
                else if (System.currentTimeMillis() - startTime > 5000) {
                    error++;
                    System.out.println("Cлишком долгий ввод пин-кода. Повторите ввод");
                } else if (pin.length() != 4) {
                    error++;
                    System.out.println("Пин-код состоит из 4х цифр. Вы ввели " + pin.length());
                } else if (!terminalUI.terminal.checkPin(cardNumber, pin)) {
                    error++;
                    System.out.println("Пин-код введен неверно. Повторите ввод");
                }

                else if (terminalUI.terminal.checkPin(cardNumber, pin)) return true;

                if (error == 3) {
                    terminalUI.terminal.setBlock(cardNumber);
                    throw new AccountIsLockedException((int) (30000 - (System.currentTimeMillis()
                            - terminalUI.terminal.getLockTime(cardNumber)))/1000);
                }

                System.out.println("Осталось попыток: " + (3 - error));
            }
        } catch (AccountIsLockedException e){
            System.err.println("Аккаунт заблокирован. До разблокировки осталось секунд: " + e.getMessage());
        }

        return false;

    }
}
