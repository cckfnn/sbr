package com.sbt.jschool.lesson5.terminal;


import java.io.IOException;
import java.util.Scanner;

public class TerminalUI {
    TerminalImpl terminal = new TerminalImpl(new TerminalServer(), new PinValidator(this));
    Scanner sc = new Scanner(System.in);

    public void start() {
        while (true) {
            try {
                String cardNumber = cardMenu();
                if (cardNumber.equals("q")) break;
                if (!cardNumber.equals("bad")) {
                    terminalMenu(cardNumber);
                }
            } catch (IOException e) {
                System.out.println("----------" + e.getMessage() + "----------");
            }
        }
        System.out.println("\nДо свидания!");
    }


    private String cardMenu() throws IOException {
        System.out.println("\nВведите номер карты в формате XXXX XXXX XXXX XXXX:");
        System.out.println("Для завершения работы введите q");
        String cardNumber = sc.nextLine();
        int error = 0;
        if (cardNumber.equals("q")) {
            return cardNumber;
        }

        if (!terminal.checkCardNumber(cardNumber)) {
            System.err.println("\nНеверно введен номер карты");
            return "bad";
        }

        if (terminal.enterPinValid(cardNumber)) {
            terminalMenu(cardNumber);
        }

        return "bad";
    }

    private void terminalMenu(String cardNumber) {
        while (true) {
            System.out.print("\nВыбор операции:\n" +
                    "1. Проверить баланс карты\n" +
                    "2. Снять наличные\n" +
                    "3. Внести наличные\n" +
                    "4. Завершить работу\n" +
                    "Введите номер требуемой операции [1-4]: ");

            String operation = sc.next();
            try {
                switch (operation) {
                    case ("1"):
                        if (terminal.enterPinValid(cardNumber)) getBalance(cardNumber);
                        break;
                    case ("2"):
                        if (terminal.enterPinValid(cardNumber)) getMoney(cardNumber);
                        break;
                    case ("3"):
                        if (terminal.enterPinValid(cardNumber)) putMoney(cardNumber);
                        break;
                    case ("4"):
                        return;
                    default:
                        throw new IOException("Некорректный ввод. Введите номер требуемой операции [1-4]:");
                }
            } catch (IOException e) {
                System.err.println("----------" + e.getMessage() + "----------");
            }
        }
    }

    private void getBalance(String cardNumber) throws IOException {
        System.out.println("\nБаланс карты: " + terminal.checkBalance(cardNumber));
    }

    private void getMoney(String cardNumber) throws IOException {
        System.out.println("\nСнятие наличных");
        System.out.println("Введите сумму кратную 100: ");
        int amount = sc.nextInt();
        if (amount % 100 != 0)
            throw new IllegalArgumentException("Сумма должна быть кратна 100. Операция не выполнена.");
        terminal.getMoney(cardNumber, amount);
        System.out.println("Операция выполнена успешно, заберите деньги.");
        System.out.println("Баланс карты: " + terminal.checkBalance(cardNumber));
    }

    private void putMoney(String cardNumber) throws IOException {
        System.out.println("\nВнесение наличных");
        System.out.println("Введите сумму кратную 100: ");
        int amount = sc.nextInt();
        if (amount % 100 != 0)
            throw new IllegalArgumentException("Сумма должна быть кратна 100. Операция не выполнена.");
        terminal.putMoney(cardNumber, amount);
        System.out.println("Операция выполнена успешно, деньги зачислены.");
        System.out.println("Баланс карты: " + terminal.checkBalance(cardNumber));
    }
}

