package com.eiosm.client.services;

import com.microsoft.signalr.HubConnectionBuilder;

import io.reactivex.Single;

public interface ILiveService {
    public void Start();

    public void Stop();

    public void SendMessage();
}
