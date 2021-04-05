package com.eiosm.client.helpers;

import android.content.Context;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class ApiClient {
    private Context _context;
    private RequestQueue _queue;
    public ApiClient(Context context){
        // Instantiate the cache
        Cache cache = new DiskBasedCache(_context.getCacheDir(), 1024 * 1024); // 1MB cap

        // Set up the network to use HttpURLConnection as the HTTP client.
        Network network = new BasicNetwork(new HurlStack());

        // Instantiate the RequestQueue with the cache and network.
        this._queue = new RequestQueue(cache, network);

        // Start the queue
        this._queue.start();
    }
    public ApiClient(String apiAddress) {

        RequestQueue queue = Volley.newRequestQueue(_context);
        String url = "https://www.google.com";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                (String response) -> {
                    // Display the first 500 characters of the response string.
                    //textView.setText("Response is: "+ response.substring(0,500));
                }, (VolleyError error) -> {
                    //textView.setText("That didn't work!");
                });

// Add the request to the RequestQueue.
        queue.add(stringRequest);
    }
}
