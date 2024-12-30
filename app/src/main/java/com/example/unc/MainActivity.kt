package com.example.unc

import android.content.res.Resources
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.ComponentActivity
import kotlin.math.pow

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout)
        val edtWeight = findViewById<EditText>(R.id.edtweightip)
        val bg=findViewById<LinearLayout>(R.id.llmain)
        val edtHeightIn = findViewById<EditText>(R.id.edtheightin)
        val edtHeightFt = findViewById<EditText>(R.id.edtheightft)
        val btnCalculate = findViewById<Button>(R.id.btncalculate)
        val txtResult = findViewById<TextView>(R.id.tvresult)

        btnCalculate.setOnClickListener {
            val wt = edtWeight.text.toString().toInt()
            val ft = edtHeightFt.text.toString().toInt()
            val `in` = edtHeightIn.text.toString().toInt()
            val totalinc = ft * 12 + `in`
            val totalcm = totalinc * 2.53
            val totalmeter = totalcm / 100
            val bmi: Double = wt / (totalmeter.pow(2.0))
            if (bmi > 25) {
                txtResult.text = "You are OVERWEITGHT"
                bg.setBackgroundColor(resources.getColor(R.color.Obg))
            } else if (bmi < 18) {
                txtResult.text = "You are UNDERWEIGHT"
                bg.setBackgroundColor(resources.getColor(R.color.Ubg))
            } else {
                txtResult.text = "You are HEALTHY"
                bg.setBackgroundColor(resources.getColor(R.color.Hbg))
            }
        }


    }
}