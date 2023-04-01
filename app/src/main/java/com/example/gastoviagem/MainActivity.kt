package com.example.gastoviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.gastoviagem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCalculate.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        if (view.id == R.id.button_calculate) {
            calculate()
        }
    }

    private fun isValid(): Boolean {
        return (binding.editDistance.text.toString() != "" &&
                binding.editLiter.text.toString() != "" &&
                binding.editPrice.text.toString() != "" &&
                binding.editLiter.text.toString().toFloat() != 0f)
    }


    private fun calculate() {
        if (isValid()){
            val distance = binding.editDistance.text.toString().toFloat()
            val liter = binding.editLiter.text.toString().toFloat()
            val price = binding.editPrice.text.toString().toFloat()
            val totalValue = distance * price / liter
            binding.textResult.text = "R$ ${"%.2f".format(totalValue)}"
        }else{
            Toast.makeText(this,R.string.wrong_data,Toast.LENGTH_SHORT).show()
        }
    }


}

