import kotlin.math.pow


/**
 * Clase que representa una Persona con sus atributos y métodos relacionados.
 *
 * @property peso El peso de la persona en kilogramos.
 * @property altura La altura de la persona en metros.
 * @property nombre El nombre de la persona.
 * @property imc El Índice de Masa Corporal (IMC) de la persona.
 */
class Persona(peso: Double, altura: Double) {
    var nombre: String = ""
    private var peso: Double = 0.0
    private var altura: Double = 0.0
    var imc: Double = 0.0

    /**
     * Constructor primario que inicializa las propiedades de la persona y calcula su IMC.
     *
     * @param peso El peso de la persona en kilogramos.
     * @param altura La altura de la persona en metros.
     */
    init {
        this.peso = peso
        this.altura = altura
        this.imc = calcularIMC()
    }

    /**
     * Constructor secundario que permite especificar el nombre y el IMC de la persona.
     *
     * @param nombre El nombre de la persona.
     * @param peso El peso de la persona en kilogramos.
     * @param altura La altura de la persona en metros.
     * @param imc El Índice de Masa Corporal (IMC) de la persona.
     */
    constructor(nombre: String,peso: Double,altura: Double,imc: Double): this(peso,altura) {
        this.nombre = nombre
        this.imc = imc
    }

    /**
     * Retorna un saludo con el nombre de la persona.
     *
     * @return Saludo con el nombre de la persona.
     */
    fun saludar(): String {
        return "Hola!! Me llamo ${this.nombre}"
    }

    /**
     * Calcula el Índice de Masa Corporal (IMC) de la persona.
     *
     * @return El IMC calculado.
     */
    fun calcularIMC(): Double {
        return this.peso / (this.altura.pow(2))
    }

    /**
     * Retorna el estado de la persona basado en su IMC.
     *
     * @return Estado de la persona según su IMC.
     */
    private fun estadoPersona(): String {
        return when {
            this.imc < 18.5 -> "peso insuficiente"
            this.imc < 24.9 -> "peso saludable"
            this.imc < 29.9 -> "sobrepeso"
            this.imc >= 30.0 -> "obesidad"
            else -> "error de cálculo"
        }
    }

    /**
     * Modifica el nombre de la persona.
     */
    fun modificarNombre() {
        print("Introduzca su nuevo nombre: ")
        nombre = readln()
    }

    /**
     * Verifica si la altura de la persona está por encima de la media.
     *
     * @return true si la altura está por encima de la media, false de lo contrario.
     */
    private fun alturaEncimaMedia(): Boolean {
        return if (this.altura >= 1.75) true else false
    }

    /**
     * Retorna una cadena indicando si la altura está por encima o por debajo de la media.
     *
     * @return Descripción de la altura en relación con la media.
     */
    private fun mediaAltura(): String {
        val boleanoAltura = alturaEncimaMedia()
        return when {
            boleanoAltura -> "Por encima de la media"
            !boleanoAltura -> "Por debajo de la media"
            else -> "Error de cálculo"
        }
    }

    /**
     * Verifica si el peso de la persona está por encima de la media.
     *
     * @return true si el peso está por encima de la media, false de lo contrario.
     */
    private fun pesoEncimaMedia(): Boolean {
        return if (this.peso >= 70) true else false
    }

    /**
     * Retorna una cadena indicando si el peso está por encima o por debajo de la media.
     *
     * @return Descripcion del peso en relacion con la media.
     */
    private fun mediaPeso(): String {
        val booleanoPeso = pesoEncimaMedia()
        return when {
            booleanoPeso -> "Por encima de la media"
            !booleanoPeso -> "Por debajo de la media"
            else -> "Error de cálculo"  //Caso de error inesperado
        }
    }

    /**
     * Devuelve una representación de cadena de la persona incluyendo su nombre, peso, altura, IMC y estado.
     *
     * @return Representación de cadena de la persona.
     */
    override fun toString(): String {
        return "Nombre: ${this.nombre}\nPeso: ${this.peso} (${mediaPeso()})\nAltura: ${this.altura} (${mediaAltura()})\nIMC: ${this.imc}\nEstado: ${estadoPersona()}"
    }
}