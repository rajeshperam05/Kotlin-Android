package com.swayam.kotlintestapp.ui.activity

import android.app.Activity
import android.content.Context
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

import com.swayam.kotlintestapp.R
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserFactory
import java.net.HttpURLConnection
import java.net.URL

class RSSFeedActivity : AppCompatActivity() {

    val RSS_URL = "http://tutorialspoint.com/android/sampleXML.xml"

    public var context : Context? = null
    var tvResult : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rssfeed)

        context = this
        tvResult = findViewById(R.id.tvResult) as TextView
    }

    fun load(view : View) {


        MyTask(context!!).execute(RSS_URL)


    }

    class RSSHandler {

        var title = ""
        var link = ""
        var description = ""

        var parseComplete = true

        var data : RSSData? = null


        fun parseRSS(parser : XmlPullParser) {

            var text = ""

            var event = parser.eventType

            while (event != XmlPullParser.END_DOCUMENT) {

                var name = parser.name

                when(event){

                    XmlPullParser.START_TAG -> {
                    }

                    XmlPullParser.TEXT -> {
                        text = parser.text
                    }

                    XmlPullParser.END_TAG -> {

                        if (name.contentEquals("title"))
                            title = text
                        else if (name.contentEquals("link"))
                            link = text
                        else if (name.contentEquals("description"))
                            description = text
                    }

                }

                event = parser.next()
            }

            data = RSSData(title, link, description)
        }

        fun fetchXML(url : String) : RSSData {

//            Thread(Runnable { kotlin.run {

                var url : URL = URL(url)

                var connection = url.openConnection() as HttpURLConnection
                connection.connectTimeout = 15000
                connection.readTimeout = 15000
                connection.requestMethod = "GET"
                connection.doInput = true
                connection.connect()

                var stream = connection.inputStream

                var parserFactory = XmlPullParserFactory.newInstance()
                var parser = parserFactory.newPullParser()
                parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false)
                parser.setInput(stream, null)
                parseRSS(parser)
                stream.close()

//            } }).start()


            return data!!
        }

    }

    data class RSSData(var title : String, var link : String, var description : String)

    class MyTask(context: Context) : AsyncTask<String, Void, RSSData>() {

        var context: Context = context

        override fun doInBackground(vararg params: String?): RSSData {

            var hadler = RSSHandler()
            return hadler.fetchXML(params[0]!!)

        }

        override fun onPostExecute(data: RSSData?) {
            super.onPostExecute(data)

            var tvResult = (context as Activity).findViewById(R.id.tvResult) as TextView
            tvResult.text = ""
            tvResult.text = tvResult.text.toString() + "\n" + data!!.title + "\n" + data!!.link + "\n" + data!!.description

        }


    }
}
