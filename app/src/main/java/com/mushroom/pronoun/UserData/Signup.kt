package com.mushroom.pronoun.UserData

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.ListResult
import com.google.firebase.storage.StorageReference
import com.mushroom.pronoun.R
import com.mushroom.pronoun.firebase.firebasedata
import com.mushroom.pronoun.model.Constants
import com.mushroom.pronoun.model.SharedPreference
import com.mushroom.pronoun.model.pat
import com.mushroom.pronoun.view.landPage
import kotlinx.android.synthetic.main.fragment_signup.*
import java.io.File
import java.util.*
import kotlin.concurrent.schedule


class signup : Fragment() {

    private lateinit var auth: FirebaseAuth
    private lateinit var databaseReference: DatabaseReference
    private lateinit var database: FirebaseDatabase
    var email: EditText? = null
    var pass: EditText? = null
    var conpass: EditText? = null
    var phone: EditText? = null
    var passPattern = pat().passPattern
    var Ch = "com"
    var ch_name = "stop"
    var name: EditText? = null
    var depts: AutoCompleteTextView? = null
    var surName: EditText? = null
    private var grow: String? = null
    private var semester: String? = null
    var lvl1: Button? = null
    var lvl2: Button? = null

    //shared preference for one-time login
    lateinit var sharedPreference: SharedPreference
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        auth = Firebase.auth
        database = FirebaseDatabase.getInstance()

        val view = inflater.inflate(R.layout.fragment_signup, container, false)
        val registerButton = view.findViewById<Button>(R.id.register)
        lvl1 = view.findViewById(R.id.lvl)
        lvl2 = view.findViewById(R.id.lvl2)
        email = view.findViewById<EditText>(R.id.emailer)
        pass = view.findViewById<EditText>(R.id.conpasscord)
        name = view.findViewById<EditText>(R.id.name)
        surName = view.findViewById<EditText>(R.id.surname)
        phone = view.findViewById<EditText>(R.id.phoner)
        sharedPreference = SharedPreference(requireActivity())

        //Autocomplete button
        depts = view.findViewById(R.id.dept)
        clicks()

        //autocomplete adapter
        val arrayAdapter =
            activity?.let {
                ArrayAdapter<String>(
                    it, android.R.layout.simple_list_item_1,
                    Constants.spell
                )
            }
        depts!!.setAdapter(arrayAdapter)

