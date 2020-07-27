package com.example.testapplication.jobscheduler

import android.app.NotificationChannel
import android.app.job.JobParameters
import android.app.job.JobService
import android.os.Build
import androidx.annotation.RequiresApi
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.graphics.Color
import android.os.AsyncTask
import android.widget.Toast
import androidx.core.app.NotificationCompat
import com.example.testapplication.R


@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
class NotificationJobService : JobService() {
    // Notification channel ID.
    private val PRIMARY_CHANNEL_ID = "primary_notification_channel"
    // Notification manager.
    lateinit var mNotifyManager: NotificationManager
    private var isTaskCompleted = false

    /**
     * Called by the system once it determines it is time to run the job.
     *
     * @param jobParameters Contains the information about the job.
     * @return Boolean indicating whether or not the job was offloaded to a
     * separate thread.
     * In this case, it is false since the notification can be posted on
     * the main thread.
     */
    override fun onStartJob(p0: JobParameters?): Boolean {
        // Create the notification channel.
        createNotificationChannel();

        // Set up the notification content intent to launch the app when
        // clicked.

        var contentPendingIntent = PendingIntent.getActivity(
            this, 0,
            Intent(this, NotificationJobActivity::class.java),
            PendingIntent.FLAG_UPDATE_CURRENT
        )

        var builder = NotificationCompat.Builder(this, PRIMARY_CHANNEL_ID)
            .setContentTitle(getString(R.string.job_service))
            .setContentText(getString(R.string.job_running))
            .setContentIntent(contentPendingIntent)
            .setSmallIcon(R.drawable.ic_job_running)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setDefaults(NotificationCompat.DEFAULT_ALL)
            .setAutoCancel(true);

        mNotifyManager.notify(0, builder.build());

        JobTask()

        return false;
    }

    /**
     * Called by the system when the job is running but the conditions are no
     * longer met.
     * In this example it is never called since the job is not offloaded to a
     * different thread.
     *
     * @param jobParameters Contains the information about the job.
     * @return Boolean indicating whether the job needs rescheduling.
     */
    override fun onStopJob(p0: JobParameters?): Boolean {
        if(!isTaskCompleted) {
            Toast.makeText(applicationContext, "Job failed!", Toast.LENGTH_SHORT).show()
            return true
        }
        return false
    }

    /**
     * Creates a Notification channel, for OREO and higher.
     */
    fun createNotificationChannel() {

        // Create a notification manager object.
        mNotifyManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        // Notification channels are only available in OREO and higher.
        // So, add a check on SDK version.
        if (android.os.Build.VERSION.SDK_INT >=
            android.os.Build.VERSION_CODES.O
        ) {

            // Create the NotificationChannel with all the parameters.
            var notificationChannel = NotificationChannel(
                PRIMARY_CHANNEL_ID,
                getString(R.string.job_service_notification),
                NotificationManager.IMPORTANCE_HIGH
            )

            notificationChannel.enableLights(true)
            notificationChannel.setLightColor(Color.RED)
            notificationChannel.enableVibration(true)
            notificationChannel.description =
                (getString(R.string.notification_channel_description))

            mNotifyManager.createNotificationChannel(notificationChannel)
        }
    }

    inner class JobTask() : AsyncTask<Void, Void, Void>(){

        override fun doInBackground(vararg p0: Void?): Void? {
            Thread.sleep(5000)
            isTaskCompleted = true
            return null
        }

    }

}