package com.starkindustries.internship_assignment_mark2.backend.api

import com.starkindustries.internship_assignment_mark2.backend.data.Cuisine
import com.starkindustries.internship_assignment_mark2.backend.data.CuisineResponse
import com.starkindustries.internship_assignment_mark2.backend.dto.request.FilterRequest
import com.starkindustries.internship_assignment_mark2.backend.dto.request.GetItemList
import com.starkindustries.internship_assignment_mark2.backend.dto.response.ItemByFilterResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface ItemApi {

    @POST("/emulator/interview/get_item_list")
    suspend fun getItemList(@Body request: GetItemList
                            ,@Header("X-Partner-API-Key") apiKey:String
                            ,@Header("X-Forward-Proxy-Action") proxyAction:String): Response<CuisineResponse>


    @POST("/emulator/interview/get_item_by_filter")
    suspend fun getItemByFilter(@Header("X-Partner-API-Key") apiKey:String,
                                @Header("X-Forward-Proxy-Action") proxyAction:String,
                                @Body filterRequest: FilterRequest): Response<ItemByFilterResponse>


}