package com.example.gasometria.logica

open class PercentilHidrogenio(
    var ph: Double,
    var hco3: Double,
    var pco2: Double
    ) {
    var resultado: String? = null

    init {
        perceHidro()
    }

    fun perceHidro() {
        //PACIENTE EM ÓBITO
        if (ph <= 6.80 || ph >= 7.80) {
            resultado = "Paciente em estado GRAViSSIMO !!!\ncom incopatibilidade com a vida"
        }

        //PH normal
        if (ph >= 7.35 && ph <= 7.45) {
            if (hco3 >= 22 && hco3 <= 26 || pco2 >= 35 && pco2 <= 45) {
                resultado =
                    "Paciente com PH normal,\nsem alterções no mecanismos compensatórios."
            } else if (hco3 > 26 && pco2 > 45) {
                resultado =
                    "Paciente com PH normal,\nporém houve uma ACIDOSE RESPIRATÓRIA COMPENSADA."
            } else if (hco3 < 22 && pco2 < 45) {
                resultado =
                    "Paciente com PH normal,\nporém houve uma ACIDOSE METABÓLICA COMPENSADA."
            }
        }

        //PACIENTE COM ACIDOSE
        if (ph >= 7.10 && ph < 7.35) {
            if (hco3 < 22 && pco2 <= 35) {
                resultado = """Paciente apresenta ACIDOSE METABÓLICA!!!
                            A função respiratória está tentando compensar."""
            } else if (hco3 < 22 && pco2 <= 45) {
                resultado = """
                    Paciente apresenta ACIDOSE METABÓLICA!!!
                    Sem alterações no mecanismos compensatórios.
                    """.trimIndent()
            } else if (hco3 < 22 && pco2 > 45) {
                resultado = "Paciente apresenta ACIDOSE MISTA!!!."
            } else {
                if (pco2 > 45 && hco3 >= 26) {
                    resultado = """
                        Paciente apresenta ACIDOSE RESPIRATÓRIA!!!
                        A função metabólica está tentando compensar.
                        """.trimIndent()
                } else {
                    resultado = """
                        Paciente apresenta acidose RESPIRATÓRIA!!!
                        sem alterações no mecanismos compensatórios.
                        """.trimIndent()
                }
            }
        }

        //PACIENTE COM ALCALOSE
        if (ph > 7.45 && ph <= 7.60) {
            if (hco3 > 26 && pco2 > 45) {
                resultado = """
                    Paciente apresenta ALCALOSE METABÓLICA,
                    a função respiratória está tentando compensar.
                    """.trimIndent()
            } else if (hco3 < 22 && pco2 < 35) {
                resultado = """
                    Paciente apresenta ALCALOSE RESPIRATÓRIA,
                    a função metabolica está tentando compensar.
                    """.trimIndent()
            } else if (hco3 > 26 && pco2 >= 35 && pco2 <= 45) {
                resultado = """
                    Paciente apresenta ALCALOSE METABÓLICA,
                    sem alterações no mecanismos compensatórios.
                    """.trimIndent()
            } else if (pco2 < 35 && hco3 >= 22 && hco3 <= 26) {
                resultado = """
                    Paciente apresenta ALCALOSE RESPIRATÓRIA,
                    sem alterações no mecanismos compensatórios.
                    """.trimIndent()
            } else {
                resultado = "Paciente apresenta ALCALOSE MISTA"
            }
        }
        //ACIDOSE GRAVE !!!
        if (ph >= 6.81 && ph <= 7.10) {
            if (hco3 < 22 && pco2 < 35) {
                resultado = """
                    Paciente apresenta ACIDOSE METABÓLICA GRAVE !!!
                    a função respiratória está tentando compensar.
                    """.trimIndent()
            } else if (hco3 > 26 && pco2 > 45) {
                resultado = """
                    Paciente apresenta ACIDOSE RESPIRATÓRIA GRAVE !!!
                    a função metabólica está tentando compensar.
                    """.trimIndent()
            } else if (hco3 < 22 && pco2 > 45) {
                resultado = "Paciente apresenta ACIDOSE MISTA GRAVE!!!"
            } else if (hco3 >= 22 && hco3 <= 26 && pco2 > 45) {
                resultado = """
                    Paciente apresenta ACIDOSE RESPIRATÓRIA GRAVE!!!
                    sem alterações no mecanismos compensatórios.
                    """.trimIndent()
            } else if (pco2 >= 35 && pco2 <= 45 && hco3 < 22) {
                resultado = """
                    Paciente apresenta ACIDOSE METABÓLICA GRAVE!!!
                    sem alterações no mecanismos compensatórios.
                    """.trimIndent()
            } else {
                resultado = "Erro na passagem de dados."
            }
        }

        //ALCALOSE GRAVE
        if (ph >= 7.60 && ph <= 7.80) {
            if (hco3 > 26 && pco2 > 45) {
                resultado = """
                    Paciente apresenta ALCALOSE METABÓLICA GRAVE !!!
                    A função respiratória está tentando compensar.
                    """.trimIndent()
            } else if (hco3 < 22 && pco2 < 35) {
                resultado = """
                    Paciente apresenta ALCALOSE RESPIRATÓRIA GRAVE !!!
                    A função metabolica está tentando compensar.
                    """.trimIndent()
            } else if (hco3 >= 22 && hco3 <= 26 && pco2 < 35) {
                resultado = """
                    Paciente apresenta ALCALOSE RESPIRATÓRIO GRAVE !!!
                    sem alterações no mecanismos compensatórios.
                    """.trimIndent()
            } else if (pco2 >= 35 && pco2 <= 45 && hco3 <= 22) {
                resultado = """
                    Paciente apresenta ALCALOSE METABÓLICA GRAVE !!!
                    sem alterações no mecanismos compensatórios.
                    """.trimIndent()
            } else if (hco3 > 26 && pco2 < 35) {
                resultado = "Paciente apresenta ALCALOSE MISTA GRAVE"
            } else {
                resultado = "Erro na passagem de dados."
            }
        }
    }
}