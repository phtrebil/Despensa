package br.com.pedro.despensa.data

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


class DespensaRetrofit {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://phtrebil.github.io/Despensa_Api/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val despensaService = retrofit.create(DespensaService::class.java)
}