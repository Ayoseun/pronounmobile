package com.mushroom.pronoun.view

import android.content.Context
import android.graphics.Bitmap
import android.os.AsyncTask
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
import com.bumptech.glide.request.RequestOptions
import java.io.File
import java.io.FileOutputStream
import java.lang.ref.WeakReference


class DownloadActivity (context: Context): AsyncTask<String,Unit,Unit>(){
    private var mContext: WeakReference<Context> = WeakReference(context)
    override fun doInBackground(vararg p0: String?)



    {
        val model = p0[0]
        val requestOptions = RequestOptions().override(100)
            .downsample(DownsampleStrategy.CENTER_INSIDE)
            .skipMemoryCache(true)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
        mContext.get()?.let {
            val bitmap = Glide.with(it)
                .asBitmap()
                .load(model)
                .apply(requestOptions)
                .submit()
                .get()

            try {


                val data = "icons"
                val data2 = "courses"
                val folder = it.getExternalFilesDir("Pronoun")
                var f = File(folder, data)
                val z = File(folder,data2)

                if (!f.exists() && !z.exists()) {
                    f.mkdir()
                    z.mkdir()
                }
                f = File(f, "courses.jpg")
                val out = FileOutputStream(f)
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out)
                out.flush()
                out.close()

            } catch (e: Exception) {
            }
        }
      /*  private fun downloadFile() {
            val data = "icons"
            val data2 = "courses"
            val folder = this.getExternalFilesDir("Pronoun")
            var f = File(folder, data)
            val z = File(folder,data2)

            if (!f.exists() && !z.exists()) {
                f.mkdir()
                z.mkdir()
            }
            val storageRef = FirebaseStorage.getInstance().reference.child("Pronoun/Science/studykit2021.png")
            val localFile = File(f,"studykit2021.png")
            storageRef.getFile(localFile).addOnSuccessListener {
                Toast.makeText(this,"working", Toast.LENGTH_SHORT).show()
            }.addOnFailureListener {
                Toast.makeText(this, "Failed to retrieve the image", Toast.LENGTH_SHORT).show()
            }
        }




         fun checks() {
        val data = "Data"

        val folder = this.getExternalFilesDir("Pronoun")
        var f = File(folder, data)


        if (!f.exists()) {
            f.mkdir()

        }
        val storageRef = FirebaseStorage.getInstance().reference.child("/Pronoun/ECONOMICS/Lv100/2nd Semester")
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










































   val test = arrayOf("1","2","5")
            for(i in test.indices){

           if(i == test.


                     s es



                       m





             )
        }

        */



    }




































}


