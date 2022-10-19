package br.com.aplicativoimc

enum class IMCClassificacao (val classificacao: String, val obesidade: String, val img: Int) {
    Magreza ("Magreza", "0", R.drawable._1 ),
    Normal ("Normal", "0", R.drawable._2),
    Sobrepeso ("Sobrepeso", "I", R.drawable._3),
    Obesidade ("Obesidade", "I", R.drawable._4),
    Obesidade_2 ("Obesidade_2", "II", R.drawable._5),
}