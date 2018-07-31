package com.vssekorin.word90sec.model

import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Account(
    @Id @GeneratedValue val id: Long,
    val username: String,
    val password: String,
    val premiumEnd: LocalDate,
    val telegramId: Long
)