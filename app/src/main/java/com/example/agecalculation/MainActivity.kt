package com.example.agecalculation

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn_click_me = findViewById(R.id.buttonDate) as Button
        var ageInMinutes = 0;

        btn_click_me.setOnClickListener { view ->
            clickDatePicker(view)
            Toast.makeText(this, "You clicked me.", Toast.LENGTH_LONG).show()
        }

    }

    @SuppressLint("SetTextI18n")
    fun clickDatePicker(view: View) {
        val myCalender = Calendar.getInstance()
        val year = myCalender.get(Calendar.YEAR)
        val month = myCalender.get(Calendar.MONTH)
        val day = myCalender.get(Calendar.DAY_OF_MONTH)


//        val datePickerDialog = DatePickerDialog(this,
//                { view, year, monthOfYear, dayOfMonth -> }, year, month, day)
//        datePickerDialog.show()


        DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
//            Toast.makeText(this, "The year is $year and the month is ${month + 1} and the day is $dayOfMonth", Toast.LENGTH_LONG).show()
            val selectedDate = findViewById(R.id.textView7) as TextView
            selectedDate.setText("$dayOfMonth/${month + 1}/$year");
            calculateAge()
        }, year, month, day).show()

//        return (year-pickedYear)*(365.2425)*()
    }

    fun calculateAge() {
        var today = Date()
        var chosenDate = findViewById(R.id.textView7) as TextView
        var sdf = SimpleDateFormat("dd/MM/yyyy")
        var dob = sdf.parse(chosenDate.text as String)


        var days = (today.time - dob.time) / 86_400_000
//        var hours=(today.time-dob.time)%86_400_000/3600000
//        var minutes=(today.time-dob.time)%86_400_000%3600000/60000
        var ageInMinute = findViewById(R.id.textView8) as TextView
        ageInMinute.setText("You live in this world $days days and ${days * 24 * 60} minutes");
    }

}