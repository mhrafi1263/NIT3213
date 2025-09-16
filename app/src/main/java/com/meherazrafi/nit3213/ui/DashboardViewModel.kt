package com.meherazrafi.nit3213.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.meherazrafi.nit3213.data.DashboardRepository
import com.meherazrafi.nit3213.data.remote.FashionItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val repo: DashboardRepository
) : ViewModel() {

    val items = MutableStateFlow<List<FashionItem>>(emptyList())
    val error = MutableStateFlow<String?>(null)

    fun load(keypass: String) {
        viewModelScope.launch {
            runCatching { repo.load(keypass) }
                .onSuccess { items.value = it.entities }
                .onFailure { error.value = it.message }
        }
    }
}
