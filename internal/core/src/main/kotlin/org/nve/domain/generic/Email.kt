package org.nve.domain.generic

import javax.mail.Address

data class Email(
        val user: String,
        val domain: String
): Address() {
    override fun getType(): String {
        return "rfc822"
    }

    override fun toString(): String = emailAddress

    private val emailAddress by lazy(LazyThreadSafetyMode.NONE) { "$user@$domain" }
}