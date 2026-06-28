package com.example.kostku.model

data class KostRoom(
    val id: Int,
    val name: String,
    val price: String,
    val location: String,
    val description: String
)

val dummyKostList = listOf(
    KostRoom(1, "Kost Putra Kebumen", "Rp 500.000 / bulan", "Jl. PSDKU No. 1", "Fasilitas: Kasur, Lemari, WiFi kencang, dan Kamar Mandi Luar."),
    KostRoom(2, "Kost Putri Sejahtera", "Rp 650.000 / bulan", "Jl. Merdeka No. 45", "Fasilitas: AC, Kasur, Lemari, dan Kamar Mandi Dalam."),
    KostRoom(3, "Kost Eksklusif Mawar", "Rp 1.200.000 / bulan", "Jl. Sudirman No. 10", "Fasilitas: AC, TV, Kulkas, Dapur Bersama, dan Parkir Luas.")
)