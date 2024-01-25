fun main() {

    val persona1 = Persona("Lara",35.3, 1.74,0.0)
    val persona2 = Persona("Pepe",70.5, 2.00,0.0)
    val persona3 = Persona("Juan", 85.0, 1.80, 0.0)
    val persona4 = Persona("Hernesto",333.33,1.80,0.0)

    //Modificar nombre persona 1
    persona1.imc = persona1.calcularIMC()
    println("Persona1\n${persona1.saludar()}\n$persona1")
    println("¿Desea modificar su nombre (s/n)?")
    val opcion = readln()
    if (opcion.lowercase() == "s") {
        persona1.modificarNombre()
        println("Nombre ${persona1.nombre} modificado correctamente")
    }

    //Mostrar informacion de la persona 2
    persona2.imc = persona2.calcularIMC()
    println("Persona2\n${persona2.saludar()}\n$persona2")

    //Actualizar IMC persona 3
    println("Persona3 (antes de actualizar el IMC)\n${persona3.saludar()}\n$persona3")
    persona3.imc = persona3.calcularIMC()
    println("Persona 3 (con el IMC actualizado)\n${persona3.saludar()}\n$persona3")

    //persona 4
    persona4.imc = persona4.calcularIMC()
    println("Persona4\n${persona4.saludar()}\n$persona4")

}