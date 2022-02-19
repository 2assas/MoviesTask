package com.example.inprogress

import com.example.FilesGateway
import com.example.InProgressGateway
import com.example.files.AllFiles
import com.example.files.FileItem
import com.example.files.FilesGateway

fun showAllInProgress(
    inProgressGateway: InProgressGateway = InProgressGateway,
    filesGateway: FilesGateway = FilesGateway
): AllFiles {
    return inProgressGateway.loadAllInProgress()
        ?.map { it.fileId }
        ?.let { toInProgressWithSameId(it, filesGateway) }
        ?: listOf()
}

private fun toInProgressWithSameId(inProgressIds: List<Long?>, gateway: FilesGateway) =
    gateway.loadAllFiles()?.filter { inProgressIds.contains(it.id) }

fun addToInProgress(file: FileItem, gateway: InProgressGateway = InProgressGateway) {
    gateway.loadAllInProgress()
        ?.none() { it.fileId == file.id }
        ?.run { gateway.addToInProgress(InProgressItem(file.id)) }
}

fun removeFromInProgress(file: FileItem, gateway: InProgressGateway = InProgressGateway) {
    gateway.loadAllInProgress()
        ?.any() { it.fileId == file.id }
        ?.run { gateway.removeFromInProgress(InProgressItem(file.id)) }
}

