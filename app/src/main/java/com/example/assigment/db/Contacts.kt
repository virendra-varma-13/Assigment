package com.example.assigment.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
class Contacts : Serializable {
    @PrimaryKey(autoGenerate = true)
    public var id = 0

    @ColumnInfo(name = "contactNo")
    public var contactNo: String? = null

    @ColumnInfo(name = "contactType")
    public var contactType: String? = null

    @ColumnInfo(name = "contactName")
    public var contactName: String? = null


}