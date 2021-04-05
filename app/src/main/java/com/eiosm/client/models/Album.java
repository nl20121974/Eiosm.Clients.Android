package com.eiosm.client.models;

public class Album {
    private int Id;
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
