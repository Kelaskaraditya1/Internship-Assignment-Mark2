package com.starkindustries.internship_assignment_mark2.backend.repository

import android.util.Log
import com.starkindustries.internship_assignment_mark2.backend.api.ItemApi
import com.starkindustries.internship_assignment_mark2.backend.data.Cuisine
import com.starkindustries.internship_assignment_mark2.backend.data.CuisineResponse
import com.starkindustries.internship_assignment_mark2.backend.dto.request.FilterRequest
import com.starkindustries.internship_assignment_mark2.backend.dto.request.GetItemList
import com.starkindustries.internship_assignment_mark2.backend.instance.ApiInstance
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

open class Repository{

    companion object{

        fun getItemList(getItemList: GetItemList,apiKey:String,proxyAction:String,result:(CuisineResponse)->Unit){

            CoroutineScope(Dispatchers.IO).launch {

                try{
                    var response  = ApiInstance.api.getItemList(
                        request = getItemList,
                        apiKey=apiKey,
                        proxyAction = proxyAction
                    )

                    if(response.isSuccessful){
                        response.body()?.let { body ->
                            result(body)
                        }

                        Log.d("RESPONSE_SUCCESS","Response Successful")
                    }else
                        Log.d("RESPONSE_ERROR",response.errorBody().toString())
                }catch (e: Exception){
                    e.printStackTrace()
                    Log.d("EXCEPTION", e.localizedMessage.toString())
                }


            }

        }

        fun getItemByFilter(filterRequest: FilterRequest,apiKey:String,proxyAction:String,result:(List<Cuisine>)->Unit){

            CoroutineScope(Dispatchers.IO).launch {

                try{
                    var response = ApiInstance.api.getItemByFilter(
                        apiKey = apiKey,
                        proxyAction = proxyAction,
                        filterRequest= filterRequest
                    )

                    if(response.isSuccessful){
                        result(response.body()?.cuisines!!)
                        Log.d("RESPONSE_SUCCESS","Response Successful")
                    }else
                        Log.d("RESPONSE_ERROR",response.errorBody().toString())
                }catch (e: Exception){
                    e.printStackTrace()
                    Log.d("EXCEPTION", e.localizedMessage.toString())
                }
            }

        }

    }


}