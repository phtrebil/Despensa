package br.com.pedro.despensa.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import br.com.pedro.despensa.data.DespensaRetrofit
import br.com.pedro.despensa.databinding.ActivityListaDeItemBinding
import br.com.pedro.despensa.model.Despensa
import br.com.pedro.despensa.ui.adapter.ListaDeItemAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ListaDeItemActivity : AppCompatActivity() {

    private var adapter = ListaDeItemAdapter(this)
    private val binding by lazy {
        ActivityListaDeItemBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val call: Call<List<Despensa>> = DespensaRetrofit().despensaService.buscaTodas()
        buscaApi(call)
    }

    private fun buscaApi(call: Call<List<Despensa>>) {
        call.enqueue(object : Callback<List<Despensa>?> {
            override fun onResponse(
                call: Call<List<Despensa>?>,
                response: Response<List<Despensa>?>
            ) {
                configuraRecyclerView(response)
            }

            override fun onFailure(call: Call<List<Despensa>?>, t: Throwable) {
                Log.e("listaDeItens", "onFailure", t)
            }
        })
    }

    private fun configuraRecyclerView(response: Response<List<Despensa>?>) {
        adapter = ListaDeItemAdapter(baseContext, response.body()!!)
        adapter.notifyDataSetChanged()
        binding.rvListaDespensa.adapter = adapter
        binding.rvListaDespensa.setHasFixedSize(true)
        binding.rvListaDespensa.layoutManager = StaggeredGridLayoutManager(2, 1)
    }
}