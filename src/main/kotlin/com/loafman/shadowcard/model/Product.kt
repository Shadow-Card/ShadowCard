package com.loafman.shadowcard.model

import java.math.BigDecimal
import java.time.LocalDateTime

data class Product(
    val id: Int,
    val name: String,
    val price: BigDecimal,
    val description: String?,
    val createdAt: LocalDateTime
)
