package com.example.orderappkotlinversion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {

    private var whipedcream: Boolean = false
    private var chocolatechecked: Boolean = false
    private var count: Int = 0

    private lateinit var textView: TextView
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var order: Button
    private lateinit var cream: CheckBox
    private lateinit var chocolate: CheckBox
    private lateinit var receipt: TextView
    private lateinit var toppings: TextView
    private lateinit var editText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1 = findViewById(R.id.plus)
        textView = findViewById(R.id.amount)
        button2 = findViewById(R.id.minus)
        cream = findViewById(R.id.whipped_cream)
        chocolate = findViewById(R.id.chocolate)
        order = findViewById(R.id.order)
        receipt = findViewById(R.id.receipt)
        editText = findViewById(R.id.name_text)
        toppings = findViewById(R.id.toppings)

        button1.setOnClickListener {
            count++
            textView.setText(count.toString())
        }

        button2.setOnClickListener {
            if (count > 0) {
                count--
                textView.setText(count.toString())
            }
        }

        cream.setOnCheckedChangeListener { compoundButton: CompoundButton, isChecked: Boolean ->
            Log.d("Myapp", "Status of checkbox: " + isChecked)
            whipedcream = isChecked
        }

        chocolate.setOnCheckedChangeListener { compoundButton: CompoundButton, isChecked: Boolean ->
            Log.d("Myapp", "Status of checkbox: " + isChecked)
            chocolatechecked = isChecked
        }

        order.setOnClickListener {
            var total: Int = 0
            if (whipedcream) total += 10
            if (chocolatechecked) total += 5
            total *= count
            receipt.setText(
                "ORDER SUMMARY\n" +
                        "Person: ${editText.text}\n" +
                        "Add wipped cream? $whipedcream\n" +
                        "Add chocolate? $chocolatechecked\n" +
                        "Quantity: ${textView.text}\n" +
                        "Total: \$$total\n" +
                        "Thank you!!!"
            )
        }

    }
}