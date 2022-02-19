package com.example

import com.example.downloaded.DownloadsGateway
import com.example.files.FilesGateway
import com.example.inprogress.InProgressGateway

internal lateinit var FilesGateway : FilesGateway private set
internal lateinit var InProgressGateway : InProgressGateway private set
internal lateinit var DownloadsGateway : DownloadsGateway private set

object CoreDependencies {
    fun filesGateway(filesGateway: FilesGateway):CoreDependencies{
        FilesGateway = filesGateway
        return this
    }

    fun inProgressGateway(inProgressGateway: InProgressGateway):CoreDependencies{
        InProgressGateway = inProgressGateway
        return this
    }

    fun downloadsGateway(downloadsGateway: DownloadsGateway):CoreDependencies{
        DownloadsGateway = downloadsGateway
        return this
    }
}