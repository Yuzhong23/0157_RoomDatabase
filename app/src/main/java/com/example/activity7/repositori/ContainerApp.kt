package com.example.activity7.repositori

import android.content.Context
import com.example.activity7.room.DatabaseSiswa

/**
 * Container dependensi aplikasi untuk menyediakan instance RepositoriSiswa.
 */
interface ContainerApp {
    val repositoriSiswa: RepositoriSiswa
}

class ContainerDataApp(private val context: Context) : ContainerApp {
    override val repositoriSiswa: RepositoriSiswa by lazy {
        OfflineRepositoriSiswa(DatabaseSiswa.getDatabase(context).siswaDao())
    }
}