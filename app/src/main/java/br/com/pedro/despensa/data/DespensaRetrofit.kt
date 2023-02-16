package br.com.pedro.despensa.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class DespensaRetrofit {

    private var INSTANCE: DespensaApi? = null

    fun getInstance(): DespensaApi? {
        if (INSTANCE == null) {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://phtrebil.github.io/Despensa_Api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            INSTANCE = retrofit.create(DespensaApi::class.java)
        }
        return INSTANCE
    }
}