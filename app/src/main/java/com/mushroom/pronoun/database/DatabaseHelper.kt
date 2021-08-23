package com.mushroom.pronoun.database

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.SQLException
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.mushroom.pronoun.model.StudentModel


class DatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, VERSION_CODE) {

    companion object {
        const val DATABASE_NAME = "student.db"
        const val VERSION_CODE = 1
        const val TABLE_NAME = "student_table"
        const val columns_pq = "pq"
        const val columns_pq2 = "pq2"
        const val columns_pq3 = "pq3"
        const val columns_pq4 = "pq4"
        const val columns_pq5 = "pq5"
        const val columns_pq6 = "pq6"
        const val columns_pq7 = "pq7"
        const val columns_pq8 = "pq8"
        const val columns_pq9 = "pq9"
        const val columns_pq10 = "pq10"
        const val columns_pq11 = "pq11"
        const val columns_pq12 = "pq12"
        const val columns_pq13 = "pq13"
        const val columns_pq14 = "pq14"
        const val columns_pq15 = "pq15"
        const val columns_pq02 = "pq02"
        const val columns_pq03 = "pq03"
        const val columns_pq04 = "pq04"
        const val columns_pq05 = "pq05"
        const val columns_pq06 = "pq06"
        const val columns_pq07 = "pq07"
        const val columns_pq08 = "pq08"
        const val columns_pq09 = "pq09"
        const val columns_pq010 = "pq010"
        const val columns_pq011 = "pq011"
        const val columns_pq012 = "pq012"
        const val columns_pq013 = "pq013"
        const val columns_pq014 = "pq014"
        const val columns_pq015 = "pq015"
        const val columns_ID = "_id"
        const val columns_pq01 = "pq01"
    }


