package com.starkindustries.internship_assignment_mark2.backend.dto.request

data class FilterRequest(
    val cuisine_type: List<String>,
    val min_rating: Int,
    val price_range: PriceRange
)