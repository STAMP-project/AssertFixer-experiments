package org.nve.domain.generic

data class Address(
        val streetNumber: Int,
        val streetName: String,
        val city: String,
        val state: String,
        val zipCode: Int
) {
    val readable: String = "$streetNumber $streetName, $city, $state $zipCode"
}