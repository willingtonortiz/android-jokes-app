package com.wjom.parcialpasado01.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.wjom.parcialpasado01.Joke
import com.wjom.parcialpasado01.R
import com.wjom.parcialpasado01.interfaces.JokeService
import com.wjom.parcialpasado01.interfaces.RETROFIT_FORMATS
import kotlinx.android.synthetic.main.activity_joke.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class JokeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_joke)

        btnGetJoke.setOnClickListener {
            loadJoke()
        }
    }

    private fun loadJoke() {

        val retrofit = Retrofit.Builder().baseUrl("https://icanhazdadjoke.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val jokeService: JokeService = retrofit.create(JokeService::class.java)

        val request =
            jokeService.getJoke(RETROFIT_FORMATS.JSON_FORMAT, RETROFIT_FORMATS.JSON_FORMAT)

        request.enqueue(object : Callback<Joke> {
            override fun onFailure(call: Call<Joke>, t: Throwable) {
                tvJoke.text = "Activa tu conexión de internet, esto no es una broma"
            }

            override fun onResponse(call: Call<Joke>, response: Response<Joke>) {
                if (response.isSuccessful) {
                    tvJoke.text = response.body()?.joke
                }
            }
        })
    }
}
