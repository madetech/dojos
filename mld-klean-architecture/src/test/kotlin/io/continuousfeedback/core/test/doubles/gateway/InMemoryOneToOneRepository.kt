package io.continuousfeedback.core.test.doubles.gateway

import com.madetech.clean.test.doubles.InMemorySimplisticRepository
import io.continuousfeedback.core.OneToOneGateway
import io.continuousfeedback.core.domain.OneToOne

class InMemoryOneToOneRepository : OneToOneGateway, InMemorySimplisticRepository<OneToOne>()

