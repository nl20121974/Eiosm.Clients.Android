package com.eiosm.client.models;

import com.google.gson.annotations.SerializedName;

public class Album {
    @SerializedName("id")
    private int Id;
    @SerializedName("id")
    private int MemberId;

    public Album(int id, int memberId){
        this.Id = id;
        this.MemberId = memberId;
    }

    public int getId(){
        return this.Id;
    }

    public int getMemberId(){
        return this.MemberId;
    }
}
