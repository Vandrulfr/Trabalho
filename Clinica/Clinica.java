package Clinica;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

//import Consulta.Consulta;
import Psicologo.Psicologo;
/***
 * A clinica possui um endereço (Cidade, bairro, e duas linhas de endereco (Rua, numero, etc)),
 * E um set de psicologos.
 * Os psicologos guardam os dados das consultas (para mais detalhes ver model de Psicologo)
 */
public class Clinica implements Serializable{
    static final long serialVersionUID = 1l;
    protected int id;
    private String cidade;
    private String bairro;
    private String endereco_0;
    private String endereco_1;
    private ArrayList<Psicologo> psicologos;
    // clinica n precisa de calendario pois o psicologo ja tem calendario
    //private HashSet<Consulta> calendario;


    public Clinica() {
    }

    protected void escreveEmArquivo(String nome){
        try{
            FileOutputStream fos = new FileOutputStream(nome);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this);
            oos.close();
        }catch(Exception e){System.out.println(e);}
    }
    protected static Clinica leDeArquivo(String nome){
        try {
            FileInputStream fin = new FileInputStream(nome);
            ObjectInputStream ois = new ObjectInputStream(fin);
            Clinica clinicaArquivo = (Clinica) ois.readObject();
            ois.close();
            return clinicaArquivo;
        } catch (Exception e){System.out.println(e); return null;}
    }
    
    public Clinica(String cidade, String bairro, String endereco_0, String endereco_1){
        this.cidade = cidade;
        this.bairro = bairro;
        this.endereco_0 = endereco_0;
        this.endereco_1 = endereco_1;
        this.psicologos = new ArrayList<Psicologo>();
        //this.calendario = new HashSet<Consulta>();
    }


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
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

    public ArrayList<Psicologo> getPsicologos() {
        return this.psicologos;
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
        return ((this.cidade.equals(clinica.getCidade())) && (this.bairro.equals(clinica.getBairro())) && (this.endereco_0.equals(clinica.getEndereco_0())) && (this.endereco_1.equals(clinica.getEndereco_1()))) ;
    }


    @Override
    public String toString() {
        return 
            "Cidade: " + getCidade() +
            "\nbairro: " + getBairro() +
            "\nendereco_0: " + getEndereco_0() + 
            "\nendereco_1: " + getEndereco_1() + 
            "\npsicologos: " + getPsicologos()
            ;
    }

    

    
}
