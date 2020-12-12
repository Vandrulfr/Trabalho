package Clinica;

import java.io.Serializable;
import java.util.ArrayList;

import Abstract.Model;
//import Consulta.Consulta;
import Psicologo.Psicologo;
/***
 * A clinica possui um endereço (Cidade, bairro, e duas linhas de endereco (Rua, numero, etc)),
 * E um set de psicologos.
 * Os psicologos guardam os dados das consultas (para mais detalhes ver model de Psicologo)
 */
public class Clinica extends Model implements Serializable{
    static final long serialVersionUID = 1l;
    protected int id;
    private String cidade;
    private String bairro;
    private String endereco_0;
    private String endereco_1;
    private ArrayList<Integer> psicologos;
    // clinica n precisa de calendario pois o psicologo ja tem calendario
    //private HashSet<Consulta> calendario;


    public Clinica() {
    }

    protected static Clinica leDeArquivo(String nome){
        return (Clinica) Model.leDeArquivo(nome);
    } 
    
    public Clinica(String cidade, String bairro, String endereco_0, String endereco_1){
        this.cidade = cidade;
        this.bairro = bairro;
        this.endereco_0 = endereco_0;
        this.endereco_1 = endereco_1;
        this.psicologos = new ArrayList<Integer>();
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

    public ArrayList<Integer> getPsicologos() {
        return this.psicologos;
    }

    public void addPsicologo(Psicologo psicologo){
        this.psicologos.add(psicologo.getId());
    }

    // public HashSet<Consulta> getCalendario() {
    //     return this.calendario;
    // }



    @Override
    public boolean equals(Object o) {
        if (o == this){
            return true;
        }
        if (!(o instanceof Clinica)) {
            return false;
        }
        Clinica clinica = (Clinica) o;
        return (cidade.equals(clinica.getCidade())) &&
            (bairro.equals(clinica.getBairro())) &&
            (endereco_0.equals(clinica.getEndereco_0())) &&
            (endereco_1.equals(clinica.getEndereco_1()));
    }


    @Override
    public String toString() {
        return 
            "ID: " + getId() + 
            "\ncidade: " + getCidade() +
            "\nbairro: " + getBairro() +
            "\nendereço: " + getEndereco_0() + 
            "\n" + getEndereco_1() + 
            "\npsicologos: " + getPsicologos()
            ;
    }

    

    
}
