package com.example.tainers_pkm_app_parcial2

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Fruit (
    val name: String,
    val id: Long,
    val family: String,
    val order: String,
    val genus: String,
    val nutritions: Nutritions
):Parcelable

@Parcelize
data class Nutritions (
    val calories: Double,
    val fat: Double,
    val sugar: Double,
    val carbohydrates: Double,
    val protein: Double
):Parcelable
