package com.juanguachi.webservice;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface EmojiService {
    @GET("api/all")
    Call<List<Emoji>> getEmojis();
}
