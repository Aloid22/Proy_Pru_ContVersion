import java.util.*
import kotlin.random.Random

fun main(args: Array<String>) {
    println("BUSCAMINAS")
    println("Cantidad de minas")
    var minas = readln().toInt()

    var TableroO = Tablero().getTabO()
    var TableroJ = Tablero().getTabJ()

    var minaDestapada = false
    var casillasPorDescubrir = Tablero().getTam()

    Tablero().colocarMinas(TableroO,minas)
    Tablero().colocarPistas(TableroO)

//    println(Arrays.toString(TableroO))

    while(!minaDestapada && casillasPorDescubrir != minas){
        Tablero().mostrarTableroJugador(TableroJ)
        print("Dame una posición 0-${Tablero().getTam()-1}: ")
        var posJuego = readln().toInt()
        minaDestapada = Tablero().comprobar(posJuego,TableroO,TableroJ)
        if (!minaDestapada){
            casillasPorDescubrir--
        }
    }

    if(minaDestapada){
        println("Has perdido")
    }
    else {
        println("Enhorabuena!!")
    }
}