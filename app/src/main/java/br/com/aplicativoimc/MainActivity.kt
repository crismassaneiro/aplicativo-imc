package br.com.aplicativoimc

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private var txtAltura: TextView? = null
    private var txtPeso: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val btnLimpar = findViewById<Button>(R.id.btnLimpar)

        btnCalcular.setOnClickListener {
            val altura = txtAltura?.text.toString()
            val peso = txtPeso?.text.toString()


            // Verificar se os campos não estão vazios.
            if (altura.isEmpty() || peso.isEmpty()) {
                Toast.makeText(this, "Preencha os campos", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }

            val imc = IMC(altura.toDouble(), peso.toDouble())

            val intent = Intent(this, ResultadoActivity::class.java)
            intent.putExtra(ResultadoActivity.IMC_Resultado, imc.resultado)
            intent.putExtra(ResultadoActivity.IMC_Classificacao, imc.classificacao)
            intent.putExtra(ResultadoActivity.IMC_Obesidade, imc.obesidade)
            intent.putExtra(ResultadoActivity.IMC_Img, imc.img)
            startActivity(intent)
        }

        btnLimpar.setOnClickListener {
            txtAltura?.text = ""
            txtPeso?.text = ""
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putCharSequence("Altura", this.txtAltura?.text)
        outState.putCharSequence("Peso", this.txtPeso?.text)
    }


    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        this.txtAltura?.text = savedInstanceState.getCharSequence("Altura")
        this.txtPeso?.text = savedInstanceState.getCharSequence("Peso")
    }
}