package com.vssekorin.word90sec;

import com.vssekorin.word90sec.bot.Word90SecBot;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;

@SpringBootApplication
public class Word90SecApplication {

    private final Word90SecBot bot;

    @Autowired
    public Word90SecApplication(Word90SecBot bot) {
        this.bot = bot;
    }

    public static void main(String[] args) {
        ApiContextInitializer.init();
        SpringApplication.run(Word90SecApplication.class, args);
    }

    @PostConstruct
    public void init() {
        final TelegramBotsApi botsApi = new TelegramBotsApi();
        try {
            botsApi.registerBot(bot);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
