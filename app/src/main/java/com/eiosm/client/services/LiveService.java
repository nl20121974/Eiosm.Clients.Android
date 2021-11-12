package com.eiosm.client.services;

import com.microsoft.signalr.HubConnection;
import com.microsoft.signalr.HubConnectionBuilder;

import io.reactivex.Single;

public class LiveService {
    private HubConnection hubConnection;
    private String url;
    private String accessToken;
    public LiveService(String url, String accessToken){
        this.url = url;
        this.accessToken = accessToken;
    }
    public void Start(){
        hubConnection = HubConnectionBuilder.create(url)
                .withAccessTokenProvider(Single.defer(() -> {
                    return Single.just(accessToken);
                })).build();
    }

    public void Stop(){
        hubConnection.stop();
    }

    public void SendMessage(){
        hubConnection.on("SendMessage", (message) -> {
            System.out.println("New Message: " + message);
        }, String.class);
    }
}
