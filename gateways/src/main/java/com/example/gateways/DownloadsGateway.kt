package com.example.gateways

import com.example.downloaded.DownloadedItem
import com.example.downloaded.Downloads
import com.example.downloaded.DownloadsGateway

class DownloadsGatewayImplementer : DownloadsGateway {
    override fun loadAllDownloads(): Downloads? {
        return super.loadAllDownloads()
    }
    override fun addToDownloads(downloadedItem: DownloadedItem) {
        super.addToDownloads(downloadedItem)
    }
}