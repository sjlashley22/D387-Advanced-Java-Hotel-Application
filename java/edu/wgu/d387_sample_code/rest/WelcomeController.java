package edu.wgu.d387_sample_code.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicReference;

@RestController
public class WelcomeController {

    @GetMapping("/api/welcome")
    public WelcomeResponse getWelcome() {
        AtomicReference<String> en = new AtomicReference<>("");
        AtomicReference<String> fr = new AtomicReference<>("");

        Thread t1 = new Thread(() -> {
            ResourceBundle rb = ResourceBundle.getBundle("translation", new Locale("en", "US"));
            en.set(rb.getString("welcome") + " " + Thread.currentThread().getName());
        });

        Thread t2 = new Thread(() -> {
            ResourceBundle rb = ResourceBundle.getBundle("translation", new Locale("fr", "CA"));
            fr.set(rb.getString("welcome") + " " + Thread.currentThread().getName());
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        return new WelcomeResponse(fr.get(), en.get());
    }

    public record WelcomeResponse(String fr, String en) {}
}