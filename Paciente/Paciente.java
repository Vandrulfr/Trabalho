package Paciente;

import java.io.Serializable;

import Abstract.Model;
/***
 * Um paciente guarda o dado de sua proxima consulta, caso exista, seu nome, e uma bool que diz se é sua primeira consulta
 * (Quando estava pesquisando vi que alguns locais tinham precos diferentes para a primeira consulta.
 * Além disso imagino que seja uma informação util de se ter.)
 * Também adicionei um campo CPF para poder encontrar pacientes com nomes iguais
 * */
public class Paciente extends Model implements Serializable {
    static final long serialVersionUID = 1l;
    private String nome;
    public int id;
    long cpf;
    boolean primeira_consulta = true;
    int proxima_consulta = -1;

    public Paciente(String nome, long cpf){
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public long getCpf() {
        return cpf;
    }


    public boolean isPrimeira_consulta() {
        return this.primeira_consulta;
    }

    public boolean getPrimeira_consulta() {
        return this.primeira_consulta;
    }

    public void setPrimeira_consulta(boolean primeira_consulta) {
        this.primeira_consulta = primeira_consulta;
    }

    public int getProxima_consulta() {
        return this.proxima_consulta;
    }

    public void setProxima_consulta(int proxima_consulta) {
        this.proxima_consulta = proxima_consulta;
    }

    protected static Paciente leDeArquivo(String nome){
        return ((Paciente) Model.leDeArquivo(nome));
    }

    @Override
    public String toString() { //TODO: Adaptar
        return "{" +
            " nome='" + getNome() + "'" +
            ", cpf='" + getCpf() + "'" +
            ", primeira_consulta='" + isPrimeira_consulta() + "'" +
            ", proxima_consulta='" + getProxima_consulta() + "'" +
            "}";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Paciente)) {
            return false;
        }
        Paciente paciente = (Paciente) o;
        return cpf == paciente.cpf;
    }


}
