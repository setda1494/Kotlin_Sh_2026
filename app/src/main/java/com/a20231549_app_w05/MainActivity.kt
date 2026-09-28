package com.a20231549_app_w05

import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val edtDan = findViewById<EditText>(R.id.edtDan)
        val btnOutput = findViewById<Button>(R.id.btnOutput)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        edtDan?.setOnClickListener {
            try {
                val imm = getSystemService(INPUT_METHOD_SERVICE) as? InputMethodManager
                imm?.showSoftInput(edtDan, 0)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        btnOutput?.setOnClickListener {
            try {
                val strDan = edtDan?.text?.toString()?.trim() ?: ""
                val danNumber = strDan.toIntOrNull()

                if (danNumber == null) {
                    tvResult?.text = getString(R.string.null_text)
                } else {
                    val resultBuilder = StringBuilder()
                    resultBuilder.append("< $danNumber 단 >\n\n")

                    for (i in 1..9) {
                        resultBuilder.append("$danNumber x $i = ${danNumber * i}\n")
                    }

                    tvResult?.text = resultBuilder.toString().trimEnd()
                }
            } catch (e: Exception) {
                e.printStackTrace()
                tvResult?.text = getString(R.string.null_text)
            }
        }
    }
}
