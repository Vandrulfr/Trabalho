package Psicologo;

import java.io.Serializable;
import java.util.ArrayList;

import Abstract.Model;
import Clinica.Clinica;
import Consulta.Consulta;
/***
 * Cada Psicologo tem um nome, apenas uma clinica, e varias consultas.
 */
public class Psicologo extends Model implements Serializable {
    static final long serialVersionUID = 1l;
    private String nome;
    private int clinica;
    protected ArrayList<Integer> consultas;
    public int id;


    public Psicologo(String nome, Clinica clinica) {
        this.nome = nome;
        this.clinica = clinica.getId();
        this.consultas = new ArrayList<Integer>();
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    protected static Psicologo leDeArquivo(String nome){
        return ((Psicologo) Model.leDeArquivo(nome));
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getClinica() {
        return this.clinica;
    }

    public ArrayList<Integer> getConsultas() {
        return this.consultas;
    }

    public void addConsulta(Consulta consulta){
        consultas.add(consulta.getId());
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Psicologo)) {
            return false;
        }
        Psicologo psicologo = (Psicologo) o;
        return (nome.equals(psicologo.getNome()) && 
            (clinica == (psicologo.getClinica())));
    }

    @Override
    public String toString() {
        return 
            "ID: " + getId() +
            "\nnome: " + getNome() +
            "\nclinica: " + getClinica() +
            "\nconsultas: " + getConsultas()
            ;
    }
    

}
