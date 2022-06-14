package com.electronicos.ui.electronico

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.electronicos.R
import com.electronicos.databinding.FragmentElectronicoBinding
import com.electronicos.viewmodel.ElectronicoViewModel

class ElectronicoFragment : Fragment() {

    private lateinit var electronicoViewModel: ElectronicoViewModel
    private var _binding: FragmentElectronicoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        electronicoViewModel = ViewModelProvider(this).get(ElectronicoViewModel::class.java)
        _binding = FragmentElectronicoBinding.inflate(inflater, container, false)

        binding.btAgregarElectronico.setOnClickListener {
            findNavController().navigate(R.id.action_nav_electronico_to_addElectronicoFragment)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}