package com.example.word_guess

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var counter=1
    val wordToGuess=FourLetterWordList.getRandomFourLetterWord()
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textInput=findViewById<EditText>(R.id.UserInput)
        var guess1=findViewById<TextView>(R.id.textView7)
        var guess1Check=findViewById<TextView>(R.id.textView8)
        var guess2=findViewById<TextView>(R.id.textView9)
        var guess2Check=findViewById<TextView>(R.id.textView10)
        var guess3=findViewById<TextView>(R.id.textView11)
        var guess3Check=findViewById<TextView>(R.id.textView12)
        val guessButton=findViewById<Button>(R.id.Guess)
        var targetWord=findViewById<TextView>(R.id.textView13)

        if(counter==1){
            guessButton.setOnClickListener{
                guess1.text=textInput.text
                guess1Check.text=checkGuess(guess1.toString().uppercase())
                counter++
                textInput.text.clear()
                if(counter==2){
                    guessButton.setOnClickListener{
                        guess2.text=textInput.text
                        guess2Check.text=checkGuess(guess2.toString().uppercase())
                        counter++
                        textInput.text.clear()

                        if(counter==3){

                            guessButton.setOnClickListener{
                                Toast.makeText(it.context, "You have reached the number of guesses", Toast.LENGTH_SHORT).show()
                                guess3.text=textInput.text
                                guess3Check.text=checkGuess(guess3.toString().uppercase())
                                targetWord.text=wordToGuess
                                counter++
                                textInput.text.clear()
                            }
                            if(counter>3){
                                Toast.makeText(it.context, "You have exceeded the number of guesses", Toast.LENGTH_SHORT).show()

                            }
                        }
                    }
                }
            }
        }


    }

    private fun checkGuess(guess: String) : String {
        var result = ""
        for (i in 0..3) {
            if (guess[i] == wordToGuess[i]) {
                result += "O"
            }
            else if (guess[i] in wordToGuess) {
                result += "+"
            }
            else {
                result += "X"
            }
        }
        return result
    }


}