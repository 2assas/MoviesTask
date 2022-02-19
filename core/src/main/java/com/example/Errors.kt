package com.example

import java.lang.RuntimeException

class FailedToRequestException(message: String? = null) : RuntimeException(message)