package com.rast.alquran.api

import android.app.DownloadManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.Uri
import android.util.Log
import com.rast.alquran.BuildConfig
import com.rast.alquran.utils.numberToFormattedString
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import java.io.File

object FontDownloadManager {
    private var downloadId: Long = 0
    private var receiver: BroadcastReceiver? = null


    fun downloadFont(pageNumber: Int, context: Context) : Flow<String> = callbackFlow{
        val page = numberToFormattedString(pageNumber)
        val url = BuildConfig.FONT_URL + "qcf2$page.ttf?alt=media"  // URL of the file to download
        Log.d("TTT", url)
        val request = DownloadManager.Request(Uri.parse(url))

        // Set the title and description that will be shown in the notification
        request.setTitle("Fonts of Page $page")
        request.setDescription("Downloading")

        // Set the path for the downloaded file
        val filename = "qcf2$page.ttf"
        val file = File(context.externalCacheDir , filename)
        request.setDestinationUri(Uri.fromFile(file))

        // Get the DownloadManager service and enqueue the request
        val manager = context.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
        val downloadId = manager.enqueue(request)

        // Create a BroadcastReceiver to get notified when the download is complete
        receiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context, intent: Intent) {
                if (DownloadManager.ACTION_DOWNLOAD_COMPLETE == intent.action) {
                    val query = DownloadManager.Query()
                    query.setFilterById(downloadId)
                    val cursor = manager.query(query)
                    if (cursor.moveToFirst()) {
                        val statusIndex = cursor.getColumnIndex(DownloadManager.COLUMN_STATUS)
                        if (DownloadManager.STATUS_SUCCESSFUL == cursor.getInt(statusIndex)) {
                            // The download was successful, do something here
                            trySend(
                                file.absolutePath
                            )
                            context.unregisterReceiver(receiver)
                        }
                    }
                }
                val id = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1)
                if (id == downloadId) {
                    val query = DownloadManager.Query()
                    query.setFilterById(downloadId)
                    val cursor = manager.query(query)
                    if (cursor.moveToFirst()) {
                        val bytesDownloaded = cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_BYTES_DOWNLOADED_SO_FAR).coerceAtLeast(0))
                        val totalBytes = cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_TOTAL_SIZE_BYTES).coerceAtLeast(0))

                        val progress = bytesDownloaded / totalBytes
                        trySend(
                            "0%$progress"
                        )
                    }
                }
            }
        }

// Register the receiver to get download complete notifications
        context.registerReceiver(receiver, IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE))

        awaitClose {  }

    }

    fun getFontPathOrEmpty(pageNumber: Int, context: Context): String {
        val page = numberToFormattedString(pageNumber)
        val filename = "qcf2$page.ttf"
        return findFile(context, filename) ?: ""

    }

    fun findFile(context: Context, filename: String): String? {
        val filesDir = context.externalCacheDir
        val file = File(filesDir, filename)
        return if (file.exists()) {
            file.absolutePath
        } else {
            null
        }
    }
}