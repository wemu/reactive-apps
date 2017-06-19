package com.example

import com.example.repository.EventRepository1
import com.example.repository.GuestBookRepository
import com.example.repository.UserRepository
import org.springframework.stereotype.Component
import javax.annotation.PostConstruct

@Component
class DatabaseInitializer(val userRepository: UserRepository,
                          val guestBookRepository: GuestBookRepository,
                          val eventRepository: EventRepository1) {

    @PostConstruct
    fun init() {
        userRepository.initData()
        guestBookRepository.initData()
        eventRepository.initData()
    }
}