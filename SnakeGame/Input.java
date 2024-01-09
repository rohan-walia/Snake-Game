package SnakeGamePractice;

import java.util.Scanner;

public class Input implements Runnable {
    Character ch;
    Scanner scanner;

    public Input(Character ch) {
        this.ch = ch;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            this.ch = scanner.next().charAt(0);
            System.out.println("Inside second thread: " + ch);
        }
    }

    public Character getCh() {
        return ch;
    }

    public void setCh(Character ch) {
        this.ch = ch;
    }
}
