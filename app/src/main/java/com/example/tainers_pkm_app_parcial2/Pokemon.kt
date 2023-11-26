package com.example.tainers_pkm_app_parcial2
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pokemon (

    val form_name: String,
    //val form_names: List<Any?>,
    val form_order: Long,
    val id: Long,
    val is_battle_only: Boolean,
    val is_default: Boolean,
    val is_mega: Boolean,
    val name: String,
    //val names: List<Any?>,
    val order: Long,
    val pokemon: PokemonClass,
    val sprites: Sprites,
    val types: List<Type>, //List<Type>,
    val version_group: PokemonVersion
):Parcelable

@Parcelize
data class PokemonClass (
    val name: String,
    val url: String
):Parcelable

@Parcelize
data class Sprites (

    val back_default: String,
    //val back_female: Any? = null,
    val back_shiny: String,
    //val back_shiny_female: Any? = null,
    val front_default: String,
    //val front_female: Any? = null,
    val front_shiny: String,
    //val front_shiny_female: Any? = null
):Parcelable

@Parcelize
data class Type (
    val slot: Long,
    val type: PokemonClass
):Parcelable

@Parcelize
data class PokemonVersion (
    val name: String,
    val url: String
):Parcelable