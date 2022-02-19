package com.example.files

import com.example.FilesGateway

fun showAllFiles(gateway: FilesGateway= FilesGateway): AllFiles{
    return runCatching { gateway.requestAllFiles() }
        .onSuccess { gateway.saveAllFiles(it) }
        .getOrThrow()
}