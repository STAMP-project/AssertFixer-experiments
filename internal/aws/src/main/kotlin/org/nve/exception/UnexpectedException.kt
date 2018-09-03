package org.nve.exception

class UnexpectedException(
        cause: Throwable,
        message: String = "An Unexpected Failure has occurred."
): ServerException (
        cause = cause,
        message = message
)