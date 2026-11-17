package com.example.activity7.repositori

import com.example.activity7.room.Siswa
import com.example.activity7.room.SiswaDao
import kotlinx.coroutines.flow.Flow

/**
 * Kontrak repositori untuk mengakses dan menyimpan data siswa dari sumber data lokal.
 */
interface RepositoriSiswa {
    fun getAllSiswaStream(): Flow<List<Siswa>>
    suspend fun insertSiswa(siswa: Siswa)
}

class OfflineRepositoriSiswa(
    private val siswaDao: SiswaDao
) : RepositoriSiswa {
    override fun getAllSiswaStream(): Flow<List<Siswa>> = siswaDao.getAllSiswa()
    override suspend fun insertSiswa(siswa: Siswa) = siswaDao.insert(siswa)
}