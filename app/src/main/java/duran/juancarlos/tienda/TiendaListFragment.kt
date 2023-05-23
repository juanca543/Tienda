package duran.juancarlos.tienda

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import duran.juancarlos.tienda.databinding.FragmentTiendaListBinding


private const val TAG= "TiendaListFragment"

class TiendaListFragment: Fragment() {

    private val tiendaListModel: TiendaListModel by viewModels()

    private var _binding: FragmentTiendaListBinding? = null
    private val binding
        get() = checkNotNull(_binding) {
            "No se puede acceder al binding"
        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, " Existen" + tiendaListModel.tiendas.size +"tiendas")}


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTiendaListBinding.inflate(inflater, container, false)
        val tiendas= tiendaListModel.tiendas
        val adapter= TiendaListAdapter(tiendas)
        binding.tiendaRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.tiendaRecyclerView.adapter= adapter
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}

