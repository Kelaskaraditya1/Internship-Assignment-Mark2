package com.starkindustries.internship_assignment_mark2.backend.api

import com.starkindustries.internship_assignment_mark2.backend.data.CuisineResponse
import com.starkindustries.internship_assignment_mark2.backend.dto.GetItemList
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.HEAD
import retrofit2.http.Header
import retrofit2.http.POST

interface ItemApi {

    @POST("/emulator/interview/get_item_list")
    suspend fun getItemList(@Body request: GetItemList
                            ,@Header("X-Partner-API-Key") apiKey:String
                            ,@Header("X-Forward-Proxy-Action") proxyAction:String): Response<CuisineResponse>

}