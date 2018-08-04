package com.vssekorin.word90sec

import com.vssekorin.word90sec.model.Account
import com.vssekorin.word90sec.model.Sentence
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface AccountRepository : CrudRepository<Account, Long> {
    fun findByTelegramId(telegramId: Long): Account
}

@Repository
interface SentenceRepository : CrudRepository<Sentence, Long>
