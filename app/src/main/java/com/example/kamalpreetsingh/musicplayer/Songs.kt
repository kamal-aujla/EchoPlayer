package com.example.kamalpreetsingh.musicplayer

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by Kamalpreet singh on 13-06-2018.
 */
class Songs(var songID: Long,var songTitle: String,var artist: String,var songData: String,var dateAdded: Long): Parcelable {
    override fun writeToParcel(p0: Parcel?, p1: Int) {

    }
      override  fun describeContents(): Int {
            return 0
        }

    }
