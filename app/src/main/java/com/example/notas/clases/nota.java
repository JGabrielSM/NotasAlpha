package com.example.notas.clases;

import android.os.Parcel;
import android.os.Parcelable;

public class nota implements Parcelable {

    private String titulo;
    private String contenido;

    public nota(String titulo, String contenido) {
        this.titulo = titulo;
        this.contenido = contenido;
    }

    public nota() {
    }

    protected nota(Parcel in) {
        titulo = in.readString();
        contenido = in.readString();
    }

    public static final Creator<nota> CREATOR = new Creator<nota>() {
        @Override
        public nota createFromParcel(Parcel in) {
            return new nota(in);
        }

        @Override
        public nota[] newArray(int size) {
            return new nota[size];
        }
    };

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(titulo);
        dest.writeString(contenido);
    }
}
