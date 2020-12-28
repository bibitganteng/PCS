package com.bibitaries.sepakbola.ui.olahraga

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bibitaries.sepakbola.data.model.ActionState
import com.bibitaries.sepakbola.data.model.Olahraga
import com.bibitaries.sepakbola.data.repository.OlahragaRepository
import kotlinx.coroutines.launch

class OlahragaViewModel : ViewModel() {
    private val repo: OlahragaRepository by lazy { OlahragaRepository() }

    val loading =  MutableLiveData( false)
    val actionState = MutableLiveData<ActionState<*>>()

    val listResp = MutableLiveData<List<Olahraga>>()
    val detailResp = MutableLiveData<Olahraga>()
    val searchResp = MutableLiveData<List<Olahraga>>()

    val url = MutableLiveData("")
    val query = MutableLiveData("")

    fun listOlahraga() {
        viewModelScope.launch {
            loading.value = true
            val resp = repo.listOlahraga()
            actionState.value = resp
            listResp.value = resp.data
            loading.value = false
        }
    }

    fun detailOlahraga(url: String? = this.url.value) {
        url?.let {
            viewModelScope.launch {
                loading.value = true
                val resp = repo.detailOlahraga(it)
                actionState.value = resp
                detailResp.value = resp.data
                loading.value = false
            }
        }
    }
    fun searchOlahraga(query: String? = this.query.value) {
        query?.let {
            viewModelScope.launch {
                loading.value = true
                val resp = repo.searchOlahraga(it)
                actionState.value = resp
                searchResp.value = resp.data
                loading.value = false
            }
        }
    }
}