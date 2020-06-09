package com.sbt.jschool.lesson5.terminal;

public class AccountIsLockedException extends IllegalStateException {
    public AccountIsLockedException(int sec) {
        super(String.valueOf(sec));
    }
}