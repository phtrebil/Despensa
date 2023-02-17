package br.com.pedro.despensa.data

import br.com.pedro.despensa.model.Despensa
import retrofit2.Call
import retrofit2.http.*

interface DespensaService {

    @GET("despensa.json")
    fun buscaTodas(): Call<List<Despensa>>

}