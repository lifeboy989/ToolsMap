import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MapViewModel(private val loadMapDataUseCase: LoadMapDataUseCase) : ViewModel() {
    private val _mapState = MutableLiveData<String>()
    val mapState: LiveData<String> get() = _mapState

    fun loadMapData() {
        viewModelScope.launch {
            val result = loadMapDataUseCase()
            result.onSuccess {
                _mapState.value = it
            }.onFailure {
                _mapState.value = "Error loading map data"
            }
        }
    }
}
