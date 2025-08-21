package com.learning.spring_boot_learning.controllers

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.Instant

@RestController
@RequestMapping("/notes")
class NoteController {

    data class NoteRequest(
        val id: String?,
        val title: String,
        val content: String,
        val color: Long,
    )

    data class NoteResponse(
        val id: String?,
        val title: String,
        val content: String,
        val color: Long,
        val createdAt: Instant,
    )

    fun save(body: NoteRequest){

    }

}