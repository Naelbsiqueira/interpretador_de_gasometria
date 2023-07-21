package com.example.gasometria

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Switch
import android.widget.Toast
import com.example.gasometria.databinding.ActivityEnterDatasBinding
import java.util.Locale.filter

class EnterDatasActivity : AppCompatActivity() {
    private lateinit var binding:ActivityEnterDatasBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityEnterDatasBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.iditCalcular.setOnClickListener {
            with(binding) {
                val ph = binding.inputPh.text.toString().trim()
                val k = binding.inputPotassio.text.toString().trim()
                val po2 = binding.inputOxigenio.text.toString().trim()
                val pco2 = binding.inputGascarbonico.text.toString().trim()
                val hc3 = binding.inputBicarbonato.text.toString().trim()

                when {
                    ph.isEmpty()  -> {
                        inputPh.requestFocus()
                        inputPh.error = "Campo Obrigatório"
                    }
                    ph.toDouble() < 6.00 || ph.toDouble() > 8.00 -> {
                        inputPh.requestFocus()
                        inputPh.error = "Preencha o campo com valor maior 6 ou menor que 8"
                    }

                    k.isEmpty() -> {
                        inputPotassio.requestFocus()
                        inputPotassio.error = "Campo Obrigatório"
                    }
                    k.toDouble() < 1.00 || k.toDouble()> 14.00 -> {
                        inputPotassio.requestFocus()
                        inputPotassio.error = "Preencha o campo com valor maior 1 ou menor que 14"
                    }

                    po2.isEmpty() -> {
                        inputOxigenio.requestFocus()
                        inputOxigenio.error = "Campo Obrigatório"
                    }
                    po2.toInt() < 10 -> {
                        inputOxigenio.requestFocus()
                        inputOxigenio.error = "Preencha o campo com valor maior que 10"
                    }

                    pco2.isEmpty() -> {
                        inputGascarbonico.requestFocus()
                        inputGascarbonico.error = "Campo Obrigatório"

                    }
                    pco2.toDouble() < 10 || pco2.toDouble() > 60 -> {
                        inputGascarbonico.requestFocus()
                        inputGascarbonico.error = "Campo Obrigatório"

                    }

                    hc3.isEmpty() -> {
                        inputBicarbonato.requestFocus()
                        inputBicarbonato.error = "Campo Obrigatório"
                    }
                    hc3.toDouble() < 5 || hc3.toDouble() > 50 -> {
                        inputBicarbonato.requestFocus()
                        inputBicarbonato.error = "Preencha o campo com valor maior que 5 ou menor que 50"
                    }

                    else -> {
                        screemData()
                    }
                }
            }
        }
    }
    private fun screemData(){
        binding.iditCalcular.isEnabled = false
        binding.iditCalcular.setTextColor(Color.parseColor("#57FFF7"))
        val d = Intent(this,ResultadoActivity::class.java)
        val i = Intent(this,ResultadoActivity::class.java)


        val ph = binding.inputPh.text.toString().trim().toDouble()
        val k = binding.inputPotassio.text.toString().trim().toDouble()
        val po2 = binding.inputOxigenio.text.toString().trim().toInt()
        val pco2 = binding.inputGascarbonico.text.toString().trim().toDouble()
        val hc3 = binding.inputBicarbonato.text.toString().trim().toDouble()
        i.putExtra("ph", ph)
        i.putExtra("k", k)
        i.putExtra("o2", po2)
        i.putExtra("pco2", pco2)
        i.putExtra("hco3", hc3)
        binding.iditCalcular.isEnabled = true

        startActivity(d)
        startActivity(i)

        finish()

    }

}