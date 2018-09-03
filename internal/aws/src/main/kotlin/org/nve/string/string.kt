package org.nve.string

private inline fun CharSequence.toOther(
        check: (Char) -> Boolean,
        action: (Char) -> String,
        fallback: (Char) -> Char
): String {
    if(length < 1) return ""
    val first = fallback(first())
    if(length < 2) return first.toString()
    val builder = StringBuilder()
    for(char in this) {
        if(check(char)) builder.append(action(char))
        else builder.append(fallback(char))
    }
    return builder.toString()
}

fun String.endWith(suffix: String): String {
    if(length < 1) return suffix
    if(endsWith(suffix)) return this
    return "$this$suffix"
}

fun CharSequence.toUpperUnderscore(): String =
        toOther({ it.isUpperCase() }, { "_$it" }, { it.toUpperCase() })

fun CharSequence.toLowerDotted(): String =
        toOther({ it.isUpperCase() }, { ".${it.toLowerCase()}" }, { it.toLowerCase() })