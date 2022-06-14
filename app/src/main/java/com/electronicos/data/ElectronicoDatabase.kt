package com.electronicos.data

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.electronicos.model.Electronico

@Database(entities = [Electronico::class], version = 1, exportSchema = false)
abstract class ElectronicoDatabase: RoomDatabase() {
    abstract fun electronicoDao(): ElectronicoDao

    companion object {
        @Volatile
        private var INSTANCE: ElectronicoDatabase? = null

        fun getDatabase(context: android.content.Context): ElectronicoDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ElectronicoDatabase::class.java,
                    "electronico_database",
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}