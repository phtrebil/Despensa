package br.com.pedro.despensa.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Despensa(
    val id: Int?,
    val nome: String?,
    val quantidade: String?,
    val imagem: String?
): Parcelable {
}