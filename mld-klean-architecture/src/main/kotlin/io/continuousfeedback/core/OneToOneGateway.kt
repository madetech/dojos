package io.continuousfeedback.core

import io.continuousfeedback.core.domain.OneToOne

interface OneToOneGateway {
    fun getAll(): List<OneToOne>
    fun find(id: Int): OneToOne?
    fun save(entity: OneToOne)
}
