package com.example.useCases

import com.example.data.DownloadedFilesRepository
import com.example.domain.FileItem

class ShowAllDownloads (private val downloadedFilesRepository: DownloadedFilesRepository){
    fun invoke()=downloadedFilesRepository.showAllDownloads();
}