package com.example.myapplication.data.entities

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

@Entity(tableName = "user")
data class User(
    @PrimaryKey
    @SerializedName("id")
    @Expose
    var id: Int? = null
) : Parcelable {

    @ColumnInfo
    @SerializedName("email")
    @Expose
    var email: String? = null

    @ColumnInfo
    @SerializedName("first_name")
    @Expose
    var firstName: String? = null

    @ColumnInfo
    @SerializedName("last_name")
    @Expose
    var lastName: String? = null

    @ColumnInfo
    @SerializedName("avatar")
    @Expose
    var avatar: String? = null

    constructor(parcel: Parcel) : this() {
        id = parcel.readValue(Int::class.java.classLoader) as? Int
        email = parcel.readString()
        firstName = parcel.readString()
        lastName = parcel.readString()
        avatar = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeString(email)
        parcel.writeString(firstName)
        parcel.writeString(lastName)
        parcel.writeString(avatar)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }
}