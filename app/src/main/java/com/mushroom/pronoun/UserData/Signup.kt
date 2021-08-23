package com.mushroom.pronoun.UserData

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import at.favre.lib.crypto.bcrypt.BCrypt
import com.google.android.gms.tasks.Task
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
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
import com.tapadoo.alerter.Alerter
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_signup.*
import java.io.File
import java.util.*
import kotlin.concurrent.schedule


class signup : Fragment() {
    //shared preference for one-time login
    lateinit var sharedPreference: SharedPreference

//ends


    var passPattern = pat().passPattern


    var Ch = "com"
    var ch_name = "stop"
    lateinit var name: EditText
    lateinit var Surname: EditText
    private var grow: String? = null
    private var semester: String? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        sharedPreference = SharedPreference(requireActivity())
        val view = inflater.inflate(R.layout.fragment_signup, container, false)


        name = view.findViewById(R.id.name)
        Surname = view.findViewById(R.id.pasw2)


//Autocomplete button
        val dept = view?.findViewById<AutoCompleteTextView>(R.id.dept)!!


        //autocomplete adapter
        val arrayAdapter =
            activity?.let {
                ArrayAdapter<String>(
                    it, android.R.layout.simple_list_item_1,
                    Constants.spell
                )
            }
        dept.setAdapter(arrayAdapter)

        //signup Button
        view.findViewById<Button>(R.id.butSig)?.setOnClickListener {
            shower2.visibility = View.VISIBLE
            know()
            //alert()
        }


        //[start] select student level button
        view.findViewById<Button>(R.id.lvl)?.setOnClickListener {
            val popMenu = PopupMenu(activity, lvl)
            popMenu.menuInflater.inflate(R.menu.menu_pop, popMenu.menu)
            popMenu.setOnMenuItemClickListener { position ->
                when (position.itemId) {
                    R.id.hun -> {
                        grow = "Lv100"
                        lvl.text = grow
                    }
                    R.id.Thun -> {
                        grow = "Lv200"
                        lvl.text = grow
                    }

                }
                true
            }
            popMenu.show()
        }


//end of select student button [end]


        //[start] select student semester button
        view.findViewById<Button>(R.id.lvl2)?.setOnClickListener {
            val popMenu = PopupMenu(activity, lvl2)
            popMenu.menuInflater.inflate(R.menu.menu_pop2, popMenu.menu)
            popMenu.setOnMenuItemClickListener { position ->
                when (position.itemId) {
                    R.id.first -> {
                        semester = "1st Semester"
                        lvl2.text = semester
                    }
                    R.id.second -> {
                        semester = "2nd Semester"
                        lvl2.text = semester
                    }

                }
                true
            }
            popMenu.show()
        }


        return view

    }
