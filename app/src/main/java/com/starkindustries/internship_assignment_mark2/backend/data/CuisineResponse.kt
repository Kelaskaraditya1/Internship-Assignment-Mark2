package com.starkindustries.internship_assignment_mark2.backend.data

data class CuisineResponse(
    val response_code: Int,
    val outcome_code: Int,
    val response_message: String,
    val page: Int,
    val count: Int,
    val total_pages: Int,
    val total_items: Int,
    val cuisines: List<Cuisine>
)
