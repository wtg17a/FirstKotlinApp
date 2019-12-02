package com.example.notfirstapp

import android.app.PendingIntent.getActivity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity()
{
    var pword : String = ""
    var correct = false
    var numCorrect = 0

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var submitButton : Button = findViewById(R.id.button)
        var guessBox : EditText = findViewById(R.id.editText)
        var logBox : TextView = findViewById(R.id.textView)
        pword = getString(R.string.password)

        submitButton.setOnClickListener(object: View.OnClickListener
        {
            override fun onClick(view: View)
            {
                if(guessBox.text.length == 8)
                {
                    numCorrect = 0

                    for (i in pword.indices)
                    {
                        if(guessBox.text[i] == pword[i])
                        {
                            ++numCorrect
                        }
                    }

                    if(numCorrect == pword.length)
                    {
                        correct = true
                    }
                    else
                    {
                        logBox.append("${guessBox.text} \n")
                        logBox.append("$numCorrect out of ${pword.length} correct \n")
                    }
                }

                if(correct)
                {
                    val intent = Intent(this@MainActivity, WinActivity::class.java)
                    startActivity(intent)
                }
            }
        })
    }
}
