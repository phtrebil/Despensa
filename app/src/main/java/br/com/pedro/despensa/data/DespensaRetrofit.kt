package br.com.pedro.despensa.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class DespensaRetrofit {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://phtrebil.github.io/Despensa_Api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val despensaService = retrofit.create(DespensaService::class.java)
}