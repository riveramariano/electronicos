package com.electronicos.ui.electronico

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.electronicos.R
import com.electronicos.databinding.FragmentAddElectronicoBinding
import com.electronicos.model.Electronico
import com.electronicos.viewmodel.ElectronicoViewModel

class AddElectronicoFragment : Fragment() {
    private lateinit var electronicoViewModel: ElectronicoViewModel

    private var _binding: FragmentAddElectronicoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddElectronicoBinding.inflate(inflater, container, false)

        electronicoViewModel = ViewModelProvider(this).get(ElectronicoViewModel::class.java)

        binding.btAgregarElectronico.setOnClickListener {
            addElectronico()
        }

        return binding.root
    }

    private fun addElectronico() {
        var nombre = binding.etNombre.text.toString()
        if (nombre.isNotEmpty()) { // Podemos insertar el lugar
            var marca = binding.etMarca.text.toString()
            var electronico = Electronico(0, nombre, marca)
            electronicoViewModel.addElectronico(electronico)
            Toast.makeText(requireContext(), "Electrónico Agregado", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(requireContext(), "Faltan Datos", Toast.LENGTH_SHORT).show()
        }
        findNavController().navigate(R.id.action_addElectronicoFragment_to_nav_electronico)
    }
}