package com.lswq.wang.firstpart.chapter2;

public class Bank {
    public static void main(String[] args) {
        final BankTicketWindow window = new BankTicketWindow();
        Thread window1 = new Thread(window, "一号窗口");
        Thread window2 = new Thread(window, "二号窗口");
        Thread window3 = new Thread(window, "三号窗口");
        window1.start();
        window2.start();
        window3.start();
    }
}
