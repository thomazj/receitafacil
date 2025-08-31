package com.example.receitafacil.core.domain.exceptions

import com.example.receitafacil.core.data.remote.responses.ErrorResponse

class ErrorResponseException( val error: ErrorResponse ) : RuntimeException()