package android.tyit.com.appbaruicomponents

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    internal var div = arrayOf("A", "B")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //setting toolbar
        setSupportActionBar(findViewById(R.id.toolbar))

        val spin = findViewById(R.id.simplespinner) as Spinner
        spin.setOnItemSelectedListener(this)

        val aa = ArrayAdapter(this, android.R.layout.simple_spinner_item, div)
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spin.setAdapter(aa)

        butttn.setOnClickListener {
            Toast.makeText(this, "Submitted", Toast.LENGTH_SHORT).show()
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.basic_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.edit_profile -> {
            // User chose the "Edit" item
            Toast.makeText(this, "Edit Profile action", Toast.LENGTH_LONG).show()
            true
        }

        R.id.logout -> {
            // User chose the "Logout" item
            Toast.makeText(this, "Logout action", Toast.LENGTH_LONG).show()
            true
        }

        else -> {
            super.onOptionsItemSelected(item)
        }
    }

    override fun onItemSelected(p0: AdapterView<*>, arg1: View, position: Int, id: Long) {
        Toast.makeText(applicationContext, "Course is: ${div[position]}", Toast.LENGTH_SHORT).show()
        //Toast.makeText(getApplicationContext,"Time is:",Toast.LENGTH_SHORT).show()
    }

    override fun onNothingSelected(p0: AdapterView<*>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
