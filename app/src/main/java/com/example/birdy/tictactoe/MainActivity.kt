package com.example.birdy.tictactoe

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    protected fun btnClick(view:View) {
        val btnSelected = view as Button
        var cellID = 0
        when (btnSelected.id) {
            R.id.b1->cellID = 1
            R.id.b2->cellID = 2
            R.id.b3->cellID = 3
            R.id.b4->cellID = 4
            R.id.b5->cellID = 5
            R.id.b6->cellID = 6
            R.id.b7->cellID = 7
            R.id.b8->cellID = 8
            R.id.b9->cellID = 9
        }

        Toast.makeText(this, "$cellID selected", Toast.LENGTH_SHORT).show()
    }
}
