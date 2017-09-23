package com.example.birdy.tictactoe

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

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

//        Toast.makeText(this, "$cellID selected", Toast.LENGTH_SHORT).show()

        playGame(cellID, btnSelected)
    }

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var activePlayer = 1

    fun playGame(cellID:Int, btnSelected:Button){
        if (activePlayer == 1) {
            btnSelected.text = "X"
//            btnSelected.setBackgroundColor(Color.GREEN)
            btnSelected.setBackgroundResource(R.color.green)
            player1.add(cellID)
            activePlayer = 2
            autoPlay()
        } else {
            btnSelected.text = "O"
            btnSelected.setBackgroundResource(R.color.red)
            player1.add(cellID)
            activePlayer = 1
        }

        btnSelected.isEnabled = false
        checkWinner()
    }

    fun checkWinner() {
        var winner = -1

        // row 1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            winner = 1
        }

        if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            winner = 2
        }

        // row 2
        if (player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            winner = 1
        }

        if (player2.contains(4) && player2.contains(5) && player2.contains(6)) {
            winner = 2
        }

        // row 3
        if (player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            winner = 1
        }

        if (player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            winner = 2
        }

        // column 1
        if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            winner = 1
        }

        if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            winner = 2
        }

        // column 2
        if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            winner = 1
        }

        if (player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            winner = 2
        }

        // column 3
        if (player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            winner = 1
        }

        if (player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            winner = 2
        }

        // diagonal 1
        if (player1.contains(1) && player1.contains(5) && player1.contains(9)) {
            winner = 1
        }

        if (player2.contains(1) && player2.contains(5) && player2.contains(9)) {
            winner = 2
        }

        // diagonal 2
        if (player1.contains(3) && player1.contains(5) && player1.contains(7)) {
            winner = 1
        }

        if (player2.contains(3) && player2.contains(5) && player2.contains(7)) {
            winner = 2
        }

        if(winner != -1) {
            if(winner == 1) {
                Toast.makeText(this, "Player 1 wins!", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Player 2 wins!", Toast.LENGTH_LONG).show()
            }
        }
    }

    fun autoPlay() {
        var emptyCells = ArrayList<Int>()
        for (cellID in 1..9) {
            if(!(player1.contains(cellID) || player2.contains(cellID))) {
                emptyCells.add(cellID)
            }
        }

        var r = Random()
        val randIndex = r.nextInt(emptyCells.size - 0) + 0
        val cellID = emptyCells[randIndex]

        var btnSelected:Button?
        when(cellID){
            1->btnSelected = b1
            2->btnSelected = b2
            3->btnSelected = b3
            4->btnSelected = b4
            5->btnSelected = b5
            6->btnSelected = b6
            7->btnSelected = b7
            8->btnSelected = b8
            9->btnSelected = b9
            else->{
                btnSelected = b1
            }
        }

        playGame(cellID,btnSelected)
    }
}
