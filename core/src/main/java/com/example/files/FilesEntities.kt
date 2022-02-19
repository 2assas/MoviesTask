package com.example.files

import com.example.FailedToRequestException
import java.io.Serializable

typealias AllFiles = List<FileItem>

data class FileItem(
    val id: Long? = null,
    val type: String? = null,
    val url: String? = null,
    val name: String? = null
) : Serializable

interface FilesGateway {
    @Throws(FailedToRequestException::class)
    fun requestAllFiles(): AllFiles = throw FailedToRequestException()
    fun saveAllFiles(allFiles: AllFiles) {}
    fun loadAllFiles(): AllFiles? = null
}
