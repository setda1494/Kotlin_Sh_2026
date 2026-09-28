package com.a20231549_app_w05

import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
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

        val layoutGugudan = findViewById<LinearLayout>(R.id.layoutGugudan)
        val layoutGreeting = findViewById<LinearLayout>(R.id.layoutGreeting)

        val edtDan = findViewById<EditText>(R.id.edtDan)
        val btnOutput = findViewById<Button>(R.id.btnOutput)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        val edtName = findViewById<EditText>(R.id.edtName)
        val btnGreeting = findViewById<Button>(R.id.btnGreeting)
        val tvGreetingResult = findViewById<TextView>(R.id.tvGreetingResult)

        val btnTab1 = findViewById<Button>(R.id.btnTab1)
        val btnTab2 = findViewById<Button>(R.id.btnTab2)

        // 탭 전환 이벤트
        btnTab1?.setOnClickListener {
            try {
                layoutGugudan?.visibility = View.VISIBLE
                layoutGreeting?.visibility = View.GONE
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        btnTab2?.setOnClickListener {
            try {
                layoutGugudan?.visibility = View.GONE
                layoutGreeting?.visibility = View.VISIBLE
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        // 소프트 키패드 자동 팝업
        edtDan?.setOnClickListener {
            try {
                val imm = getSystemService(INPUT_METHOD_SERVICE) as? InputMethodManager
                imm?.showSoftInput(edtDan, 0)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        edtName?.setOnClickListener {
            try {
                val imm = getSystemService(INPUT_METHOD_SERVICE) as? InputMethodManager
                imm?.showSoftInput(edtName, 0)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        // 1번 앱: 구구단 출력
        btnOutput?.setOnClickListener {
            try {
                val strDan = edtDan?.text?.toString()?.trim() ?: ""
                val danNumber = strDan.replace(Regex("[^0-9]"), "").toIntOrNull()

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

        // 2번 앱: 인사 출력 ("안녕 XXX", 한글 및 영문 등 모든 이름 지원)
        btnGreeting?.setOnClickListener {
            try {
                val name = edtName?.text?.toString()?.trim() ?: ""

                if (name.isEmpty()) {
                    tvGreetingResult?.text = getString(R.string.null_text)
                } else {
                    tvGreetingResult?.text = getString(R.string.greeting_format, name)
                }
            } catch (e: Exception) {
                e.printStackTrace()
                tvGreetingResult?.text = getString(R.string.null_text)
            }
        }
    }
}
