import com.quito.santiago.lab_sustitutorio.Usuario
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("posts")
    fun getUsuarios(): Call<List<Usuario>>
}
