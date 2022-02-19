package com.example.useCases

import com.example.data.InProgressFilesRepository
import com.example.domain.FileItem

class ShowAllInProgress (private val inProgressFilesRepository: InProgressFilesRepository){
    fun invoke()=inProgressFilesRepository.showAllInProgress()
}