package com.example.basiccalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
	}

	var textField1: EditText? = null
	var textField2: EditText? = null
	var resultView: TextView? = null
	var op1: Double = 0.0
	var op2: Double = 0.0
	var str1: String? = ""
	var str2: String? = ""

	// checkTextField() method to check if 2 operands are empty or null
	open fun checkTextField(): Boolean {
		// Get a content from text field 1 (operand 1)
		textField1 = findViewById<EditText>(R.id.op1)
		str1 = textField1?.text.toString()

		// Get a content from text field 2 (operand 2)
		textField2 = findViewById<EditText>(R.id.op2) as EditText
		str2 = textField2?.text.toString()

		//view result
		resultView = findViewById<EditText>(R.id.result) as TextView

		// Check if those text fields are null or empty
		if ((str1 == null && str2 == null) || (str1 == "" && str2 == "")) {
			// pop up error notification
			Toast.makeText(applicationContext, "Missing 2 operands", Toast.LENGTH_SHORT).show()
//			println("here false")
			return false
		}
		// If either operand 1 or operand 2 is not empty or null, convert the operands in type string to Double
		else {
			if (str1 == "" || str1 == null) {
				op2 = str2!!.toDouble()
			} else if (str2 == "" || str2 == null) {
				op1 = str1!!.toDouble()
			} else {
				op1 = str1!!.toDouble()
				op2 = str2!!.toDouble()
			}
//			println("here true")
			return true
		}
	}

	// checkEmptyOperand() function: check if there is any missing one of 2 operands in text fields
	fun checkEmptyOperand(): Boolean {
		if (str1 == "" || str2 == "")
			return true
		else
			return false
	}
	// addtion() function
	fun addition(view: View) {
		var add: Double = 0.0
		var check: Boolean = checkTextField()
		var checkOp = checkEmptyOperand()
		if (check) {
			// if missing one of 2 operands, pop up an error message
			if (checkOp) {
				Toast.makeText(applicationContext, "Missing an operand", Toast.LENGTH_SHORT).show()
			} else {
				add = op1 + op2
				resultView?.text = String.format("%.3f", add)
			}
		}
	}

	// subtraction() method
	fun subtraction(view: View) {
		var sub: Double = 0.0
		var check: Boolean = checkTextField()
		var checkOp = checkEmptyOperand()
		if (check) {
			// if missing one of 2 operands, pop up an error message
			if (checkOp) {
				Toast.makeText(applicationContext,"Missing an operand",Toast.LENGTH_SHORT).show()
			} else {
				sub = op1 - op2
				resultView?.text = String.format("%.3f", sub)
			}
		}
	}

	// squareRoot() function
	fun squareRoot(view: View) {
		var sqrt: Double = 0.0
		var check: Boolean = checkTextField()
		if (check) {
			// if missing the operand 1, pop up an error message
			if (str1 == "") {
				Toast.makeText(applicationContext, "Invalid operand 1", Toast.LENGTH_SHORT).show()
			} else {
				// Check if the operand 1 is negative
				if(op1 < 0){
					Toast.makeText(applicationContext, "Operand 1 has to be >= 0", Toast.LENGTH_SHORT).show()
				}
				else{
					sqrt = Math.sqrt(op1)
					resultView?.text = String.format("%.3f", sqrt)
				}
			}
		}
	}


	// multiple() function
	fun multiple(view: View) {
		var mul: Double = 0.0
		var check: Boolean = checkTextField()
		var checkOp = checkEmptyOperand()
		if (check) {
			// if missing one of 2 operands, pop up an error message
			if (checkOp) {
				Toast.makeText(applicationContext,"Missing an operand",Toast.LENGTH_SHORT).show()
			} else {
				mul = op1 * op2
				resultView?.text = String.format("%.3f", mul)
			}
		}
	}

	// division() function
	fun division(view: View) {
		var div: Double = 0.0
		var check: Boolean = checkTextField()
		var checkOp = checkEmptyOperand()
		if (check) {
			// if missing one of 2 operands, pop up an error message
			if (checkOp) {
				Toast.makeText(applicationContext,"Missing an operand",Toast.LENGTH_SHORT).show()
			}
			// if the operand 2 is 0.0, pop up an error message
			else if (op2 == 0.0) {
				Toast.makeText(applicationContext, "Cannot divided by 0", Toast.LENGTH_SHORT)
					.show()
			} else {
				div = op1 / op2
				resultView?.text = String.format("%.3f", div)
			}
		}
	}

	// remainder() function
	fun percent(view: View) {
		var per: Double = 0.0
		var check: Boolean = checkTextField()
		if (check) {
			// if missing the operand 1, pop up an error message
			if (str1 == "") {
				Toast.makeText(applicationContext, "Invalid operand 1", Toast.LENGTH_SHORT).show()
			} else {
				// Check if the operand 1 is negative
				if(op1 < 0){
					Toast.makeText(applicationContext, "Operand 1 has to be >= 0", Toast.LENGTH_SHORT).show()
				}
				else {
					per = op1 / 100
					resultView?.text = String.format("%.3f", per)
				}
			}
		}
	}
}
