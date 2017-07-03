package com.qualson.kotlin_mvvm_live_databinding_sample.data.remote

import com.google.gson.GsonBuilder
import com.qualson.kotlin_mvvm_live_databinding_sample.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by ykim on 2017. 4. 11..
 */

interface ImgurService {

//    @GET("/3/gallery/{section}/{sort}/{window}/{page}.json")
//    fun getGallery(
//            @Path("section") section: String, @Path("sort") sort: String): Observable<GalleryResponse>

    object Factory {
        @JvmStatic fun makeImugurService(): ImgurService {
            val logging = HttpLoggingInterceptor()
            logging.level = if (BuildConfig.DEBUG)
                HttpLoggingInterceptor.Level.BODY
            else
                HttpLoggingInterceptor.Level.NONE

            val okHttpClient = OkHttpClient.Builder() //
                    .addInterceptor(logging)  //
                    .addInterceptor { chain ->
                        val request = chain.request()
                                .newBuilder()
                                .addHeader("Authorization", "Client-ID fb89f7a636907c2")
                                .build()
                        chain.proceed(request)
                    } //
                    .build()

            val gson = GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create()

            val retrofit = Retrofit.Builder() //
                    .baseUrl(ENDPOINT) //
                    .client(okHttpClient) //
                    .addConverterFactory(GsonConverterFactory.create(gson)) //
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) //
                    .build()
            return retrofit.create(ImgurService::class.java)
        }
    }

    companion object {

        val ENDPOINT = "https://api.imgur.com"
    }
}
