package com.example.calc_convert

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    lateinit var dropMenuFrom: AutoCompleteTextView
    lateinit var toDropMenu: AutoCompleteTextView
    lateinit var textEditRes: TextInputEditText
    lateinit var buttonConvert: Button
    lateinit var textInputEditText: TextInputEditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        initListeners()
    }

    private fun initViews() {
        dropMenuFrom = findViewById(R.id.fromConvert)
        toDropMenu = findViewById(R.id.toConvert)
        textEditRes = findViewById(R.id.resulat)
        buttonConvert = findViewById(R.id.button)
        textInputEditText = findViewById(R.id.number)
        val listOfSystemConverter = listOf<String>("Binary", "Octal", "Decimal", "Hexadecimal")
        val adapter = ArrayAdapter(this, R.layout.downdrop, listOfSystemConverter)
        dropMenuFrom.setAdapter(adapter)
        toDropMenu.setAdapter(adapter)
    }

    private fun initListeners() {
        buttonConvert.setOnClickListener {
            val start = dropMenuFrom.text.toString()
            val end = toDropMenu.text.toString()

            // ************* Hide keyBoard *******************************
            val inputMethodManager =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

            val view = currentFocus
            if (view == null) {
                val dummyView = View(this)
                dummyView.requestFocus()
                inputMethodManager.hideSoftInputFromWindow(dummyView.windowToken, 0)

            } else {
                inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
            }

            //************************** logic Code ******************************
            if (start == "Binary" && end == "Decimal") {
                var output = Integer.parseInt(textInputEditText.text.toString(), 2)

                textEditRes.setText(output.toString())
            } else if (start == "Binary" && end == "Octal") {

                var output = Integer.parseInt(textInputEditText.text.toString(), 2)

                val out = Integer.toOctalString(output)
                textEditRes.setText(out.toString())

            } else if (start == "Binary" && end == "Hexadecimal") {

                var output = Integer.parseInt(textInputEditText.text.toString(), 2)
                val ans = Integer.toHexString(output.toInt())
                textEditRes.setText(ans.toString().uppercase())


            } else if (start == "Decimal" && end == "Binary") {

                var input = textInputEditText.text.toString().toInt()
                var output = Integer.toBinaryString(input)
                textEditRes.setText(output.toString())


            } else if (start == "Decimal" && end == "Octal") {

                var input = textInputEditText.text.toString().toInt()
                var output = Integer.toOctalString(input)
                textEditRes.setText(output.toString())
            } else if (start == "Decimal" && end == "Hexadecimal") {
                var input = textInputEditText.text.toString().toInt()
                var output = Integer.toHexString(input)
                textEditRes.setText(output.toString())

            } else if (start == "Octal" && end == "Binary") {
                val ans = textInputEditText.text.toString()
                val decimal = Integer.parseInt(ans, 8)
                var output = Integer.toBinaryString(decimal)
                textEditRes.setText(output.toString())
            } else if (start == "Octal" && end == "Decimal") {
                val ans = textInputEditText.text.toString()
                val decimal = Integer.parseInt(ans, 8)
                textEditRes.setText(decimal.toString())

            } else if (start == "Octal" && end == "Hexadecimal") {
                val ans = textInputEditText.text.toString()
                val decimal = Integer.parseInt(ans, 8)
                var output = Integer.toHexString(decimal)
                textEditRes.setText(decimal.toString())

            } else if (start == end) {
                val ans = textInputEditText.text.toString()
                textEditRes.setText(ans)
            } else if (start == "Hexadecimal" && end == "Binary") {
                val ans = textInputEditText.text.toString()
                var decimal = Integer.parseInt(ans, 16)
                var hex = Integer.toBinaryString(decimal)
                textEditRes.setText(hex.toString())

            } else if (start == "Hexadecimal" && end == "Decimal") {
                val ans = textInputEditText.text.toString()
                var hex = Integer.parseInt(ans)
                textEditRes.setText(hex.toString())

            } else if (start == "Hexadecimal" && end == "Octal") {
                val ans = textInputEditText.text.toString()
                var decimal = Integer.parseInt(ans, 16)
                var hex = Integer.toOctalString(decimal)
                textEditRes.setText(hex.toString())

            }
        }
    }

}