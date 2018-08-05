package com.vssekorin.word90sec

import com.vssekorin.word90sec.model.Account
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Message
import org.telegram.telegrambots.meta.api.objects.Update
import org.telegram.telegrambots.meta.exceptions.TelegramApiException

@Component
class Word90SecBot @Autowired constructor(
    private val accounts: AccountRepository
) : TelegramLongPollingBot() {

    override fun onUpdateReceived(update: Update) {
        if (update.hasMessage() && update.message.hasText()) {
            val msg = update.message
            val answer = when (msg.text.toLowerCase()) {
                "/start" -> start(msg)
                else -> "I don't do a whole lot... yet."
            }
            send(msg.chatId, answer)
        }
    }

    private fun start(msg: Message): String {
        val id = msg.chatId
        return accounts.findByTelegramId(id)
            ?.let { "А я Вас узнал! Мы уже встречались ранее." }
            ?: let {
                accounts.save(Account(telegramId = id))
                "Привет. Будем знакомы."
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