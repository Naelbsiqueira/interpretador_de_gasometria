package com.example.gasometria.logica

class Gasometria(private var percentilHidrogenio: Double,
                 private var potassio: Double,
                 private var bicarbonato: Double,
                 private var oxigenio: Int,
                 private var gasCarbonico: Double) :




    PercentilHidrogenio(percentilHidrogenio, bicarbonato, gasCarbonico) {

    fun situacaoPaciente(): String {
        return """O paciente apresenta ${percentilHidrogenio} de PH;
            Um potássio de ${potassio} mEql/L ${situacaoPotassio(potassio)}
            Bicarbonato de ${bicarbonato} mmol/L ${getOxigenio()} % de oxigênio circulante no organismo.
            Apresentando ${gasCarbonico} PCO² Seu estado Fisiológico : 
            ${resultado}""" }

    fun situacaoPotassio(valor: Double): String {
        val resultado: String
        resultado = if (valor > 3.5 && valor <= 5.1) {
            "Potássio dentro da faixa de normalidade"
        } else if (valor <= 3.5) {
            "Corrija o potássio, está baixo."
        } else if (valor > 5.1) {
            "Potássio acima do valor de referência"
        } else if (valor >= 7) {
            "Atenção !!! Potássio muito alterado. Corrija com urgência."
        } else if (valor < 10) {
            "Atenção !!! Potássio extremamente alterado, paciente em risco de choque"
        } else {
            "Erro na leitura do potássio"
        }
        return resultado
    }

    fun getOxigenio(): Double {
        return oxigenio.toDouble()
    }

    fun setOxigenio(oxigenio: Int) {
        this.oxigenio = oxigenio
    }
}
