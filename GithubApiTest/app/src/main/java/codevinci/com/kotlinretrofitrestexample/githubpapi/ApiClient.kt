package codevinci.com.kotlinretrofitrestexample.githubpapi

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiClient {


    companion object {

        val baseURL: String = "https://api.github.com/"
        var retrofit: Retrofit? = null


        val client: Retrofit
            get() {

                if (retrofit == null) {
                    val httpClient = OkHttpClient.Builder()//initialize  okhttp
                    val loggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)//logging interceptor

                    httpClient.addInterceptor(loggingInterceptor)
                    httpClient.connectTimeout(20, TimeUnit.SECONDS)

                    var retrofitBuilder: Retrofit.Builder = Retrofit.Builder()
                            .baseUrl(baseURL)
                            .addConverterFactory(GsonConverterFactory.create())
                    retrofitBuilder.client(httpClient.build())//bind retrofit to okhttp
                    retrofit = retrofitBuilder.build()
                }
                return retrofit!!
            }
    }
}