package com.chukimmuoi.stockvn.presentation.screen.stockprice.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import com.chukimmuoi.stockvn.R

/**
 * @author: My Project
 * @Skype: chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email: chukimmuoi@gmail.com
 * @Website: https://github.com/chukimmuoi
 * @Project: StockVN
 * Created by chukimmuoi on 12/11/2022.
 */

private const val SyncNotificationId = 0
private const val SyncNotificationChannelID = "SyncNotificationChannel"

/**
 * Notification displayed on lower API levels when sync workers are being
 * run with a foreground service
 */
fun Context.syncWorkNotification() {
    // Register the channel with the system
    val notificationManager: NotificationManager? =
        getSystemService(Context.NOTIFICATION_SERVICE) as? NotificationManager

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val channel = NotificationChannel(
            SyncNotificationChannelID,
            getString(R.string.sync),
            NotificationManager.IMPORTANCE_DEFAULT
        ).apply {
            description = getString(R.string.sync_notification_channel_description)
        }

        notificationManager?.createNotificationChannel(channel)
    }

    val notification = NotificationCompat.Builder(
        this,
        SyncNotificationChannelID
    )
        .setSmallIcon(
            R.drawable.ic_stock_vn
        )
        .setContentTitle(getString(R.string.app_name))
        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
        .build()

    notificationManager?.notify(SyncNotificationId, notification)
}