package Psicologo;

import java.util.HashSet;

import Clinica.Clinica;
import Consulta.Consulta;
/***
 * Cada Psicologo tem um nome, apenas uma clinica, e varias consultas.
 */
public class Psicologo {
    private String nome;
    private Clinica clinica;
    protected HashSet<Consulta> calendario;


    public Psicologo(String nome, Clinica clinica) {
        this.nome = nome;
        this.clinica = clinica;
        this.calendario = new HashSet<Consulta>();
    }


    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Clinica getClinica() {
        return this.clinica;
    }

    public HashSet<Consulta> getCalendario() {
        return this.calendario;
    }



    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Psicologo)) {
            return false;
        }
        Psicologo psicologo = (Psicologo) o;
        return (nome == psicologo.nome) && (clinica == psicologo.clinica);
    }

    @Override
    public String toString() {
        return "{" +
            " nome='" + getNome() + "'" +
            ", clinica='" + getClinica() + "'" +
            ", calendario='" + getCalendario() + "'" +
            "}";
    }
    

}
