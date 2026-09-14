package com.kotlin_20231549

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
import com.kotlin_20231549.ui.theme.Kotlin_20231549Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Kotlin_20231549Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }

        // Execute helper methods for basic Kotlin syntax
        week03Variables()
        week03Functions()
    }
}

private fun week03Variables() {
    println("Week 03: Variables")
    val courseName = "Mobile Programming" // java final (immutable)
    // courseName = "Data Structure" // error

    var week = 2
    week = 3

    println("Course : $courseName")
    println("Week : $week")
    println("========= Kotlin Variables =========")

    // val(immutable) vs var(mutable)
    val name = "Android"
    var version = 8
    println("Hi $name $version")

    val age: Int = 24
    val height: Double = 177.7
    val isStudent: Boolean = false
    println("Age: $age, Height: $height, Student: $isStudent")

    // Nullable types
    var nickname: String? = null
    nickname = "mirae"
    println("Nickname: $nickname ${nickname?.length}")
}

private fun week03Functions() {
    println("== Kotlin Functions ==")

    fun greet(name: String): String {
        return "Hello, $name!"
    }

    // Single-expression function
    fun add(a: Int, b: Int) = a + b

    // Default parameter value
    fun introduce(name: String, age: Int = 19) {
        println("My name is $name and I'm $age years old")
    }

    println(greet("Kotlin"))
    println("Sum: ${add(5, -71)}")

    introduce("Kim", 7)
    introduce("Park")
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
    Kotlin_20231549Theme {
        Greeting("Android")
    }
}
