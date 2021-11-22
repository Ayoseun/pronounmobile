package com.mushroom.pronoun.UserData

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import at.favre.lib.crypto.bcrypt.BCrypt
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.ListResult
import com.google.firebase.storage.StorageReference
import com.mushroom.pronoun.Forgot_Activity
import com.mushroom.pronoun.R
import com.mushroom.pronoun.model.SharedPreference
import com.mushroom.pronoun.model.pat
import com.mushroom.pronoun.view.LoginSignupActivity
import com.mushroom.pronoun.view.landPage
import com.tapadoo.alerter.Alerter
import kotlinx.android.synthetic.main.fragment_login.*
import java.io.File
import java.util.*
import kotlin.concurrent.schedule


class login : Fragment() {
    private lateinit var auth: FirebaseAuth
    private lateinit var databaseReference: DatabaseReference
    private lateinit var database: FirebaseDatabase
    val showFragment = LoginSignupActivity()
    var passPattern = pat().passPattern
    val sch = false
    lateinit var sharedPreference: SharedPreference
    var give: Int = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        auth = Firebase.auth
        database = FirebaseDatabase.getInstance()
        val view = inflater.inflate(R.layout.fragment_login, container, false)
        sharedPreference = SharedPreference(requireActivity())

        view?.findViewById<TextView>(R.id.forgotPassword)?.setOnClickListener {
            val intent = Intent(activity, Forgot_Activity::class.java)
            startActivity(intent)
        }
        view?.findViewById<Button>(R.id.butLogin)?.setOnClickListener {
            shower.visibility = View.VISIBLE
            login()
        }
        return view
    }

    fun login() {
        val emInput = email_login.text.toString().trim()
        val pass = passwrdlogin.text.toString().trim()


        if (TextUtils.isEmpty(email_login?.text.toString())) {
            email_login?.error = "You must enter an email"

            if (TextUtils.isEmpty(passwrdlogin?.text.toString())) {
                passwrdlogin?.error = "enter surname"


            }
        } else {
            val user =
                emInput.split("@".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()[0]
            auth.signInWithEmailAndPassword(emInput,pass).addOnCompleteListener {
                if(it.isSuccessful){
                    savedLogin(user,emInput,pass)
                }else{
                    Toast.makeText(requireContext(),"$emInput does not exist",Toast.LENGTH_SHORT).show()
                }
            }




        }

    }


    fun savedLogin(user: String, emInput: String, pass: String) {

        Firebase.database.getReference("student/login/$user")
            .addValueEventListener(object : ValueEventListener {
                override fun onCancelled(error: DatabaseError) {
                    Toast.makeText(activity, "Could not login", Toast.LENGTH_SHORT).show()
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
                            val tasks = storageRef.activeDownloadTasks

                            if (tasks.size > 0) {
                                for (i in 0 until tasks.size){
                                    Toast.makeText(requireContext(),
                                        "$i does not exist",Toast.LENGTH_SHORT).show()
                                }
                                // Get the task monitoring the download


                            }

                            val listAllTask: Task<ListResult> = storageRef.listAll()
                            listAllTask.addOnCompleteListener { result ->
                                val items: List<StorageReference> = result.result!!.items
                                //add cycle for add image url to list
                                items.forEachIndexed { pos, item ->

                                    //gets the name of each item
                                    val name = item.name
                                   Toast.makeText(requireContext(),
                                        "downloading files",Toast.LENGTH_SHORT).show()
                                    //downloads each item by their name
                                    val localFile = File(f, name)
                                    //save to folder

                                    item.getFile(localFile)
                                    //item.activeDownloadTasks.last()
                                    item.listAll().addOnCompleteListener {
                                        Timer().schedule(4000) {

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
                     else {

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







