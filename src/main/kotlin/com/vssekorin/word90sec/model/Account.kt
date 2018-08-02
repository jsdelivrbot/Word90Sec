package com.vssekorin.word90sec.model

import java.time.LocalDate
import javax.persistence.*

@Entity
class Account(
    @Id @GeneratedValue val id: Long,
    val username: String,
    val password: String,
    val premiumEnd: LocalDate,
    val telegramId: Long,
    @OneToMany(fetch = FetchType.EAGER, cascade = [CascadeType.ALL], orphanRemoval = true)
    val sentences: List<Sentence>
)