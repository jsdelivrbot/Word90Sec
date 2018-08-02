package com.vssekorin.word90sec.model

import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Sentence(
    @Id @GeneratedValue var id: Long,
    val content: String,
    val date: LocalDate
)