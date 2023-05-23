package duran.juancarlos.tienda

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import duran.juancarlos.tienda.databinding.FragmentBlankBinding
import java.util.*

class TiendaFragment : Fragment() {

    private var _binding: FragmentBlankBinding?=null
    private lateinit var tienda: Tienda1
    private val binding
    get()= checkNotNull(_binding){
        "no se puede acceder al binding porque es nulo"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        tienda = Tienda1(
            UUID.randomUUID(),
            "",
            ""
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBlankBinding.inflate(layoutInflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {

            nombreTienda.doOnTextChanged { text, _, _, _ ->
                tienda = tienda.copy(nombre = text.toString())
            }
            telenofoTienda.doOnTextChanged { text, _, _, _ ->
                tienda = tienda.copy(telefono = text.toString())
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding= null
    }

}