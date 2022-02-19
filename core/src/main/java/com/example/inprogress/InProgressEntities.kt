package com.example.inprogress

import java.io.Serializable

typealias InProgress = List<InProgressItem>

data class InProgressItem(
    val fileId: Long? = null
) : Serializable

interface InProgressGateway {
    fun loadAllInProgress(): InProgress? = null
    fun addToInProgress(inProgressItem: InProgressItem) {}
    fun removeFromInProgress(inProgressItem: InProgressItem) {}
}