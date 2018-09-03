package org.nve.exception

class ExpectedException(
        cause: Throwable,
        message: String
): ServerException (
        cause = cause,
        message = message
)