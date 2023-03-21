package com.example.spacetonic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val bmi = intent.getDoubleExtra("bmi", -1.0)
        if (bmi == -1.0) {
            container.visibility = View.GONE
        }
        if (bmi == -1.0) {
            container.visibility = View.GONE
        } else {
            bmiValueTV.text = bmi.toString()
            if (bmi < 18.5) {
                containerR.setBackgroundResource(R.drawable.yellow_bg)
                bmiFlagImageView.setImageResource(R.drawable.exclamation_mark)
                bmiLabelTV.text = "You are UnderWeight!"
                commentTV.text = "Here is some advice to help you increase your body weight:"
                advice1IMG.setImageResource(R.drawable.nowater)
                advice1TV.text = "Don't drink water before meals"
                advice2IMG.setImageResource(R.drawable.bigmeal)
                advice2TV.text = "Eat big meals"
                advice3TV.text = "Get quality sleep"
            } else {
                if (bmi > 25) {
                    containerR.setBackgroundResource(R.drawable.red_bg)
                    bmiFlagImageView.setImageResource(R.drawable.warning)
                    bmiLabelTV.text = "You are OverWeight!"
                    commentTV.text = "Here is some advice to help you  decrease your body weight:"
                    advice1IMG.setImageResource(R.drawable.water)
                    advice1TV.text = "Drink more water to stay hydrated"
                    advice2IMG.setImageResource(R.drawable.twoeggs)
                    advice2TV.text = "Eat only two meals per day and make sure that they contain a high protein"
                    advice3IMG.setImageResource(R.drawable.nosuger)
                    advice3TV.text = "Avoid sugar"
                }
            }
        }
    }
}