package com.electronicos.repository

import androidx.lifecycle.LiveData
import com.electronicos.data.ElectronicoDao
import com.electronicos.model.Electronico

class ElectronicoRepository(private val electronicoDao: ElectronicoDao) {
    val getAllData: LiveData<List<Electronico>> = electronicoDao.getAllData()

    suspend fun addElectronico(electronico: Electronico) {
        electronicoDao.addElectronico(electronico)
    }

    suspend fun updateElectronico(electronico: Electronico) {
        electronicoDao.updateElectronico(electronico)
    }

    suspend fun deleteElectronico(electronico: Electronico) {
        electronicoDao.deleteElectronico(electronico)
    }
}