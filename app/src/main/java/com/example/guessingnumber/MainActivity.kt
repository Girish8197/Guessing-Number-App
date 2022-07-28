package com.example.guessingnumber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        var text:String = ""
        var minn : Int = 0
        var maxn : Int = 0
        var random_number:Int=0
        var chance : Int = 5
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        check.isEnabled = false
        start.setOnClickListener{
            if(min.text.toString() == "" || max.text.toString() == "") {
                Toast.makeText(this, "Enter max and min number", Toast.LENGTH_SHORT).show()
            }else
                if(!isNumeric(min.text.toString()) || !isNumeric(max.text.toString()))
                {
                    Toast.makeText(this,"Enter Valid number",Toast.LENGTH_SHORT).show()
                }else{
                    text = min.text.toString()
                    minn = text.toInt()
                    text = max.text.toString()
                    maxn = text.toInt()
                }

                    if(minn >= maxn)
                    {
                        Toast.makeText(this,"Enter Valid min and max number",Toast.LENGTH_SHORT).show()
                    }else{
                        random_number = Random.nextInt(minn,maxn+1)
                        Toast.makeText(this,"You have 5 chance to guess the number",Toast.LENGTH_SHORT).show()
                        start.isEnabled = false
                        check.isEnabled = true
                    }
        }
        check.setOnClickListener{
            if(num.text.toString() == ""){
                Toast.makeText(this,"Enter Number",Toast.LENGTH_SHORT).show()
            }else
            {
                chance--
                if(chance>0){
                    text = num.text.toString()
                    var number = text.toInt()
                    if(number == random_number){
                        Toast.makeText(this,"Congratulation! You won",Toast.LENGTH_SHORT).show()
                        check.isEnabled = false
                    }else
                        if(number < random_number){
                            Toast.makeText(this,"You Guessed smaller number",Toast.LENGTH_SHORT).show()
                        }else{
                            Toast.makeText(this,"You Guessed larger number",Toast.LENGTH_SHORT).show()
                        }
                }else{
                    Toast.makeText(this,"Game Over the number is "+random_number,Toast.LENGTH_SHORT).show()
                    check.isEnabled = false
                }
            }
        }
        restart.setOnClickListener {
            min.setText("")
            max.setText("")
            num.setText("")
            start.isEnabled = true
            check.isEnabled = false
        }
    }
    fun isNumeric(number:String):Boolean{
            return number.all{char -> char.isDigit()}
    }
}