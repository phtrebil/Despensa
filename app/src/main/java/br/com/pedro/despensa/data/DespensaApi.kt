package br.com.pedro.despensa.data

import retrofit2.http.*

class DespensaApi {

    @GET("despensa.json")
    suspend fun buscaTodas() {
    }

}