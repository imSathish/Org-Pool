package com.example.orgcarpool.features.login

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.orgcarpool.Constants.IS_LOGGED_IN
import com.example.orgcarpool.Constants.USER_EMAIL
import com.example.orgcarpool.Constants.USER_NAME
import com.example.orgcarpool.Constants.USER_PREF
import com.example.orgcarpool.data.remote.ApiService
import com.example.orgcarpool.data.remote.response.User
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(@ApplicationContext private val appContext: Context) : ViewModel() {

    @Inject
    lateinit var service: ApiService

    private val _isUserLoggedIn: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val isUserLoggedIn = _isUserLoggedIn.asStateFlow()

    fun login(name: String, email: String) {
        viewModelScope.launch {
            val user = service.login(name, email)
            storeUser(user)
            _isUserLoggedIn.emit(true)
        }
    }

    private fun storeUser(user: User) {
        appContext.getSharedPreferences(USER_PREF, Context.MODE_PRIVATE)
            .edit()
            .putBoolean(IS_LOGGED_IN, true)
            .putString(USER_NAME, user.name)
            .putString(USER_EMAIL, user.email)
            .apply()
    }

}