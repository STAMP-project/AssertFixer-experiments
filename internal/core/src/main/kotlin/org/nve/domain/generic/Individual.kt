package org.nve.domain.generic

data class Individual(
        val name: Name,
        val address: Address?,
        val phoneNumber: PhoneNumber?
){
    data class Name(
            val firstName: String,
            val lastName: String
    ) {
        val fullName: String = "$firstName $lastName"
    }
}