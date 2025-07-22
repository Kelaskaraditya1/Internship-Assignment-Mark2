package com.starkindustries.internship_assignment_mark2.backend.dto.response

import com.starkindustries.internship_assignment_mark2.backend.data.Cuisine
import com.starkindustries.internship_assignment_mark2.backend.data.Dish

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

data class ItemDetailsResponse(
    val response_code: Int,
    val outcome_code: Int,
    val response_message: String,
    val cuisine_id: String,
    val cuisine_name: String,
    val cuisine_image_url: String,
    val item_id: Int,
    val item_name: String,
    val item_price: Int,
    val item_rating: Double,
    val item_image_url: String,
    val timestamp: String,
    val requester_ip: String,
    val timetaken: String
)

