package com.starkindustries.internship_assignment_mark2.backend.dto.request

import com.google.gson.annotations.SerializedName

data class GetItemList(
    val page:Int,
    val count:Int
)

data class CartItem(
    val cuisine_id: Int,
    val item_id: Int,
    @SerializedName("item price") val item_price: Int,
    val item_quantity: Int
)

data class CartSummary(
    val total_amount: String,
    val total_items: Int,
    val data: List<CartItem>
)

data class FilterRequest(
    val cuisine_type: List<String>,
    val min_rating: Int,
    val price_range: PriceRange
)

data class PriceRange(
    val max_amount: Int,
    val min_amount: Int
)
