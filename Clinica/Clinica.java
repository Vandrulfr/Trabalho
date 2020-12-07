package Clinica;

import java.util.HashSet;

import Consulta.Consulta;
import Psicologo.Psicologo;

public class Clinica{
    String cidade;
    String bairro;
    String endereco_0;
    String endereco_1;
    HashSet<Psicologo> psicologos;
    HashSet<Consulta> calendario;


    public Clinica() {
    }
    
    public Clinica(String cidade, String bairro, String endereco_0, String endereco_1){
        this.cidade = cidade;
        this.bairro = bairro;
        this.endereco_0 = endereco_0;
        this.endereco_1 = endereco_1;
    }


    public String getCidade() {
        return this.cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return this.bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEndereco_0() {
        return this.endereco_0;
    }

    public void setEndereco_0(String endereco_0) {
        this.endereco_0 = endereco_0;
    }

    public String getEndereco_1() {
        return this.endereco_1;
    }

    public void setEndereco_1(String endereco_1) {
        this.endereco_1 = endereco_1;
    }

    public HashSet<Psicologo> getPsicologos() {
        return this.psicologos;
    }

    public HashSet<Consulta> getCalendario() {
        return this.calendario;
    }

    

    
}
