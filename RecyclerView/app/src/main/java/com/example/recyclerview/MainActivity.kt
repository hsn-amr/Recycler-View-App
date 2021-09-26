package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private val inputList = ArrayList<String>()
    private lateinit var myRV: RecyclerView
    private lateinit var addButton: Button
    private lateinit var mainView: ConstraintLayout
    private lateinit var userInput: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myRV = findViewById(R.id.rvMain)
        userInput = findViewById(R.id.edUserInput)
        addButton = findViewById(R.id.btnAdd)
        mainView = findViewById(R.id.clMainView)

        addButton.setOnClickListener {
            when{
                userInput.text.toString().isEmpty() -> {
                    Snackbar.make(mainView, "Please, write something first", Snackbar.LENGTH_LONG).show()
                    userInput.text.clear()
                }
                userInput.text.toString().length > 40 -> {
                    Snackbar.make(mainView, "Please, don't write long text", Snackbar.LENGTH_LONG).show()
                    userInput.text.clear()
                }
                else -> {
                    inputList.add(userInput.text.toString())
                    addToRecyclerView(inputList)
                    userInput.text.clear()
                }
            }
        }
    }

    private fun addToRecyclerView(list: ArrayList<String>){
        myRV.adapter = RecyclerViewAdapter(list)
        myRV.layoutManager = LinearLayoutManager(this)
    }
}