package com.vssekorin.word90sec.controller

import com.vssekorin.word90sec.AccountRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/account")
class AccountController @Autowired constructor(
    val accounts: AccountRepository
) {

    @GetMapping("/")
    fun all(model: Model): String {
        model["accounts"] = accounts.findAll()
        return "accounts"
    }
}