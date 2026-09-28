package com.kotlinbasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.kotlinbasics.ui.theme.KotlinBasicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KotlinBasicsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
        // Logic demonstration calls
        week03Variables()
        week03Functions()
    }

    private fun week03Variables() {
        val courseName = "Mobile Programming"
        var week = 3

        val age: Int = 24
        val height: Double = 177.7
        val isStudent: Boolean = false

        // Null safety example
        var nickname: String? = null
        nickname = "mirae"
        println("Nickname: $nickname ${nickname?.length}")
    }

    private fun week03Functions() {
        fun greet(name: String): String {
            return "Hello, $name!"
        }

        fun add(a: Int, b: Int) = a + b

        fun introduce(name: String, age: Int = 19) {
            println("My name is $name and I'm $age years old")
        }

        println(greet("Kotlin"))
        introduce("Park") // Uses default age of 19
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KotlinBasicsTheme {
        Greeting("Android")
    }
}
