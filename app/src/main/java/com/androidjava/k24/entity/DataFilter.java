package com.androidjava.k24.entity;

public class DataFilter {

    private String nama;
    private String username;
    private String password;
    private String tglLahir;
    private String alamat;
    private String jeniskelamin;

    public DataFilter(String nama, String username, String password) {
        this.nama = nama;
        this.username = username;
        this.password = password;
        this.tglLahir = tglLahir;
        this.alamat = alamat;
        this.jeniskelamin = jeniskelamin;
    }

    public String getNama() {
        return nama;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getTglLahir() {
        return tglLahir;
    }
    public String getAlamat() {
        return alamat;
    }
    public String getJeniskelamin() {
        return jeniskelamin;
    }
}