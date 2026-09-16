package edu.wgu.d387_sample_code;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.ResourceBundle;

@Component
public class WelcomeMessageRunner implements CommandLineRunner {

    @Override
    public void run(String... args) {
        Thread enThread = new Thread(() -> printWelcome(new Locale("en", "US")), "welcome-en_US");
        Thread frThread = new Thread(() -> printWelcome(new Locale("fr", "CA")), "welcome-fr_CA");

        enThread.start();
        frThread.start();

        try {
            enThread.join();
            frThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void printWelcome(Locale locale) {
        ResourceBundle rb = ResourceBundle.getBundle("translation", locale);
        System.out.println("[" + Thread.currentThread().getName() + "] " + rb.getString("welcome"));
    }
}