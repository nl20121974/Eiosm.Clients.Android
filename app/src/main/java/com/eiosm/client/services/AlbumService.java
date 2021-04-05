package com.eiosm.client.services;

import android.content.Context;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.eiosm.client.helpers.ApiClient;
import com.eiosm.client.models.Album;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class AlbumService {
    private String _url;
    private Context _context;
    private final Gson _gson;

    public AlbumService(Context context) {
        this._context = context;
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setDateFormat("M/d/yy hh:mm a");
        _gson = gsonBuilder.create();
    }

    public void GetAlbums(int userId) {
        StringRequest request = new StringRequest(this._url, onLoaded, onError);
    }

    private final Response.Listener<String> onLoaded = new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            List<Album> posts = Arrays.asList(_gson.fromJson(response, Album[].class));
            Log.i("AlbumService", response);
        }
    };

    private final Response.ErrorListener onError = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Log.e("AlbumService", error.toString());

        }
    };
}
