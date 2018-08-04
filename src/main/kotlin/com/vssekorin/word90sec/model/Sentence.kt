package com.vssekorin.word90sec.model

import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Sentence(
    @Id @GeneratedValue val id: Long = 0,
    val content: String
) {
    val date: LocalDate = LocalDate.now()
}