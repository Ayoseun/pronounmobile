package com.mushroom.trial.model

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.mushroom.trial.R
import com.mushroom.trial.questionaires.PQActivity
import com.mushroom.trial.utils.landPage

class login : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        val butLogin = view?.findViewById<Button>(R.id.butLogin)
             butLogin!!.setOnClickListener{startActivity(Intent(activity, landPage::class.java))}


        return view

    }


}