package com.learning.spring_boot_learning.controllers

import com.learning.spring_boot_learning.database.model.Note
import com.learning.spring_boot_learning.database.repository.NoteRepository
import io.jsonwebtoken.lang.Objects
import org.bson.types.ObjectId
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.Instant

@RestController
@RequestMapping("/notes")
class NoteController(
    private val repository: NoteRepository
) {

    data class NoteRequest(
        val id: String?,
        val title: String,
        val content: String,
        val color: Long,
        val ownerId: String,
    )

    data class NoteResponse(
        val id: String?,
        val title: String,
        val content: String,
        val color: Long,
        val createdAt: Instant,
    )

    @PostMapping
    fun save(body: NoteRequest): NoteResponse{
        val note = repository.save(
                Note(
                    id = body.id?.let{ ObjectId(it)}?:ObjectId.get(),
                    title = body.title,
                    content = body.content,
                    color = body.color,
                    createdAt = Instant.now(),
                    ownerId = ObjectId(body.ownerId)
                )
            )

        return NoteResponse(
            id = note.id.toHexString(),
            title = note.title,
            content = note.content,
            color = note.color,
            createdAt = note.createdAt,
        )
    }



}