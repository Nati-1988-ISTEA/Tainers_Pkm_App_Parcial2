package com.example.tainers_pkm_app_parcial2

data class Trainer (
    val results: List<Result>,
    val info: Info
)

data class Info (
    val seed: String,
    val results: Long,
    val page: Long,
    val version: String
)

data class Result (
    val gender: String,
    val name: Name,
    val location: Location,
    val email: String,
    val login: Login,
    val dob: Dob,
    val registered: Dob,
    val phone: String,
    val cell: String,
    val id: ID,
    val picture: Picture,
    val nat: String
)

data class Dob (
    val date: String,
    val age: Long
)

data class ID (
    val name: String,
    val value: String
)

data class Location (
    val street: Street,
    val city: String,
    val state: String,
    val country: String,
    val postcode: Long,
    val coordinates: Coordinates,
    val timezone: Timezone
)

data class Coordinates (
    val latitude: String,
    val longitude: String
)

data class Street (
    val number: Long,
    val name: String
)

data class Timezone (
    val offset: String,
    val description: String
)

data class Login (
    val uuid: String,
    val username: String,
    val password: String,
    val salt: String,
    val md5: String,
    val sha1: String,
    val sha256: String
)

data class Name (
    val title: String,
    val first: String,
    val last: String
)

data class Picture (
    val large: String,
    val medium: String,
    val thumbnail: String
)


/*


package com.example.tainers_pkm_app_parcial2

import com.google.gson.annotations.SerializedName

data class Trainer (
    @SerializedName("results") val results: List<Result>,
    @SerializedName("info") val info: Info
)

data class Info (
    @SerializedName("seed") val seed: String,
    @SerializedName("results") val results: Long,
    @SerializedName("page") val page: Long,
    @SerializedName("version") val version: String
)

data class Result (
    @SerializedName("gender") val gender: String,
    @SerializedName("name") val name: Name,
    @SerializedName("location") val location: Location,
    @SerializedName("email") val email: String,
    @SerializedName("login") val login: Login,
    @SerializedName("dob") val dob: Dob,
    @SerializedName("registered") val registered: Dob,
    @SerializedName("phone") val phone: String,
    @SerializedName("cell") val cell: String,
    @SerializedName("id") val id: ID,
    @SerializedName("picture") val picture: Picture,
    @SerializedName("nat") val nat: String
)

data class Dob (
    @SerializedName("date") val date: String,
    @SerializedName("age") val age: Long
)

data class ID (
    @SerializedName("name") val name: String,
    @SerializedName("value") val value: String
)

data class Location (
    @SerializedName("street") val street: Street,
    @SerializedName("city") val city: String,
    @SerializedName("state") val state: String,
    @SerializedName("country") val country: String,
    @SerializedName("postcode") val postcode: Long,
    @SerializedName("coordinates") val coordinates: Coordinates,
    @SerializedName("timezone") val timezone: Timezone
)

data class Coordinates (
    @SerializedName("latitude")  val latitude: String,
    @SerializedName("longitude") val longitude: String
)

data class Street (
    @SerializedName("number") val number: Long,
    @SerializedName("name") val name: String
)

data class Timezone (
    @SerializedName("offset") val offset: String,
    @SerializedName("description") val description: String
)

data class Login (
    @SerializedName("uuid") val uuid: String,
    @SerializedName("username") val username: String,
    @SerializedName("password") val password: String,
    @SerializedName("salt") val salt: String,
    @SerializedName("md5") val md5: String,
    @SerializedName("sha1") val sha1: String,
    @SerializedName("sha256") val sha256: String
)

data class Name (
    @SerializedName("title") val title: String,
    @SerializedName("first") val first: String,
    @SerializedName("last") val last: String
)

data class Picture (
    @SerializedName("large") val large: String,
    @SerializedName("medium") val medium: String,
    @SerializedName("thumbnail") val thumbnail: String
)

*/