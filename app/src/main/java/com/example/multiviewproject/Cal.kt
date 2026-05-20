package com.example.multiviewproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Cal : AppCompatActivity() {
    lateinit var tv1: TextView
    lateinit var buttonZero: Button
    lateinit var buttonOne: Button
    lateinit var buttonTwo: Button
    lateinit var buttonThree: Button
    lateinit var buttonFour: Button
    lateinit var buttonFive: Button
    lateinit var buttonSix: Button
    lateinit var buttonSeven: Button
    lateinit var buttonEight: Button
    lateinit var buttonNine: Button

    lateinit var buttonPlus: Button
    lateinit var buttonMinus: Button
    lateinit var buttonMultiply: Button
    lateinit var buttonDivide: Button
    lateinit var buttonEqual: Button
    lateinit var buttonPoint: Button
    lateinit var clear: Button

    lateinit var goEven: Button
    lateinit var goFact: Button

    var temp = 0.0
    var result = 0.0

    var operator = "equal"

    var decimal = 1.0
    var decimalScale = 1.0

    var scale = 10

    var op = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.third_activity)

        tv1 = findViewById(R.id.result)

        buttonZero = findViewById(R.id.buttonZero)
        buttonOne = findViewById(R.id.buttonOne)
        buttonTwo = findViewById(R.id.buttonTwo)
        buttonThree = findViewById(R.id.buttonThree)
        buttonFour = findViewById(R.id.buttonFour)
        buttonFive = findViewById(R.id.buttonFive)
        buttonSix = findViewById(R.id.buttonSix)
        buttonSeven = findViewById(R.id.buttonSeven)
        buttonEight = findViewById(R.id.buttonEight)
        buttonNine = findViewById(R.id.buttonNine)

        buttonPlus = findViewById(R.id.buttonPlus)
        buttonMinus = findViewById(R.id.buttonMinus)
        buttonMultiply = findViewById(R.id.buttonMultiply)
        buttonDivide = findViewById(R.id.buttonDivide)
        buttonEqual = findViewById(R.id.buttonEqual)
        buttonPoint = findViewById(R.id.buttonPoint)
        clear = findViewById(R.id.clear)

        goEven = findViewById(R.id.nav1)
        goFact = findViewById(R.id.nav2)

        val evenIntent = Intent(this, MainActivity::class.java)
        val factIntent = Intent(this, Factorial::class.java)

        goEven.setOnClickListener {
            startActivity(evenIntent)
        }

        goFact.setOnClickListener {
            startActivity(factIntent)
        }

        getNumber()
    }

    private fun addDigit(num: Int) {
        temp = temp * scale + num * decimal
        decimal *= decimalScale
        tv1.text = temp.toString()
    }

    private fun getNumber() {

        buttonZero.setOnClickListener { addDigit(0) }
        buttonOne.setOnClickListener { addDigit(1) }
        buttonTwo.setOnClickListener { addDigit(2) }
        buttonThree.setOnClickListener { addDigit(3) }
        buttonFour.setOnClickListener { addDigit(4) }
        buttonFive.setOnClickListener { addDigit(5) }
        buttonSix.setOnClickListener { addDigit(6) }
        buttonSeven.setOnClickListener { addDigit(7) }
        buttonEight.setOnClickListener { addDigit(8) }
        buttonNine.setOnClickListener { addDigit(9) }

        buttonPlus.setOnClickListener {
            logic()
            operator = "plus"
        }

        buttonMinus.setOnClickListener {
            logic()
            operator = "minus"
        }

        buttonMultiply.setOnClickListener {
            logic()
            operator = "multiply"
        }

        buttonDivide.setOnClickListener {
            logic()
            operator = "divide"
        }

        buttonEqual.setOnClickListener {
            logic()
            operator = "equal"
        }

        buttonPoint.setOnClickListener {
            decimalScale = 0.1
            decimal = 0.1
            scale = 1
        }

        clear.setOnClickListener {

            temp = 0.0
            result = 0.0

            operator = "equal"

            decimal = 1.0
            decimalScale = 1.0

            scale = 10

            op = false

            tv1.text = "0"
        }
    }

    private fun logic() {

        if (!op) {
            result = temp
            temp = 0.0
            op = true
        }

        when (operator) {

            "plus" -> result += temp

            "minus" -> result -= temp

            "multiply" -> result *= temp

            "divide" -> result /= temp
        }

        temp = 0.0
        decimal = 1.0
        decimalScale = 1.0
        scale = 10

        tv1.setText(result.toString())
    }
}

