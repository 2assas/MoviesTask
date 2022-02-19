package com.example.downloaded

import com.example.DownloadsGateway
import com.example.FilesGateway
import com.example.InProgressGateway
import com.example.downloaded.DownloadedItem
import com.example.downloaded.DownloadsGateway
import com.example.files.AllFiles
import com.example.files.FileItem
import com.example.files.FilesGateway

fun showAllInDownloads(
    downloadsGateway: DownloadsGateway,
    filesGateway: FilesGateway = FilesGateway
): AllFiles {
    return downloadsGateway.loadAllDownloads()
        ?.map { it.fileId }
        ?.let { toInProgressWithSameId(it, filesGateway) }
        ?: listOf()
}

private fun toInProgressWithSameId(inProgressIds: List<Long?>, gateway: FilesGateway) =
    gateway.loadAllFiles()?.filter { inProgressIds.contains(it.id) }

fun addToDownloads(file: FileItem, gateway: DownloadsGateway = DownloadsGateway) {
    gateway.loadAllDownloads()
        ?.none() { it.fileId == file.id }
        ?.run { gateway.addToDownloads(DownloadedItem(file.id)) }
}

