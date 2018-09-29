package org.nve.domain

import org.nve.domain.generic.Address
import org.nve.domain.generic.Individual
import org.nve.domain.generic.PhoneNumber

sealed class Company {
    abstract val id: Long
    abstract val name: String
    abstract val address: Address
    abstract val phoneNumber: PhoneNumber
    abstract val faxNumber: PhoneNumber
    abstract val attention: Individual?

    data class Brokerage(
            override val id: Long,
            override val name: String,
            override val address: Address,
            override val phoneNumber: PhoneNumber,
            override val faxNumber: PhoneNumber,
            override val attention: Individual?
    ) : Company()

    data class Agency(
            override val id: Long,
            override val name: String,
            override val address: Address,
            override val phoneNumber: PhoneNumber,
            override val faxNumber: PhoneNumber,
            override val attention: Individual?
    ) : Company()

    data class Customer(
            override val id: Long,
            override val name: String,
            override val address: Address,
            override val phoneNumber: PhoneNumber,
            override val faxNumber: PhoneNumber,
            override val attention: Individual?
    ) : Company()
}