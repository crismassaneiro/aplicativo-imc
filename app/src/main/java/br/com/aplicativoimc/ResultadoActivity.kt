package br.com.aplicativoimc

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultadoActivity : AppCompatActivity() {

    companion object {
        const val IMC_Resultado = "imc"
        const val IMC_Classificacao = "classificacao"
        const val IMC_Obesidade = "obesidade"
        const val IMC_Img = "img"
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)


        val resultado = intent.getDoubleExtra(IMC_Resultado, -1.0)
        val classificacao = intent.getStringExtra(IMC_Classificacao)
        val obesidade = intent.getStringExtra(IMC_Obesidade)
        val img = intent.getIntExtra(IMC_Img, -1)

        val txtResultado = findViewById<TextView>(R.id.txtResultado)
        val imgResultado = findViewById<ImageView>(R.id.imgResultado)

        txtResultado.text =
            "IMC: ${"%.2f".format(resultado)} \nClassificação $classificacao \nGrau de Obesidade: $obesidade"
        imgResultado.contentDescription = classificacao
        imgResultado.setImageResource(img)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return false
        }
        return super.onOptionsItemSelected(item)
    }
}