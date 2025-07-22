package com.starkindustries.internship_assignment_mark2.frontend.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.starkindustries.internship_assignment_mark2.R
import com.starkindustries.internship_assignment_mark2.backend.dto.request.FilterRequest
import com.starkindustries.internship_assignment_mark2.backend.dto.request.GetItemList
import com.starkindustries.internship_assignment_mark2.backend.dto.request.PriceRange
import com.starkindustries.internship_assignment_mark2.backend.repository.Repository
import java.util.logging.Filter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())

            var apiKey = "uonebancservceemultrS3cg8RaL30"

            // get Item Api - Call


//            var getItemList = GetItemList(
//                page = 1,
//                count = 10
//            )
//            Repository.getItemList(
//                getItemList = getItemList,
//                apiKey = "uonebancservceemultrS3cg8RaL30",
//                proxyAction = "get_item_list"
//            ) { body->
//                Log.d("RESPONSE",body.cuisines.toString())
//            }

            // get Item By Filter Api - Call

            var filterRequest = FilterRequest(
                cuisine_type = listOf("Chinese","North Indian"),
                min_rating = 4,
                price_range = PriceRange(
                    max_amount = 500,
                    min_amount = 100
                )
            )

            Repository.getItemByFilter(
                filterRequest = filterRequest,
                apiKey = apiKey,
                proxyAction = "get_item_by_filter"
            ) {
                Log.d("RESPONSE",it.toString())
            }


            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}