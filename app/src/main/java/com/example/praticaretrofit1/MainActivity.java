package com.example.praticaretrofit1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.praticaretrofit1.interfaces.ProductoAPI;
import com.example.praticaretrofit1.models.Producto;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    EditText edtCodigo;
    TextView tvCodigo, tvDescripcion, tvPrecio;
    Button btnBuscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtCodigo = findViewById(R.id.edtCodigo);
        tvCodigo = findViewById(R.id.tvCodigo);
        tvDescripcion = findViewById(R.id.tvDescripcion);
        tvPrecio = findViewById(R.id.tvPrecio);
        btnBuscar = findViewById(R.id.btnBuscar);

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String valor=edtCodigo.getText().toString();
                int v1=Integer.parseInt(valor);
                buscarPorId(v1);
            }
        });
    }

    private void buscarPorId(int codigo) {

        //construimos una instancia con retrofit y le pasamos la URL base
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://23.251.151.4/").addConverterFactory(GsonConverterFactory.create()).build();

        //usamos la intrfaz productoAPI
        ProductoAPI productoAPI=retrofit.create(ProductoAPI.class);

        //realizamos la llamada HTTP implementando el creado en PorductoAPI
        Call<Producto> call=productoAPI.find(codigo);

        //recibimos la respuesta asincrona
        call.enqueue(new Callback<Producto>() {
            @Override
            public void onResponse(Call<Producto> call, Response<Producto> response) {
                try {
                    if (response.code() == 200){
                        //creamos un obj de la clase producto y accedemos al cuerpo de la respuesta
                        Producto producto=response.body();
                        tvCodigo.setText(String.valueOf(producto.getIdLugares().getNombre()));
                        tvDescripcion.setText(producto.getNombre());
                        tvPrecio.setText(producto.getCosto());
                    }
                } catch (Exception exception){
                    Toast.makeText(MainActivity.this, exception.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Producto> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error de conexion", Toast.LENGTH_SHORT).show();
            }
        });


    }



}