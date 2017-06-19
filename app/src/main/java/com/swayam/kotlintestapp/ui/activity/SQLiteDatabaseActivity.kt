package com.swayam.kotlintestapp.ui.activity

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.swayam.kotlintestapp.R
import com.swayam.kotlintestapp.storage.Contact
import com.swayam.kotlintestapp.storage.SQLiteContactsDatabase
import com.swayam.kotlintestapp.ui.adapter.ContactAdapter

class SQLiteDatabaseActivity : android.support.v7.app.AppCompatActivity() {

    var etName: android.widget.EditText? = null
    var etNumber: android.widget.EditText? = null
    var rvContacts: RecyclerView? = null

    var adapter: ContactAdapter? = null

    var mDB: SQLiteContactsDatabase = SQLiteContactsDatabase(this@SQLiteDatabaseActivity)

    var arrayList = arrayListOf<Contact>()

    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.swayam.kotlintestapp.R.layout.activity_sqlite_database)

        etName = findViewById(R.id.etName) as android.widget.EditText
        etNumber = findViewById(R.id.etNumber) as android.widget.EditText

        rvContacts = findViewById(R.id.rvContacts) as RecyclerView
        var layoutManager = LinearLayoutManager(this)
        rvContacts!!.layoutManager = layoutManager

        arrayList.addAll(mDB.allContacts)
        arrayList.reverse()
        adapter = ContactAdapter(this@SQLiteDatabaseActivity, arrayList)
        rvContacts!!.adapter = adapter
    }

    fun save(view: android.view.View) {

        val name = etName!!.text.toString().trim()
        val number = etNumber!!.text.toString().trim()

        if (android.text.TextUtils.isEmpty(name))
            android.widget.Toast.makeText(this@SQLiteDatabaseActivity, "Enter Name", android.widget.Toast.LENGTH_SHORT).show()
        else if (android.text.TextUtils.isEmpty(number))
            android.widget.Toast.makeText(this@SQLiteDatabaseActivity, "Enter Number", android.widget.Toast.LENGTH_SHORT).show()
        else {

            val id = mDB.insert(Contact(name, number))
            arrayList.reverse()
            arrayList.add(Contact(id.toInt(), name, number))
            arrayList.reverse()
//                adapter!!.refreshList(arrayList)
            adapter!!.notifyDataSetChanged()
            etName!!.setText("")
            etNumber!!.setText("")

        }


    }
}
