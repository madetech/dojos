package io.continuousfeedback.core.domain

import com.madetech.clean.domain.OptionallyIdentified

class OneToOne(id: Int?, val teamMemberId: Int, val date : String) : OptionallyIdentified(id)