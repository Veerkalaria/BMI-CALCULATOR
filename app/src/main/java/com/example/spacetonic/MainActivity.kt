package com.example.spacetonic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import java.math.BigDecimal
import java.math.RoundingMode

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        calculateBtn.setOnClickListener {
            if(heightEDTX.text.isNotEmpty() && weightEDTX.text.isNotEmpty()){
                val weight = weightEDTX.text.toString().toDouble()
                val height = heightEDTX.text.toString().toDouble()/100

            if (weight > 0 && weight < 600 && height >= 0.50 && height < 2.5) {
                val intent = Intent(this@MainActivity, ResultActivity::class.java)
                intent.putExtra("bmi", calculateBMI(weight, height))
                startActivity(intent)
            }else {
                showError("Incorrect Values")
            }
        }else {
            showError("A field is missing")
        }
    }
}  private  fun showError(errorMsg: String){
        val snack = Snackbar.make(container,"error: $errorMsg !", Snackbar.LENGTH_LONG)
        snack.view.setBackgroundResource (R.color.colorRed)
        snack.show()

}
    private fun calculateBMI(weight: Double,height: Double)=BigDecimal(weight/(height * height))
        .setScale(2,RoundingMode.HALF_EVEN).toDouble()
}