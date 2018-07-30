package com.vssekorin.word90sec

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.telegram.telegrambots.ApiContextInitializer
import org.telegram.telegrambots.TelegramBotsApi
import org.telegram.telegrambots.exceptions.TelegramApiException
import javax.annotation.PostConstruct

@SpringBootApplication
class Word90SecApplication @Autowired
constructor(private val bot: Word90SecBot) {

    @PostConstruct
    fun init() {
        val botsApi = TelegramBotsApi()
        try {
            botsApi.registerBot(bot)
        } catch (e: TelegramApiException) {
            e.printStackTrace()
        }

    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            ApiContextInitializer.init()
            SpringApplication.run(Word90SecApplication::class.java, *args)
        }
    }
}
