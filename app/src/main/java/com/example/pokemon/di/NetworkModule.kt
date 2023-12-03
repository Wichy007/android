package com.example.pokemon.di

import com.example.pokemon.api.PokemonApi
import com.example.pokemon.model.Pokemon
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    fun provideHttpClient(): OkHttpClient{
        val logger = HttpLoggingInterceptor()
        logger.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder()
            .addInterceptor(logger)
            .build()
    }
    @Provides
    fun provideRetrofit(
        httpClient: OkHttpClient
    ): Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://my-json-server.typicode.com/jacklestyle0/jackle-st/")
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }
    @Provides
    fun providePokemonApi(
        retrofit: Retrofit
    ): PokemonApi = retrofit.create(PokemonApi::class.java)
}