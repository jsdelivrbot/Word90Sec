package com.vssekorin.word90sec.bot;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

@Component
public class Word90SecBot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            final Message msg = update.getMessage();
            send(msg.getChatId(), "I don't do a whole lot... yet.");
        }
    }

    @Override
    public String getBotUsername() {
        return "Word90Sec";
    }

    @Override
    public String getBotToken() {
        return System.getenv("BOT_TOKEN");
    }

    private void send(Long id, String text) {
        send(new SendMessage(id, text).enableMarkdown(true));
    }

    private void send(SendMessage message) {
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
