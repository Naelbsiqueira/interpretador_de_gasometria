package com.example.gasometria

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.gasometria.databinding.ActivityCalculandoBinding
import com.example.gasometria.logica.Gasometria

class CalculandoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCalculandoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculandoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Handler(Looper.getMainLooper()).postDelayed({
            val i = Intent(this,ResultadoActivity::class.java)
            startActivity(i)
            finish()
        },5000)

    }
}