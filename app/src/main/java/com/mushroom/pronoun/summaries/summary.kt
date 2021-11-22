package com.mushroom.pronoun.summaries

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.TextPaint
import android.text.method.ScrollingMovementMethod
import android.text.style.*
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import com.mushroom.pronoun.R
import com.mushroom.pronoun.questionaires.PQActivity
import kotlinx.android.synthetic.main.activity_summary.*
import org.json.JSONArray
import java.io.File
import java.io.IOException
import java.io.InputStream

class summary : AppCompatActivity() {


    var quests: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary)

        run {
            val w: Window = window
            w.setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            )

        }
        //textOneSpan()
        //textTwoSpan()

        giver.setOnClickListener {
            giver.visibility = View.GONE
            textViewOne.visibility = View.VISIBLE
            textThreeSpan()
        }
        textThreeSpan()
    }

    private fun textOneSpan() {
        val spannableStringBuilder = SpannableStringBuilder("Hi Sriyank Siddhartha.")

        val fColor = ForegroundColorSpan(Color.RED)
        spannableStringBuilder.setSpan(fColor, 0, 2, Spannable.SPAN_INCLUSIVE_EXCLUSIVE)

        val bColor = BackgroundColorSpan(Color.GREEN)
        spannableStringBuilder.setSpan(bColor, 3, 21, Spannable.SPAN_INCLUSIVE_EXCLUSIVE)

        spannableStringBuilder.append(" Welcome!")
        textViewOne.text = spannableStringBuilder
    }

    private fun textTwoSpan() {

        val spannableString = SpannableString("How are you?")

        val sizeSpan = RelativeSizeSpan(2f)
        spannableString.setSpan(sizeSpan, 0, 3, Spannable.SPAN_INCLUSIVE_EXCLUSIVE)

        val styleSpan = StyleSpan(Typeface.BOLD)
        spannableString.setSpan(styleSpan, 0, 3, Spannable.SPAN_INCLUSIVE_EXCLUSIVE)

        val underlineSpan = UnderlineSpan()
        spannableString.setSpan(underlineSpan, 8, 11, Spannable.SPAN_INCLUSIVE_EXCLUSIVE)

        //textViewTwo.text = spannableString
    }


    private fun textThreeSpan() {


        val json: String?
        //try ,catch used to avoid exception issues
        try {
            val pdf: File? =
                this.getExternalFilesDir("Pronoun/Data/sum1.pdf")
            val inputStream: File? =
                this.getExternalFilesDir("Pronoun/Data/bus.json")  //here is where we put the json file
            pdfView.fromFile(pdf).load()
            json = inputStream!!.bufferedReader().use { it.readText() }
            val jsonArr = JSONArray(json) //we set json to array
            //now we iterate array
            for (i in 0 until jsonArr.length()) {
                val jsonObj = jsonArr.getJSONObject(i)
                //now we tie variables to content of our json
                quests = jsonObj.getString("code")
                quests.toString().replace("\\s+", "")

                //now lets add the json contents stored in these variables into our data class


            }
        } catch (e: IOException) {
            Toast.makeText(this, "Couldn't load file", Toast.LENGTH_SHORT).show()
        }


        val spannableString = SpannableString(quests.toString().replace("\\s+", ""))

        val clickableSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {


                val intent = Intent(this@summary, PQActivity::class.java)
                startActivity(intent)
                finish()
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)

                ds.color = Color.BLUE
                ds.isUnderlineText = false
            }
        }

        spannableString.setSpan(
            clickableSpan,
            spannableString.length -20,
            spannableString.length,
            Spannable.SPAN_INCLUSIVE_INCLUSIVE
        )
        textView9.text = spannableString
        textViewOne.text = spannableString
        textViewOne
        textViewOne.movementMethod = ScrollingMovementMethod()
    }

}