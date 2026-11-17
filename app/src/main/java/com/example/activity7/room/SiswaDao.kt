package com.example.activity7.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

/**
 * Data Access Object (DAO) untuk mengelola operasi database pada tabel tblSiswa.
 */
@Dao
interface SiswaDao {
    /** Menyimpan data siswa baru ke database. */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(siswa: Siswa)

    /** Mengambil seluruh data siswa secara terurut berdasarkan nama (A-Z). */
    @Query("SELECT * from tblSiswa ORDER BY nama ASC")
    fun getAllSiswa(): Flow<List<Siswa>>
}