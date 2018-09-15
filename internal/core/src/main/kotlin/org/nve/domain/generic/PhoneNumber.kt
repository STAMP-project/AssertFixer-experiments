package org.nve.domain.generic

data class PhoneNumber(
        val areaCode: Int,
        val phoneNumber: Int
) {
    val readable: String by lazy(LazyThreadSafetyMode.NONE) {
        "($areaCode) ${phoneNumber.toString().substring(0, 3)} - ${phoneNumber.toString().substring(3, 7) }"
    }
}