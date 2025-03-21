package com.example.team_up

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.zegocloud.uikit.prebuilt.videoconference.ZegoUIKitPrebuiltVideoConferenceConfig
import com.zegocloud.uikit.prebuilt.videoconference.ZegoUIKitPrebuiltVideoConferenceFragment
import kotlin.random.Random

class conference_screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conference_screen)
        appconferencescreen()
    }
    private fun appconferencescreen() {
        val appId: Long = 773722181
        val appSign: String = "9168370bf54abdcd5bdb4b5df2d755079471c54091586eee002005f1f9acdb7c"
        val conferenceId = "test_conference_id"
        val userID = generateUserID()
        val  userName = "${userID}_Name"
        val  config = ZegoUIKitPrebuiltVideoConferenceConfig()
        val  fragment = ZegoUIKitPrebuiltVideoConferenceFragment.newInstance(
            appId,appSign,userName,userID,conferenceId,config
        )
        supportFragmentManager.beginTransaction().replace(R.id.conferenceLayout,fragment).commitNow()
    }

    private fun generateUserID(): String{
        val builder = StringBuilder()
        val  random = java.util.Random ()
        while (builder.length<5){
            val nextline= random.nextInt(10)
            if (builder.length==0 && nextline==0){
                continue
            }
            builder.append(nextline)
        }
        return builder.toString()
    }
}