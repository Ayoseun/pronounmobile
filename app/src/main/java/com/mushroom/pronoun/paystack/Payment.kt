package com.mushroom.pronoun.paystack

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import com.google.android.material.textfield.TextInputLayout
import com.mushroom.pronoun.R

class Payment : AppCompatActivity() {

    private lateinit var mCardNumber: TextInputLayout
    private lateinit var mCardExpiry: TextInputLayout
    private lateinit var mCardCVV: TextInputLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)
        // TODO - 3: Call the initializePaystack method
        initializeFormVariables()
    }

    // TODO - 1: Create the initializePaystack method
    // TODO - 2: Initialize the Paystack SDK in the initializePaystack method

    private fun getKey (): String {
        val apiKey: String
        applicationContext.packageManager
            .getApplicationInfo(packageName, PackageManager.GET_META_DATA)
            .apply {
                apiKey = metaData.getString("co.paystack.android.PublicKey", "")
            }

        return apiKey
    }

    private fun initializeFormVariables() {
        mCardNumber = findViewById(R.id.exp)
        mCardExpiry = findViewById(R.id.expory)
        mCardCVV = findViewById(R.id.cvv)

        // this is used to add a forward slash (/) between the cards expiry month
        // and year (11/21). After the month is entered, a forward slash is added
        // before the year
        mCardExpiry.editText!!.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                if (s.toString().length == 2 && !s.toString().contains("/")) {
                    s!!.append("/")
                }
            }

        })

        val button = findViewById<Button>(R.id.pay)
        button.setOnClickListener { performCharge() }
    }

    private fun performCharge() {
        // TODO - 4: Flesh out the performCharge method
        // TODO - 5: Get the cardNumber, cardExpiry and cvv from the checkout form
        // TODO - 6: Parse the cardNumber, cardExpiry and cvv to ensure they are ready for charge
        // TODO - 7: Create a card object with the cardNumber, cardExpiry and cvv

        // TODO - 8: Create a charge object
        // TODO - 9: Charge card
    }

    // TODO - 10: Create a parseResponse method to parse a successful response
}