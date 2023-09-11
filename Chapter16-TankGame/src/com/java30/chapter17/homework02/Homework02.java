package com.java30.chapter17.homework02;

public class Homework02 {
    public static void main(String[] args) {
        Account account = new Account();
        Account account1 = new Account();
        account.start();
        account1.start();
    }
}
class Account extends Thread{
    private static int money = 10000;
    @Override
    public void run() {
        synchronized(this) {
            while (true) {
                if (money == 0) {
                    break;
                }
                withdraw();
                System.out.println(Thread.currentThread().getName() + " withdraw 1000, still have " + money);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }
    }
    public int withdraw(){
        money = money - 1000;
        return money;
    }
}