//end of select student button [end]

    //checks depaartment
    fun know() {

        val rai = dept.text.toString()
//check if department picked matches database
        val pattern = rai.toRegex()
        Constants.spell.forEach { spells ->
            if (!pattern.containsMatchIn(spells)) {
                // Toast.makeText(activity, " department not found", Toast.LENGTH_SHORT) .show()


            } else {
                auth()
            }
        }
    }


    /*fun alert() {

        val inflater = layoutInflater
        val inflated = inflater.inflate(R.layout.slate2, null)
        val checktog = inflated.findViewById<CheckBox>(R.id.checks)
        checktog.setOnCheckedChangeListener { buttonView, isCheck ->
            if (isCheck) {
                //createfolder()
                //stay()
                //auth()
                val emInput2 = emailer.text.toString()
                val pass2 = passcord.text.toString()
                val pass3 = conpasscord.text.toString()
                val tel = phoner.text.toString()
                val nom = name.text.toString()
                val rai = dept.text.toString()
                val surs = Surname.text.toString()
                val saver = db(activity).insertData(nom,surs,rai,grow)

                val intent = Intent(activity, landPage::class.java)
                //intent.putExtra(Constants.name, nom)
                //intent.putExtra(Constants.surname, surs)
                //intent.putExtra(Constants.dept, rai)
                //intent.putExtra(Constants.level, grow)
                startActivity(intent)
                activity!!.finish()
                //activity?.let { DownloadActivity(it).execute(rai,grow,firstSem,"https://s3.amazonaws.com/appsdeveloperblog/Micky.jpg") }
                //val intent = Intent(activity, landPage::class.java)
                // TODO (STEP 2: Pass the name through intent using the constant variable which we have created.)
                // START

                //startActivity(intent)
            }

        }
        val dialog = AlertDialog.Builder(activity)


        dialog.setView(inflated)
        dialog.setCancelable(false)

        val dialogs = dialog.create()
        dialogs.show()
    }*/


    /*fun stay() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val imp = NotificationManager.IMPORTANCE_HIGH
            val mChange = NotificationChannel(Ch, ch_name, imp)
            val notificationBuilder: Notification.Builder = Notification.Builder(
                activity,
                Ch
            )
                .setSmallIcon(R.drawable.newlogo)
                .setContentText("Downloading Past Questions and Semester files")
                .setContentTitle("Getting files")
            val notificationManager: NotificationManager =
                activity?.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(mChange)
            notificationManager.notify(0, notificationBuilder.build())

        } else {
            val notif2: androidx.core.app.NotificationCompat.Builder =
                activity?.let {
                    androidx.core.app.NotificationCompat.Builder(
                        it
                    )
                        .setSmallIcon(R.drawable.newlogo)
                        .setContentText("Downloading Past Questions and Semester files")
                        .setContentTitle("Getting files")
                }
            val notificationManager: NotificationManager =
                activity?.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.notify(0, notif2.build())
        }
    }*/


    fun auth() {

        val emInput2 = emailer!!.text.toString().trim()
        val pass2 = passcord.text.toString()
        val pass3 = conpasscord.text.toString()
        val tel = phoner.text.toString()
        val nom = name.text.toString().trim()
        val rai = dept.text.toString()
        val surs = Surname.text.toString()
        val sismesta = semester

        when {
            emInput2.isEmpty() -> {
                Alerter.create(activity)
                    .setBackgroundColorRes(R.color.tint)
                    .setText("Email cannot be empty")
                    .setTitle("Error")
                    .show()

            }
            pass2.isEmpty() -> {
                Alerter.create(activity)
                    .setBackgroundColorRes(R.color.tint)
                    .setText("Password cannot be empty")
                    .setTitle("Error")
                    .show()
            }
            !Patterns.EMAIL_ADDRESS.matcher(emInput2).matches() -> {
                Alerter.create(activity)
                    .setBackgroundColorRes(R.color.tint)
                    .setText("Input valid Email")
                    .setTitle("Error")
                    .show()
            }
            /* !passPattern.matcher(pass2).matches() -> {
                Toast.makeText(
                        activity,
                        "password must contain alphabet,number,special character",
                        Toast.LENGTH_SHORT
                ).show()
            }*/
            pass2 != pass3 -> {
                Alerter.create(activity)
                    .setBackgroundColorRes(R.color.tint)
                    .setText("Password does not match")
                    .setTitle("Error")
                    .show()
            }
            else -> {
//addData()

                val passHash = BCrypt.withDefaults().hashToString(12, pass2.toCharArray())

                val data = firebasedata(emInput2, passHash, tel, nom, surs, rai, grow!!, sismesta!!)
// save data into firebase
                val shave =
                    emInput2.split("@".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()[0]


                Firebase.database.getReference("student/login/$shave")
                    .addValueEventListener(object : ValueEventListener {
                        override fun onCancelled(error: DatabaseError) {
                            Toast.makeText(activity, "Could not login", Toast.LENGTH_SHORT).show()
                        }

                        override fun onDataChange(snapshot: DataSnapshot) {
                            if (snapshot.exists()) {
                                Toast.makeText(
                                    activity,
                                    "User already registered,Logging instead",
                                    Toast.LENGTH_SHORT
                                ).show()
                            } else {
                                FirebaseDatabase.getInstance().getReference("student/login/$shave")
                                    .setValue(data)
                                    .addOnSuccessListener {
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
                                        FirebaseStorage.getInstance().reference.child("/Pronoun/$rai/$grow/$semester")
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
                                            val intent = Intent(activity, landPage::class.java)

                                            intent.putExtra("firstName", nom) //name
                                            intent.putExtra("lastName", surs)  //surname
                                            intent.putExtra("course", rai)   //department
                                            intent.putExtra("level", grow)  // level
                                            intent.putExtra("semester", semester!!)  //semester

                                            //item.activeDownloadTasks.last()
                                            item.listAll().addOnCompleteListener {
                                               Timer().schedule(2000) {
                                                   sharedPreference.save(
                                                       "num",
                                                       2
                                                   )  //this saves the number into the sharedpreferences so that user doesnt come here twice

                                                   startActivity(intent)
                                                   requireActivity().finish()
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

        }


    }

}