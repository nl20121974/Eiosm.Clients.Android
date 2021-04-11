package com.eiosm.client.helpers;

public class DataService<T> {

    private static DataService _instance;
    protected T _serviceClient;

    public DataService(Class<T> type, String uri) {
        _serviceClient = RetrofitService.Create(type, uri);
    }

    public static <T> DataService getInstance(Class<T> type, String uri) {
        if (_instance == null)
            _instance = new DataService(type, uri);
        return _instance;
    }
}