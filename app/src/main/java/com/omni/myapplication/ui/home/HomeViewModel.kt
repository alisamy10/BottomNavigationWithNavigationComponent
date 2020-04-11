package com.omni.myapplication.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.omni.myapplication.data.DataSource
import com.omni.myapplication.data.Model

class HomeViewModel : ViewModel() {

    private var list :MutableLiveData<List<Model>> = MutableLiveData<List<Model>>()

    fun getData () :LiveData<List<Model>>{
        list.postValue(DataSource.getdata())

        return list
    }



}