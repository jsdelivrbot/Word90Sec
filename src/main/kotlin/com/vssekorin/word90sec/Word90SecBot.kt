package com.vssekorin.word90sec

import org.springframework.stereotype.Component
import org.telegram.telegrambots.api.methods.send.SendMessage
import org.telegram.telegrambots.api.objects.Update
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.exceptions.TelegramApiException

@Component
class Word90SecBot : TelegramLongPollingBot() {

    override fun onUpdateReceived(update: Update) {
        if (update.hasMessage()) {
            val msg = update.message
            send(msg.chatId, "I don't do a whole lot... yet.")
        }
    }

    override fun getBotUsername(): String = "Word90Sec"

    override fun getBotToken(): String = System.getenv("BOT_TOKEN")

    private fun send(id: Long, text: String) = send(
        SendMessage(id, text).enableMarkdown(true)
    )

    private fun send(message: SendMessage) {
        try {
            execute(message)
        } catch (e: TelegramApiException) {
            e.printStackTrace()
        }
    }
}