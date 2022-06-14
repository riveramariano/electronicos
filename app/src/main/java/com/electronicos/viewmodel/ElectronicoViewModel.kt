package com.electronicos.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.electronicos.data.ElectronicoDatabase
import com.electronicos.model.Electronico
import com.electronicos.repository.ElectronicoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ElectronicoViewModel(application: Application) : AndroidViewModel(application) {
    val getAllData: LiveData<List<Electronico>>

    private val repository: ElectronicoRepository

    init {
        val electronicoDao = ElectronicoDatabase.getDatabase(application).electronicoDao()
        repository = ElectronicoRepository(electronicoDao)
        getAllData = repository.getAllData
    }

    fun addElectronico(electronico: Electronico) {
        viewModelScope.launch(Dispatchers.IO) { repository.addElectronico(electronico) }
    }

    fun updateLugar(electronico: Electronico) {
        viewModelScope.launch(Dispatchers.IO) { repository.updateElectronico(electronico) }
    }

    fun deleteLugar(electronico: Electronico) {
        viewModelScope.launch(Dispatchers.IO) { repository.deleteElectronico(electronico) }
    }
}