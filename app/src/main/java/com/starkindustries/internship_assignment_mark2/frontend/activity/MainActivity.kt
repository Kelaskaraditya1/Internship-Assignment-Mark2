package com.starkindustries.internship_assignment_mark2.frontend.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.starkindustries.internship_assignment_mark2.R
import com.starkindustries.internship_assignment_mark2.backend.dto.GetItemList
import com.starkindustries.internship_assignment_mark2.backend.instance.ApiInstance
import com.starkindustries.internship_assignment_mark2.backend.repository.Repository

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())

            // get Item Api - Call
            var getItemList = GetItemList(
                page = 1,
                count = 10
            )
            Repository.getItemList(
                getItemList = getItemList,
                apiKey = "uonebancservceemultrS3cg8RaL30",
                proxyAction = "get_item_list"
            ) { body->
                Log.d("RESPONSE",body.cuisines.toString())
            }


            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}