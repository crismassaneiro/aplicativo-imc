package br.com.aplicativoimc

import kotlin.math.pow

class IMC(var altura: Double, var peso: Double) {

    var resultado: Double = 0.00
    var classificacao: String = ""
    var obesidade: String = ""
    var img: Int = 0

    init {
        this.calcular()
        this.setClasificacaoObesidade()
    }

    fun calcular() {
        this.resultado = peso / altura.pow(2.0)
    }

    fun setClasificacaoObesidade() {

        if (resultado < 18.5) {

            classificacao = IMCClassificacao.Magreza.classificacao
            obesidade = IMCClassificacao.Magreza.obesidade
            img = IMCClassificacao.Magreza.img

        } else if (resultado > 18.5 && resultado <= 24.9) {

            classificacao = IMCClassificacao.Normal.classificacao
            obesidade = IMCClassificacao.Normal.obesidade
            img = IMCClassificacao.Normal.img

        } else if (resultado > 24.9 && resultado <= 29.9) {

            classificacao = IMCClassificacao.Sobrepeso.classificacao
            obesidade = IMCClassificacao.Sobrepeso.obesidade
            img = IMCClassificacao.Sobrepeso.img

        } else if (resultado > 29.9 && resultado <= 34.9) {

            classificacao = IMCClassificacao.Obesidade.classificacao
            obesidade = IMCClassificacao.Obesidade.obesidade
            img = IMCClassificacao.Obesidade.img

        } else {

            classificacao = IMCClassificacao.Obesidade_2.classificacao
            obesidade = IMCClassificacao.Obesidade_2.obesidade
            img = IMCClassificacao.Obesidade_2.img
        }
    }
}