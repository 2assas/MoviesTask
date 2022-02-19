package com.example.downloaded

import java.io.Serializable

typealias Downloads = List<DownloadedItem>

data class DownloadedItem(
    val fileId: Long? = null
) : Serializable

interface DownloadsGateway {
    fun loadAllDownloads(): Downloads? = null
    fun addToDownloads(downloadedItem: DownloadedItem) {}
}