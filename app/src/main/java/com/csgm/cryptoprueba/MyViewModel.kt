package com.csgm.cryptoprueba

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.csgm.cryptoprueba.model.Asset
import com.csgm.cryptoprueba.model.CryptoResponse
import com.csgm.cryptoprueba.model.Repository
import kotlinx.coroutines.launch

class MyViewModel : ViewModel() {
    private val repository = Repository()

    private val assetList = MutableLiveData<CryptoResponse>()

    fun assetList(): LiveData<CryptoResponse> = assetList

    init {
        getAssets()
    }

     fun getAssets() =  viewModelScope.launch {
        assetList.value = repository.getAssets()
    }

    suspend fun getAssetDetail(id: String) {
        repository.getAssetDetail(id)
    }

    suspend fun getAsset(id: String) {
        repository.getAssetDetail(id)
    }
}
