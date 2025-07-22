package com.starkindustries.internship_assignment_mark2.backend.dto.response

import com.starkindustries.internship_assignment_mark2.backend.data.Cuisine

data class ItemByFilterResponse(
    val cuisines: List<Cuisine>,
    val outcome_code: Int,
    val requester_ip: String,
    val response_code: Int,
    val response_message: String,
    val timestamp: String,
    val timetaken: String
)

data class OrderResponse(
    val response_code: Int,
    val outcome_code: Int,
    val response_message: String,
    val txn_ref_no: String
)
