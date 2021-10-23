package com.example.agecalculator

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button1)
        button.setOnClickListener(){view->
            printAge(view)
        }
    }
    private fun printAge(view: View){

        var myCalander = Calendar.getInstance()

        var year =myCalander.get(Calendar.YEAR)
        var month = myCalander.get(Calendar.MONTH)
        var day = myCalander.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(this,DatePickerDialog.OnDateSetListener{
                View,year,month,day->
            val selectedDate = "$day/${month+1}/$year"

            var textView1 = findViewById<TextView>(R.id.textView2)
            textView1.text =selectedDate

            var dob = Calendar.getInstance()
            dob.set(year,month,day)

            var age = myCalander.get(Calendar.YEAR) - dob.get(Calendar.YEAR)
                if(myCalander.get(Calendar.DAY_OF_YEAR)< dob.get(Calendar.DAY_OF_YEAR))
                {
                    age--
                }
            var textView3 = findViewById<TextView>(R.id.textView3)
            textView3.text ="You are $age year old."
        },year,month,day).show()
    }
}