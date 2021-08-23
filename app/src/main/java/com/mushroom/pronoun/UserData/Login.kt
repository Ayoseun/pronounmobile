package com.mushroom.pronoun.UserData

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import at.favre.lib.crypto.bcrypt.BCrypt
import com.google.android.gms.tasks.Task
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.ListResult
import com.google.firebase.storage.StorageReference
import com.mushroom.pronoun.R
import com.mushroom.pronoun.model.SharedPreference
import com.mushroom.pronoun.model.pat
import com.mushroom.pronoun.view.landPage
import com.tapadoo.alerter.Alerter
import kotlinx.android.synthetic.main.fragment_login.*
import java.io.File
import java.util.*
import kotlin.concurrent.schedule


class login : Fragment() {

    var passPattern = pat().passPattern
    val sch = false
    lateinit var sharedPreference: SharedPreference
    var give: Int = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val view = inflater.inflate(R.layout.fragment_login, container, false)
        sharedPreference = SharedPreference(requireActivity())
        view?.findViewById<Button>(R.id.butLogin)?.setOnClickListener {
            shower.visibility = View.VISIBLE
            mat()
        }
        return view
    }

    fun mat() {
        val emInput = email.text.toString().trim()
        val pass = passwrdlogin.text.toString().trim()
        when {
            emInput.isEmpty() -> {
                Alerter.create(activity)
                    .setBackgroundColorRes(R.color.tint)
                    .setText("Input Email")
                    .setTitle("Sorry")
                    .show()
            }
            pass.isEmpty() -> {
                Alerter.create(activity)
                    .setBackgroundColorRes(R.color.tint)
                    .setText("Password cannot be empty")
                    .setTitle("Sorry")
                    .show()
            }
            !Patterns.EMAIL_ADDRESS.matcher(emInput).matches() -> {
                Alerter.create(activity)
                    .setBackgroundColorRes(R.color.tint)
                    .setText("Invalid Email")
                    .setTitle("Sorry")
                    .show()
            }

            /*!passPattern.matcher(pass).matches() -> {
                 Alerter.create(activity)
                     .setBackgroundColorRes(R.color.tint)
                     .setText("Invalid/Wrong Password")
                     .setTitle("Sorry")
                     .show()
                // Toast.makeText(activity, "password must contain alphabet,number,special character", Toast.LENGTH_SHORT).show()
             }*/
            else -> {
                val shave =
                    emInput.split("@".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()[0]
                Firebase.database.getReference("student/login/$shave")
                    .addValueEventListener(object : ValueEventListener {
                        override fun onCancelled(error: DatabaseError) {
                            Toast.makeText(activity,"Could not login",Toast.LENGTH_SHORT).show()
                        }

                        override fun onDataChange(snapshot: DataSnapshot) {
                            if (snapshot.exists()) {
                                val named = snapshot.child("name").value.toString()
                                val sursd = snapshot.child("surname").value.toString()
                                val coursesd =
                                    snapshot.child("course").value.toString()  //department
                                val lvlss = snapshot.child("grows").value.toString()  //level
                                val semS = snapshot.child("semester").value.toString()  //semester
                                val hash = snapshot.child("password").value.toString()
                                val result = BCrypt.verifyer().verify(pass.toCharArray(), hash)
                                if (result.verified) {

                                    val intent = Intent(activity, landPage::class.java)


                                    intent.putExtra("firstName", named)
                                    intent.putExtra("lastName", sursd)
                                    intent.putExtra("course", coursesd)
                                    intent.putExtra("level", lvlss)
                                    intent.putExtra("semester", semS)
                                    val data = "Data"
                                    //val data2 = "courses"
                                    val folder = activity!!.getExternalFilesDir("Pronoun")
                                    val f = File(folder, data)
                                    //val z = File(folder, data2)

                                    if (!f.exists()) {
                                        f.mkdir()
                                        //z.mkdir()
                                    }
                                    val storageRef =
                                        FirebaseStorage.getInstance().reference.child("/Pronoun/$coursesd/$lvlss/$semS")
                                    val listAllTask: Task<ListResult> = storageRef.listAll()
                                    listAllTask.addOnCompleteListener { result ->
                                        val items: List<StorageReference> = result.result!!.items
                                        //add cycle for add image url to list
                                        items.forEachIndexed { pos, item ->

                                            //gets the name of each item
                                            val name = item.name

                                            //downloads each item by their name
                                            val localFile = File(f, name)
                                            //save to folder

                                            item.getFile(localFile)
                                            //item.activeDownloadTasks.last()
                                            item.listAll().addOnCompleteListener {
                                               Timer().schedule(2000) {

                                                   startActivity(intent)
                                               }
                                            }




                                        }
                                    }
                                    sharedPreference.save(
                                        "num",
                                        2
                                    )  //this saves the number into the sharedpreferences so that user doesnt come here twice

                                    //startActivity(intent)
                                }
                            } else {

                                shower.visibility = View.GONE

                                Alerter.create(activity)
                                    .setBackgroundColorRes(R.color.fail)
                                    .setText("com.mushroom.pronoun.db.User $emInput not registered")
                                    .setTitle("Sorry")
                                    .show()
                            }
                        }
                    })


            }

        }


    }
}