    override fun onCreate(db: SQLiteDatabase?) {
        val createQuery =
            "create table $TABLE_NAME($columns_ID INTEGER PRIMARY KEY AUTOINCREMENT,$columns_pq TEXT NOT NULL,$columns_pq2 TEXT NOT NULL,$columns_pq3 TEXT NOT NULL,$columns_pq4 TEXT NOT NULL,$columns_pq5 TEXT NOT NULL,$columns_pq6 TEXT NOT NULL,$columns_pq7 TEXT NOT NULL,$columns_pq8 TEXT NOT NULL,$columns_pq9 TEXT NOT NULL,$columns_pq10 TEXT NOT NULL,$columns_pq11 TEXT NOT NULL,$columns_pq12 TEXT NOT NULL,$columns_pq13 TEXT NOT NULL,$columns_pq14 TEXT NOT NULL,$columns_pq15 TEXT NOT NULL,$columns_pq02 TEXT NOT NULL,$columns_pq03 TEXT NOT NULL,$columns_pq04 TEXT NOT NULL,$columns_pq05 TEXT NOT NULL,$columns_pq06 TEXT NOT NULL,$columns_pq07 TEXT NOT NULL,$columns_pq08 TEXT NOT NULL,$columns_pq09 TEXT NOT NULL,$columns_pq010 TEXT NOT NULL,$columns_pq011 TEXT NOT NULL,$columns_pq012 TEXT NOT NULL,$columns_pq013 TEXT NOT NULL,$columns_pq014 TEXT NOT NULL,$columns_pq015 TEXT NOT NULL,$columns_pq01 TEXT NOT NULL);"
        db?.execSQL(createQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun insertData(name: String, email: String) {
        val db = writableDatabase
        val cv = ContentValues()

        cv.put(columns_pq, name)
        cv.put(columns_pq01, email)
        db.insert(TABLE_NAME, null, cv)
        Log.d("INSERTED", "DATA_INSERTED")
    }

    fun insertData2(name: String, email: String) {
        val db = writableDatabase
        val cv = ContentValues()

        cv.put(columns_pq2, name)
        cv.put(columns_pq02, email)
        db.insert(TABLE_NAME, null, cv)
        Log.d("INSERTED", "DATA_INSERTED")
    }
    fun insertData3(name: String, email: String) {
        val db = writableDatabase
        val cv = ContentValues()

        cv.put(columns_pq3, name)
        cv.put(columns_pq03, email)
        db.insert(TABLE_NAME, null, cv)
        Log.d("INSERTED", "DATA_INSERTED")
    }
    fun insertData4(name: String, email: String) {
        val db = writableDatabase
        val cv = ContentValues()

        cv.put(columns_pq4, name)
        cv.put(columns_pq04, email)
        db.insert(TABLE_NAME, null, cv)
        Log.d("INSERTED", "DATA_INSERTED")
    }
    fun insertData5(name: String, email: String) {
        val db = writableDatabase
        val cv = ContentValues()

        cv.put(columns_pq5, name)
        cv.put(columns_pq05, email)
        db.insert(TABLE_NAME, null, cv)
        Log.d("INSERTED", "DATA_INSERTED")
    }
    fun insertData6(name: String, email: String) {
        val db = writableDatabase
        val cv = ContentValues()

        cv.put(columns_pq6, name)
        cv.put(columns_pq06, email)
        db.insert(TABLE_NAME, null, cv)
        Log.d("INSERTED", "DATA_INSERTED")
    }
    fun insertData7(name: String, email: String) {
        val db = writableDatabase
        val cv = ContentValues()

        cv.put(columns_pq7, name)
        cv.put(columns_pq07, email)
        db.insert(TABLE_NAME, null, cv)
        Log.d("INSERTED", "DATA_INSERTED")
    }
    fun insertData8(name: String, email: String) {
        val db = writableDatabase
        val cv = ContentValues()

        cv.put(columns_pq8, name)
        cv.put(columns_pq08, email)
        db.insert(TABLE_NAME, null, cv)
        Log.d("INSERTED", "DATA_INSERTED")
    }
    fun insertData9(name: String, email: String) {
        val db = writableDatabase
        val cv = ContentValues()

        cv.put(columns_pq9, name)
        cv.put(columns_pq09, email)
        db.insert(TABLE_NAME, null, cv)
        Log.d("INSERTED", "DATA_INSERTED")
    }
    fun insertData10(name: String, email: String) {
        val db = writableDatabase
        val cv = ContentValues()

        cv.put(columns_pq10, name)
        cv.put(columns_pq010, email)
        db.insert(TABLE_NAME, null, cv)
        Log.d("INSERTED", "DATA_INSERTED")
    }
    fun insertData11(name: String, email: String) {
        val db = writableDatabase
        val cv = ContentValues()

        cv.put(columns_pq11, name)
        cv.put(columns_pq011, email)
        db.insert(TABLE_NAME, null, cv)
        Log.d("INSERTED", "DATA_INSERTED")
    }
    fun insertData12(name: String, email: String) {
        val db = writableDatabase
        val cv = ContentValues()

        cv.put(columns_pq12, name)
        cv.put(columns_pq012, email)
        db.insert(TABLE_NAME, null, cv)
        Log.d("INSERTED", "DATA_INSERTED")
    }
    fun insertData13(name: String, email: String) {
        val db = writableDatabase
        val cv = ContentValues()

        cv.put(columns_pq13, name)
        cv.put(columns_pq013, email)
        db.insert(TABLE_NAME, null, cv)
        Log.d("INSERTED", "DATA_INSERTED")
    }
    fun insertData14(name: String, email: String) {
        val db = writableDatabase
        val cv = ContentValues()

        cv.put(columns_pq14, name)
        cv.put(columns_pq014, email)
        db.insert(TABLE_NAME, null, cv)
        Log.d("INSERTED", "DATA_INSERTED")
    }
    fun insertData15(name: String, email: String) {
        val db = writableDatabase
        val cv = ContentValues()

        cv.put(columns_pq15, name)
        cv.put(columns_pq015, email)
        db.insert(TABLE_NAME, null, cv)
        Log.d("INSERTED", "DATA_INSERTED")
    }

    fun getData(): Cursor? {
        val db = readableDatabase
        var cursor: Cursor? = null
        val selectQuery = "select * from $TABLE_NAME"
        try {
            cursor = db.rawQuery(selectQuery, null)
        } catch (e: SQLException) {
            db.execSQL(selectQuery)
        }
        return cursor
    }

    fun updateData(id: Int, name: String, email: String): Boolean {
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(columns_ID, id)
        cv.put(columns_pq, name)
        cv.put(columns_pq01, email)
        db.update(TABLE_NAME, cv, "$columns_ID = ?", arrayOf(id.toString()))
        Log.d("UPDATED", "DATA_INSERTED")
        db.close()
        return true
    }


    fun updateData2(id: Int, name: String, email: String): Boolean {
        val db = this.writableDatabase
        val cv = ContentValues()

        cv.put(columns_pq2, name)
        cv.put(columns_pq02, email)
        cv.put(columns_ID, id)
        db.update(TABLE_NAME, cv, "$columns_ID = ?", arrayOf(id.toString()))
        Log.d("UPDATED", "DATA_INSERTED")
        db.close()
        return true
    }
    fun updateData3(id: Int, name: String, email: String): Boolean {
        val db = writableDatabase
        val cv = ContentValues()

        cv.put(columns_pq3, name)
        cv.put(columns_pq03, email)
        cv.put(columns_ID, id)
        db.update(TABLE_NAME, cv, "$columns_ID = ?", arrayOf(id.toString()))
        Log.d("UPDATED", "DATA_INSERTED")
        db.close()
        return true
    }
    fun updateData4(id: Int, name: String, email: String): Boolean {
        val db = writableDatabase
        val cv = ContentValues()

        cv.put(columns_pq4, name)
        cv.put(columns_pq04, email)
        cv.put(columns_ID, id)
        db.update(TABLE_NAME, cv, "$columns_ID = ?", arrayOf(id.toString()))
        Log.d("UPDATED", "DATA_INSERTED")
        db.close()
        return true
    }
    fun updateData5(id: Int, name: String, email: String): Boolean{
        val db = writableDatabase
        val cv = ContentValues()

        cv.put(columns_pq5, name)
        cv.put(columns_pq05, email)
        cv.put(columns_ID, id)
        db.update(TABLE_NAME, cv, "$columns_ID = ?", arrayOf(id.toString()))
        Log.d("UPDATED", "DATA_INSERTED")
        db.close()
        return true
    }
    fun updateData6(id: Int, name: String, email: String): Boolean {
        val db = writableDatabase
        val cv = ContentValues()

        cv.put(columns_pq6, name)
        cv.put(columns_pq06, email)
        cv.put(columns_ID, id)
        db.update(TABLE_NAME, cv, "$columns_ID = ?", arrayOf(id.toString()))
        Log.d("UPDATED", "DATA_INSERTED")
        db.close()
        return true
    }
    fun updateData7(id: Int, name: String, email: String): Boolean{
        val db = writableDatabase
        val cv = ContentValues()

        cv.put(columns_pq7, name)
        cv.put(columns_pq07, email)
        cv.put(columns_ID, id)
        db.update(TABLE_NAME, cv, "$columns_ID = ?", arrayOf(id.toString()))
        Log.d("UPDATED", "DATA_INSERTED")
        db.close()
        return true
    }
    fun updateData8(id: Int, name: String, email: String): Boolean {
        val db = writableDatabase
        val cv = ContentValues()

        cv.put(columns_pq8, name)
        cv.put(columns_pq08, email)
        cv.put(columns_ID, id)
        db.update(TABLE_NAME, cv, "$columns_ID = ?", arrayOf(id.toString()))
        Log.d("UPDATED", "DATA_INSERTED")
        db.close()
        return true
    }
    fun updateData9(id: Int, name: String, email: String): Boolean {
        val db = writableDatabase
        val cv = ContentValues()

        cv.put(columns_pq9, name)
        cv.put(columns_pq09, email)
        cv.put(columns_ID, id)
        db.update(TABLE_NAME, cv, "$columns_ID = ?", arrayOf(id.toString()))
        Log.d("UPDATED", "DATA_INSERTED")
        db.close()
        return true
    }
    fun updateData10(id: Int, name: String, email: String): Boolean{
        val db = writableDatabase
        val cv = ContentValues()

        cv.put(columns_pq10, name)
        cv.put(columns_pq010, email)
        cv.put(columns_ID, id)
        db.update(TABLE_NAME, cv, "$columns_ID = ?", arrayOf(id.toString()))
        Log.d("UPDATED", "DATA_INSERTED")
        db.close()
        return true
    }
    fun updateData11(id: Int, name: String, email: String): Boolean{
        val db = writableDatabase
        val cv = ContentValues()

        cv.put(columns_pq11, name)
        cv.put(columns_pq011, email)
        cv.put(columns_ID, id)
        db.update(TABLE_NAME, cv, "$columns_ID = ?", arrayOf(id.toString()))
        Log.d("UPDATED", "DATA_INSERTED")
        db.close()
        return true
    }
    fun updateData12(id: Int, name: String, email: String): Boolean{
        val db = writableDatabase
        val cv = ContentValues()

        cv.put(columns_pq12, name)
        cv.put(columns_pq012, email)
        cv.put(columns_ID, id)
        db.update(TABLE_NAME, cv, "$columns_ID = ?", arrayOf(id.toString()))
        Log.d("UPDATED", "DATA_INSERTED")
        db.close()
        return true
    }
    fun updateData13(id: Int, name: String, email: String): Boolean {
        val db = writableDatabase
        val cv = ContentValues()

        cv.put(columns_pq13, name)
        cv.put(columns_pq013, email)
        cv.put(columns_ID, id)
        db.update(TABLE_NAME, cv, "$columns_ID = ?", arrayOf(id.toString()))
        Log.d("UPDATED", "DATA_INSERTED")
        db.close()
        return true
    }
    fun updateData14(id: Int, name: String, email: String): Boolean{
        val db = writableDatabase
        val cv = ContentValues()

        cv.put(columns_pq14, name)
        cv.put(columns_pq014, email)
        cv.put(columns_ID, id)
        db.update(TABLE_NAME, cv, "$columns_ID = ?", arrayOf(id.toString()))
        Log.d("UPDATED", "DATA_INSERTED")
        db.close()
        return true
    }
    fun updateData15(id: Int, name: String, email: String): Boolean{
        val db = writableDatabase
        val cv = ContentValues()

        cv.put(columns_pq15, name)
        cv.put(columns_pq015, email)
        cv.put(columns_ID, id)
        db.update(TABLE_NAME, cv, "$columns_ID = ?", arrayOf(id.toString()))
        Log.d("UPDATED", "DATA_INSERTED")
        db.close()
        return true
    }

    fun delete(id: String): Int {
        val db = this.writableDatabase
        return db.delete(TABLE_NAME, "$columns_ID = ?", arrayOf(id))
    }

}