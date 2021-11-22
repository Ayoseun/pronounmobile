package com.mushroom.pronoun

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.tapadoo.alerter.Alerter
import kotlinx.android.synthetic.main.activity_forgot.*

class Forgot_Activity : AppCompatActivity() {

    var forgot_email : EditText? = null
    var reset : Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot)
         forgot_email = findViewById<EditText>(R.id.forgot)
         reset = findViewById<Button>(R.id.reset)
        show()
    }

    fun show() {


        val emailTrim = forgot_email?.text.toString().trim { it <= ' ' }
        reset?.setOnClickListener {

            if (forgot_email?.text.toString().trim { it <= ' ' }.isEmpty()) {
                Alerter.create(this)
                    .setBackgroundColorRes(R.color.tint)
                    .setText("Email cannot be empty")
                    .setTitle("Email Empty")
                    .show()
            } else {
                FirebaseAuth.getInstance().sendPasswordResetEmail(forgot_email!!.text.toString().trim { it <= ' ' })
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Alerter.create(this)
                                .setBackgroundColorRes(R.color.tint)
                                .setText("Please check your mail")
                                .setTitle("Email Sent")
                                .show()
                        } else {
                            Alerter.create(this)
                                .setBackgroundColorRes(R.color.tint)
                                .setText(task.exception?.message.toString())
                                .setTitle("An error occurred")
                                .show()
                        }
                    }

            }
        }
    }
}