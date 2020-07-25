package com.mhst.custom_view_assignment.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mhst.custom_view_assignment.R

class CreateTaskActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_task)
    }

    companion object{
        fun onNewIntent(context: Context) : Intent{
            return Intent(context,
                CreateTaskActivity::class.java)
        }

    }

}