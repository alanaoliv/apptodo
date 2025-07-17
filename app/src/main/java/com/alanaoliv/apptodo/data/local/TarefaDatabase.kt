package com.alanaoliv.apptodo.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [TarefaEntity::class], version = 1)
abstract class TarefaDatabase : RoomDatabase() {
    abstract fun tarefaDao(): TarefaDao
}
