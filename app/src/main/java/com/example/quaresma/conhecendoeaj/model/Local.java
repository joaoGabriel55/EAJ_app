package com.example.quaresma.conhecendoeaj.model;

import com.google.android.gms.maps.model.LatLng;

import java.util.Date;

/**
 * Created by Quaresma on 20/10/2017.
 */

public class Local {
    private int imagem;
    private String nome;
    private String coordenador;
    private String horaFuncionamento;
    private String contato;
    private String descricao;
    private LatLng lat_long;


    public Local(int imagem, String nome, String coordenador, String horaFuncionamento, String contato, String descricao, LatLng lat_long) {
        this.imagem = imagem;
        this.nome = nome;
        this.coordenador = coordenador;
        this.horaFuncionamento = horaFuncionamento;
        this.contato = contato;
        this.descricao = descricao;
        this.lat_long = lat_long;
    }



    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCoordenador() {
        return coordenador;
    }

    public void setCoordenador(String coordenador) {
        this.coordenador = coordenador;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getHoraFuncionamento() {
        return horaFuncionamento;
    }

    public void setHoraFuncionamento(String horaFuncionamento) {
        this.horaFuncionamento = horaFuncionamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LatLng getLat_long() {
        return lat_long;
    }

    public void setLat_long(LatLng lat_long) {
        this.lat_long = lat_long;
    }
}
