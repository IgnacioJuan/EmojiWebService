package com.juanguachi.webservice;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private final String baseUrl="https://emojihub.herokuapp.com/";
    List<Emoji> emojiList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void listar(View view){
        Retrofit retrofit=new Retrofit.Builder().baseUrl(baseUrl).
                addConverterFactory(GsonConverterFactory.create())
                .build();
        EmojiService emojiService=retrofit.create(EmojiService.class);

        Call<List<Emoji>> lista=emojiService.getEmojis();
        lista.enqueue(new Callback<List<Emoji>>() {
            @Override
            public void onResponse(Call<List<Emoji>> call, Response<List<Emoji>> response) {
                if(response.isSuccessful()){
                    emojiList=response.body();

                    ArrayList<String>EmojisString=new ArrayList<>();
                    for(int i=0;emojiList.size()>i;i++){
                        EmojisString.add(emojiList.get(i).toString());
                    }

                    ArrayList<String>Emojisnombres=new ArrayList<>();
                    for(int i=0;emojiList.size()>i;i++){
                        Emojisnombres.add(emojiList.get(i).getName());
                    }
                    ListView listView=(ListView) findViewById(R.id.listEmojis);
                    ArrayAdapter adaptador = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, EmojisString);
                    listView.setAdapter(adaptador);

                }
            }
            @Override
            public void onFailure(Call<List<Emoji>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_LONG).show();
            }
        });
    }

}