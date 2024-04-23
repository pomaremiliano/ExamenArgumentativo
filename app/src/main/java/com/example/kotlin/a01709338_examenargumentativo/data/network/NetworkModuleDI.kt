import com.example.kotlin.a01709338_examenargumentativo.data.network.ApiService
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkModuleDI {
    private val gsonFactory: GsonConverterFactory = GsonConverterFactory.create(GsonBuilder().create())

    private val apiKeyInterceptor = Interceptor { chain ->
        val originalRequest = chain.request()
        val newRequest = originalRequest.newBuilder()
            .header("x-api-key", "wLVPN1zV08lJYF7uXqgyPw==zVwp6TlVcAO1NLUf")
            .build()
        chain.proceed(newRequest)
    }

    private val okHttpClient: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(apiKeyInterceptor)
        .build()

    fun makeRetrofitService(): ApiService {
        return Retrofit.Builder()
            .baseUrl("https://api.api-ninjas.com/v1/dnslookup?domain=") // Updated the base URL, remove specific endpoint if not needed
            .client(okHttpClient)
            .addConverterFactory(gsonFactory)
            .build()
            .create(ApiService::class.java)
    }
}
