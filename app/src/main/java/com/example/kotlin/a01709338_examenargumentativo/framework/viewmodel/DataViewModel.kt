import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin.a01709338_examenargumentativo.data.network.ApiRepository
import com.example.kotlin.a01709338_examenargumentativo.data.network.model.ApiObject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DataViewModel(private val repository: ApiRepository) : ViewModel() {
    private val _data = MutableLiveData<ApiObject?>()
    val data: LiveData<ApiObject?> = _data

    fun getAllData() {
        viewModelScope.launch(Dispatchers.IO) { // Mover la ejecución a un contexto de I/O
            val result: ApiObject? = repository.getAllData()
            _data.postValue(result) // Actualizar el LiveData en el hilo principal
        }
    }
}
