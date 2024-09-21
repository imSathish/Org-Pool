package com.example.orgcarpool.features.create

import androidx.lifecycle.ViewModel
import com.example.orgcarpool.data.remote.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CreateTripViewModel @Inject constructor(
    private val apiService: ApiService
) : ViewModel() {
}