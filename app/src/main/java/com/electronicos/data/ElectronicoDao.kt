package com.electronicos.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.electronicos.model.Electronico

@Dao
interface ElectronicoDao {
    @Query("SELECT * FROM ELECTRONICO")
    fun getAllData(): LiveData<List<Electronico>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addElectronico(electronico: Electronico)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    fun updateElectronico(electronico: Electronico)

    @Delete
    fun deleteElectronico(electronico: Electronico)
}