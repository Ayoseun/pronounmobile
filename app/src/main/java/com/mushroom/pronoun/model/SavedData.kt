package com.mushroom.pronoun.model

import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.Task
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.ListResult
import com.google.firebase.storage.StorageReference
import java.io.File

class SavedData : AppCompatActivity() {


    fun checks() {

        val data2 = "Course"
        val folder = this.getExternalFilesDir("Pronoun")

        val z = File(folder, data2)

        if (!z.exists()) {
            z.mkdir()
        }
        val storageRef =
            FirebaseStorage.getInstance().reference.child("Pronoun/Management Sciences/International Relations department/100lvl/first semester")
        val listAllTask: Task<ListResult> = storageRef.listAll()
        listAllTask.addOnCompleteListener { result ->
            val items: List<StorageReference> = result.result!!.items
            //add cycle for add image url to list

            items.forEachIndexed { pos, item ->
                val name = item.name
                val localFile = File(z, name)
                item.getFile(localFile).addOnSuccessListener {

                }.addOnFailureListener {

                }

            }
        }
    }

    fun checks2(dept: String, level: String, semester: String) {
        val data = "Data"

        val folder = this.getExternalFilesDir("Pronoun")
        val f = File(folder, data)


        if (!f.exists()) {
            f.mkdir()
            val storageRef =
                FirebaseStorage.getInstance().reference.child("Pronoun/$dept/$level/$semester")
            val listAllTask: Task<ListResult> = storageRef.listAll()
            listAllTask.addOnCompleteListener { result ->
                val items: List<StorageReference> = result.result!!.items
                //add cycle for add image url to list

                items.forEachIndexed { pos, item ->
                    val name = item.name
                    val localFile = File(f, name)
                    item.getFile(localFile).addOnSuccessListener {

                    }.addOnFailureListener {

                    }

                }
            }
        }


    }


}