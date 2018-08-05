package com.vssekorin.word90sec.model

import java.time.LocalDate
import javax.persistence.*

@Entity
data class Account(
    val username: String,
    val password: String,
    val telegramId: Long
) {

    @Id @GeneratedValue val id: Long = 0
    val premiumEnd: LocalDate = LocalDate.now().minusDays(1)

    @OneToMany(fetch = FetchType.EAGER, cascade = [CascadeType.ALL], orphanRemoval = true)
    val sentences: List<Sentence> = ArrayList<Sentence>()

    constructor(telegramId: Long): this(
        username = telegramId.toString(),
        telegramId = telegramId
    )

    constructor(username: String, telegramId: Long): this(
        username = username,
        password = username,
        telegramId = telegramId
    )
}