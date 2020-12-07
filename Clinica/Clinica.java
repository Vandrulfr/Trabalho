package Clinica;

import java.util.HashSet;

//import Consulta.Consulta;
import Psicologo.Psicologo;
/***
 * A clinica possui um endereço (Cidade, bairro, e duas linhas de endereco (Rua, numero, etc)),
 * E um set de psicologos.
 * Os psicologos guardam os dados das consultas (para mais detalhes ver model de Psicologo)
 */
public class Clinica{
    private String cidade;
    private String bairro;
    private String endereco_0;
    private String endereco_1;
    private HashSet<Psicologo> psicologos;
    // clinica n precisa de calendario pois o psicologo ja tem calendario
    //private HashSet<Consulta> calendario;


    public Clinica() {
    }
    
    public Clinica(String cidade, String bairro, String endereco_0, String endereco_1){
        this.cidade = cidade;
        this.bairro = bairro;
        this.endereco_0 = endereco_0;
        this.endereco_1 = endereco_1;
        this.psicologos = new HashSet<Psicologo>();
        //this.calendario = new HashSet<Consulta>();
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

    // public HashSet<Consulta> getCalendario() {
    //     return this.calendario;
    // }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Clinica)) {
            return false;
        }
        Clinica clinica = (Clinica) o;
        return (cidade == clinica.cidade) && (bairro == clinica.bairro) && (endereco_0 == clinica.endereco_0) && (endereco_1 == clinica.endereco_1) ;
    }


    @Override
    public String toString() {
        return "{" +
            " cidade='" + getCidade() + "'" +
            ", bairro='" + getBairro() + "'" +
            ", endereco_0='" + getEndereco_0() + "'" +
            ", endereco_1='" + getEndereco_1() + "'" +
            ", psicologos='" + getPsicologos() + "'" +
            "}";
    }

    

    
}
