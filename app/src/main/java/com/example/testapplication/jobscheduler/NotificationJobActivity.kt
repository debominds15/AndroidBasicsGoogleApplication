package com.example.testapplication.jobscheduler

import android.annotation.TargetApi
import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.testapplication.R

class NotificationJobActivity : AppCompatActivity() {
    private var JOB_ID = 0
    private lateinit var mScheduler: JobScheduler
    private lateinit var mDeviceIdleSwitch: Switch
    private lateinit var mDeviceChargingSwitch: Switch

    private lateinit var mSeekBar: SeekBar

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_job_notification)

        mDeviceIdleSwitch = findViewById(R.id.idleSwitch);
        mDeviceChargingSwitch = findViewById(R.id.chargingSwitch);
        mSeekBar = findViewById(R.id.seekBar);

        var seekBarProgress: TextView = findViewById(R.id.seekBarProgress);

        mScheduler = getSystemService(JOB_SCHEDULER_SERVICE) as JobScheduler

        mSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, i: Int, p2: Boolean) {
                if (i > 0) {
                    seekBarProgress.text = getString(R.string.seconds, i)
                } else {
                    seekBarProgress.text = getString(R.string.not_set)
                }
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        })
    }

    /**
     * onClick method that schedules the jobs based on the parameters set.
     */
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun scheduleJob(view: View){
        var networkOptions: RadioGroup = findViewById(R.id.networkOptions)
        var selectedNetworkID = networkOptions.checkedRadioButtonId
        var selectedNetworkOption = JobInfo.NETWORK_TYPE_NONE

        var seekBarInteger = mSeekBar.progress
        var seekBarSet = seekBarInteger > 0

        when(selectedNetworkID){
            R.id.noNetwork -> selectedNetworkOption = JobInfo.NETWORK_TYPE_NONE
            R.id.anyNetwork -> selectedNetworkOption = JobInfo.NETWORK_TYPE_ANY
            R.id.wifiNetwork -> selectedNetworkOption = JobInfo.NETWORK_TYPE_UNMETERED

        }

        var serviceName = ComponentName(packageName,
            NotificationJobService :: class.qualifiedName.toString()
        )

        var builder = JobInfo.Builder(JOB_ID, serviceName)
            .setRequiredNetworkType(selectedNetworkOption)
            .setRequiresDeviceIdle(mDeviceIdleSwitch.isChecked)
            .setRequiresCharging(mDeviceChargingSwitch.isChecked)

        if(seekBarSet){
            builder.setOverrideDeadline(seekBarInteger.toLong() * 1000)
        }

        var constraintSet = selectedNetworkOption!= JobInfo.NETWORK_TYPE_NONE
                || mDeviceChargingSwitch.isChecked
                || mDeviceIdleSwitch.isChecked
                || seekBarSet

        if (constraintSet) {
            var myJobInfo = builder.build()
            mScheduler.schedule(myJobInfo)
            Toast.makeText(this, R.string.job_scheduled, Toast.LENGTH_SHORT)
                .show()
        } else {
            Toast.makeText(this, R.string.no_constraint_toast,
                Toast.LENGTH_SHORT).show()
        }
    }

    /**
     * onClick method for cancelling all existing jobs.
     */
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun cancelJobs(view: View) {

        if (mScheduler != null) {
            mScheduler.cancelAll();
            //mScheduler = null;
            Toast.makeText(this, R.string.jobs_canceled, Toast.LENGTH_SHORT)
                .show();
        }
    }
}