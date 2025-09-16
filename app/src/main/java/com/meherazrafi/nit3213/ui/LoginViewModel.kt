package com.meherazrafi.nit3213.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.meherazrafi.nit3213.data.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repo: AuthRepository
) : ViewModel() {

    /**
     * Performs login and returns the keypass string.
     * Throws on failure so the caller can catch and show a message.
     */
    suspend fun login(username: String, password: String, campus: String): String {
        return repo.login(username, password, campus) // returns keypass from your repo
    }
}
