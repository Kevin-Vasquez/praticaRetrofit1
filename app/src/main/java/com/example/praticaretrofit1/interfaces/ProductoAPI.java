package com.example.praticaretrofit1.interfaces;

import com.example.praticaretrofit1.models.Producto;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ProductoAPI {

    @GET("/ApiSivar/Transporte/{id}")
    //usamos la clase call y la clase producto le colocamos find de nombre
    //luego recibimos desde la URL
    public Call<Producto> find(@Path("id")int id);

}
