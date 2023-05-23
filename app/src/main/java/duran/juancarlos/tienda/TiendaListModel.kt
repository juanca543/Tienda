package duran.juancarlos.tienda

import androidx.lifecycle.ViewModel
import java.util.UUID

class TiendaListModel : ViewModel(){

    val tiendas= mutableListOf<Tienda1>()

    init{

        for(i in 0  until  100){

            val tienda = Tienda1(
                id= UUID.randomUUID(),
                nombre="Tienda #${i}",
                telefono="#${i}"
            )

            tiendas+=tienda

        }
    }

}