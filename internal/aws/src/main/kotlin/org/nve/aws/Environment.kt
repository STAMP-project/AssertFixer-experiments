package org.nve.aws


sealed class Environment {
    class Local: Environment()

    data class Aws(
            val project: String
    ): Environment()
}