import kotlin.random.Random

class Tablero {
    private fun setTam():Int{
        var Tam = 10
        return Tam
    }
    fun getTam():Int{
        return this.setTam()
    }
    private var tableroOculto = Array<Int>(setTam()){0}
    private var tableroJugador = Array<Int>(setTam()){-9}

    constructor(){
        this.tableroOculto
        this.tableroJugador
    }

    fun getTabO():Array<Int>{
        return this.tableroOculto
    }

    fun getTabJ():Array<Int>{
        return this.tableroJugador
    }


    public fun colocarMinas(tab : Array<Int>, mins:Int){
        var pos = 0
        var aux = mins

        while(aux > 0){
            pos = Random.nextInt(0, tab.size)
            if (tab[pos] == 0){
                tab[pos] = -1
                aux--
            }
        }
    }

    public fun colocarPistas(v : Array<Int>){
        for (i in v.indices){
            if (v[i] == -1){
                if (i - 1 >= 0){
                    if (v[i - 1] != -1){
                        v[i-1]++
                    }
                }

                if (i + 1 <= v.size-1){
                    if (v[i + 1] != -1){
                        v[i+1]++
                    }
                }
            }
        }
    }

    public fun mostrarTableroJugador(tj : Array<Int>){
        for (i in tj.indices){
            if (tj[i] == -9){
                print(" _ ")
            }
            else {
                print(" ${tj[i]} ")
            }
        }
        println()
    }

    public fun comprobar(posJ : Int , tO : Array<Int>, tJ : Array<Int>) : Boolean {
        var esMina = false

        if(tO[posJ] == -1){
            esMina = true
        }
        else {
            tJ[posJ] = tO[posJ]
        }
        return esMina
    }


}