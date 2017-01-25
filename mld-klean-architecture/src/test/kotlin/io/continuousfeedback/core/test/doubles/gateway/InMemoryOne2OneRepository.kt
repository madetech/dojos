package io.continuousfeedback.core.test.doubles.gateway

import com.madetech.clean.test.doubles.InMemorySimplisticRepository
import io.continuousfeedback.core.One2OneGateway
import io.continuousfeedback.core.domain.One2One

class InMemoryOne2OneRepository : One2OneGateway, InMemorySimplisticRepository<One2One>()