        registerButton.setOnClickListener {
            val pattern = depts?.text.toString().toRegex()
            Constants.spell.forEach { spells ->
                if (pattern.containsMatchIn(spells)) {
                    Toast.makeText(activity, " worketh", Toast.LENGTH_SHORT).show()
                    registerData()

                }

            }

        }
        return view
    }

    fun registerData() {


        if (TextUtils.isEmpty(email?.text.toString())) {
            email?.error = "You must enter an email"

            if (TextUtils.isEmpty(surname?.text.toString())) {
                surName?.error = "enter surname"

                if (TextUtils.isEmpty(phoner.text.toString())) {
                    phone?.error = "enter your phone"
                    if (pass?.text.toString().length <= 6) {
                        pass!!.error = "password must be up to 6 characters";
                        if (passcord?.text.toString().length <= 6 ) {
                            passcord!!.error = "password must be up to 6 characters";

                            if (TextUtils.isEmpty(pass?.text.toString())) {
                                conpass?.error = "You must enter a pasword"

                                if (TextUtils.isEmpty(passcord?.text.toString())) {
                                    pass?.error = "You must enter a pasword"

                                    if (TextUtils.isEmpty(name?.text.toString())) {
                                        name?.error = "enter your name"
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } else {


            auth.createUserWithEmailAndPassword(
                email?.text.toString(),
                pass?.text.toString()

            )

                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        saveToDatabase(
                            email?.text.toString(),
                            phoner.text.toString(),
                            name?.text.toString(),
                            depts?.text.toString(),
                            surName?.text.toString(),
                            semester.toString()
                        )
                        Toast.makeText(requireContext(), "done", Toast.LENGTH_SHORT)
                            .show()
                        // saveToDatabase(email?.text.toString(),phone?.text.toString(),name?.text.toString(),depts.toString(),surName?.text.toString(),semester.toString())
                    }
                }

        }
    }


    fun saveToDatabase(
        userEmail: String,
        tel: String,
        nom: String,
        rai: String,
        surs: String,
        sismesta: String
    ) {
        getLevel()


        val data = firebasedata(userEmail, tel, nom, surs, rai, grow!!, sismesta)
         // save data into firebase
        val get_id =
            userEmail.split("@".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()[0]


        Firebase.database.getReference("student/login/$get_id")
            .addValueEventListener(object : ValueEventListener {
                override fun onCancelled(error: DatabaseError) {
                    Toast.makeText(activity, "Could not Sign up", Toast.LENGTH_SHORT).show()
                }

                override fun onDataChange(snapshot: DataSnapshot) {
                    if (snapshot.exists()) {
                        Toast.makeText(
                            activity,
                            "User already registered,Logging instead",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        FirebaseDatabase.getInstance().getReference("student/login/$get_id")
                            .setValue(data)
                            .addOnSuccessListener {


                                val data: String = "Data"
                                //val data2 = "courses"
                                val folder = activity!!.getExternalFilesDir("Pronoun")
                                val f = File(folder, data)
                                //val z = File(folder, data2)

                                if (!f.exists()) {
                                    f.mkdir()
                                    //z.mkdir()
                                }
                                val storageRef =
                                    FirebaseStorage.getInstance().reference.child("/Pronoun/$rai/$grow/$semester")
                                val listAllTask: Task<ListResult> = storageRef.listAll()


                                listAllTask.addOnCompleteListener { result ->
                                    val items: List<StorageReference> =
                                        result.result!!.items
                                    //add cycle for add image url to list
                                    items.forEachIndexed { _, item ->

                                        //gets the name of each item
                                        val name = item.name

                                        // Get the task monitoring the download


                                        //downloads each item by their name
                                        val localFile = File(f, name)
                                        //save to folder

                                        item.getFile(localFile)
                                        val intent = Intent(activity, landPage::class.java)

                                        intent.putExtra("firstName", nom) //name
                                        intent.putExtra("lastName", surs)  //surname
                                        intent.putExtra("course", rai)   //department
                                        intent.putExtra("level", grow)  // level
                                        intent.putExtra("semester", semester!!)  //semester

                                        //item.activeDownloadTasks.last()
                                        item.listAll().addOnCompleteListener {
                                            Timer().schedule(2000) {
                                                startActivity(intent)
                                                requireActivity().finish()
                                                sharedPreference.save(
                                                    "num",
                                                    2
                                                )  //this saves the number into the sharedpreferences so that user doesnt come here twice



                                            }
                                        }
                                    }
                                }
                            }
                            .addOnFailureListener { ex: Exception ->
                                Log.d("TAG", ex.toString())
                                Toast.makeText(
                                    requireActivity(),
                                    "failed to Sign up",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }

                    }
                }
            })


    }

    //check student department function
    fun getLevel() {


//check if department picked matches database


    }
//end of check student department function [end]


    //[start] select student level button
    fun clicks() {

        lvl1?.setOnClickListener {
            val popMenu = PopupMenu(requireContext(), lvl)
            popMenu.menuInflater.inflate(R.menu.menu_pop, popMenu.menu)
            popMenu.setOnMenuItemClickListener { position ->
                when (position.itemId) {
                    R.id.hun -> {
                        lvl1?.setTextColor(resources.getColor(R.color.dead_green))

                        grow = "Lv100"
                        lvl1!!.text = grow
                    }
                    R.id.Thun -> {
                        lvl1?.setTextColor(resources.getColor(R.color.dead_green))
                        grow = "Lv200"


                        lvl1!!.text = grow
                    }

                }
                true
            }
            popMenu.show()
        }
//end of select student button [end]


        //[start] select student semester button
        lvl2?.setOnClickListener {
            val popMenu = PopupMenu(requireContext(), lvl2)
            popMenu.menuInflater.inflate(R.menu.menu_pop2, popMenu.menu)
            popMenu.setOnMenuItemClickListener { position ->
                when (position.itemId) {
                    R.id.first -> {
                        lvl2?.setTextColor(resources.getColor(R.color.dead_green))
                        semester = "1st Semester"
                        lvl2!!.text = semester
                    }
                    R.id.second -> {
                        lvl2?.setTextColor(resources.getColor(R.color.dead_green))
                        semester = "2nd Semester"
                        lvl2!!.text = semester
                    }

                }
                true
            }
            popMenu.show()
        }
    }
}