package edu.temple.inclassuiacvitivity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner = findViewById<Spinner>(R.id.spinner)
        val changeButton = findViewById<Button>(R.id.changeButton)
        val displayTextView = findViewById<TextView>(R.id.textDisplay)

        // Step 1: Populate array
        val numberArray = IntArray(100)
        for (i in 1..100){
            numberArray[i] = i
        }

        spinner.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, numberArray.asList())


        // Step 2: Save selected text size
        spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        // Step 3: Change TextView to saved text size
        changeButton.setOnClickListener {

        }

    }
}
class ArrayAdapter(_context: Context, _array: Array<Int> ): BaseAdapter(){
    private val context = _context
    private val array =_array

    override fun getCount(): Int {
        return array.size
    }

    override fun getItem(p0: Int): Any {
        return array[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

        val textView = TextView(context)
        textView.text = array[p0].toString()
        textView.textSize
        return textView

    }

}
