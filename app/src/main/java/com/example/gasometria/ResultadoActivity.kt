package com.example.gasometria

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.example.gasometria.databinding.ActivityResultadoBinding
import com.example.gasometria.logica.Gasometria

class ResultadoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultadoBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultadoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val i = intent
        val ph = i.extras?.getDouble("ph")
        val k = i.extras?.getDouble("k")
        val po2 = i.extras?.getInt("p")
        val pco2 = i.extras?.getDouble("pco2")
        val hco3 = i.extras?.getDouble("hco3")

        val gasometria = Gasometria(ph!!, k!!, hco3!!, po2!!,pco2!!)
        gasometria.situacaoPaciente();

        binding.resultadoCalculado.setText(gasometria.situacaoPaciente())


    }
}

