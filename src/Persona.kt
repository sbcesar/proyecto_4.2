import kotlin.math.pow

class Persona(peso: Double, altura: Double) {
    var nombre: String = ""
    private var peso: Double = 0.0
    private var altura: Double = 0.0
    var imc: Double = 0.0

    init {
        this.peso = peso
        this.altura = altura
        this.imc = calcularIMC()
    }

    constructor(nombre: String,peso: Double,altura: Double,imc: Double): this(peso,altura) {
        this.nombre = nombre
        this.imc = imc
    }

    fun saludar(): String {
        return "Hola!! Me llamo ${this.nombre}"
    }

    fun calcularIMC(): Double {
        return this.peso / (this.altura.pow(2))
    }

    private fun estadoPersona(): String {
        return when {
            this.imc < 18.5 -> "peso insuficiente"
            this.imc < 24.9 -> "peso saludable"
            this.imc < 29.9 -> "sobrepeso"
            this.imc >= 30.0 -> "obesidad"
            else -> "error de cálculo"
        }
    }

    fun modificarNombre() {
        print("Introduzca su nuevo nombre: ")
        nombre = readln()
    }

    private fun alturaEncimaMedia(): Boolean {
        return if (this.altura >= 1.75) true else false
    }

    private fun mediaAltura(): String {
        val boleanoAltura = alturaEncimaMedia()
        return when {
            boleanoAltura -> "Por encima de la media"
            !boleanoAltura -> "Por debajo de la media"
            else -> "Error de cálculo"
        }
    }

    private fun pesoEncimaMedia(): Boolean {
        return if (this.peso >= 70) true else false
    }

    private fun mediaPeso(): String {
        val booleanoPeso = pesoEncimaMedia()
        return when {
            booleanoPeso -> "Por encima de la media"
            !booleanoPeso -> "Por debajo de la media"
            else -> "Error de cálculo"
        }
    }

    override fun toString(): String {
        return "Nombre: ${this.nombre}\nPeso: ${this.peso} (${mediaPeso()})\nAltura: ${this.altura} (${mediaAltura()})\nIMC: ${this.imc}\nEstado: ${estadoPersona()}"
    }
}