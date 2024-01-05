// AppointmentsViewModel.kt

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AppointmentsViewModel : ViewModel() {

    private val _selectedTab = MutableLiveData<String>()
    val selectedTab: LiveData<String>
        get() = _selectedTab

    fun setSelectedTab(tab: String) {
        _selectedTab.value = tab
    }
}
