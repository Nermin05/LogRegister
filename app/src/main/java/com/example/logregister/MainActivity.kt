package com.example.logregister
import android.content.Intent
import android.graphics.PorterDuff
import android.os.Bundle
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
        val createAccount = findViewById<TextView>(R.id.create)
        createAccount.setOnClickListener {
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }
        val email=findViewById<TextView>(R.id.email)
        email.setOnClickListener {
            email.setTextColor(getResources().getColor(R.color.green1))
            val drawables = email.compoundDrawables
            val drawableStart = drawables[0]
            drawableStart?.setColorFilter(
                resources.getColor(R.color.green1),
                PorterDuff.Mode.SRC_IN
            )
        }
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        }
    }
