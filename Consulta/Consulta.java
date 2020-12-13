package Consulta;


import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import Abstract.Model;
import Paciente.Paciente;
import Psicologo.Psicologo;

/*** Uma consulta tem uma um paciente, um psicologo, data, horario de começo e fim.
 * Cada consulta dura exatamente uma hora
 */
public class Consulta extends Model implements Serializable{
    static final long serialVersionUID = 1l;
    private int paciente;
    private int psicologo;
    private LocalDate data;
    private LocalTime horario_inicio;
    private LocalTime horario_fim;


    public Consulta(int psicologo, int paciente){
        this.paciente = paciente;
        this.psicologo = psicologo;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente.getId();
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setHorario_inicio(LocalTime horario_inicio) {
        this.horario_inicio = horario_inicio;
        this.horario_fim = horario_inicio.plusHours(1);
    }

    public void setPsicologo(Psicologo psicologo) {
        this.psicologo = psicologo.getId();
    }

    public int getPaciente() {
        return this.paciente;
    }

    public int getPsicologo() {
        return this.psicologo;
    }

    public LocalDate getData() {
        return this.data;
    }

    public LocalTime getHorario_inicio() {
        return this.horario_inicio;
    }

    public LocalTime getHorario_fim() {
        return this.horario_fim;
    }

    protected static Consulta leDeArquivo(String nome){
        return ((Consulta) Model.leDeArquivo(nome));
    }
    

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Consulta)) {
            return false;
        }
        Consulta consulta = (Consulta) o;
        return 
            (psicologo == (consulta.getPsicologo())) && 
            (data.equals(consulta.getData())) && 
            (horario_inicio.equals(consulta.getHorario_inicio()));
    }

    @Override
    public String toString() {
        return 
            "paciente: " + getPaciente() +
            "\npsicologo: " + getPsicologo() +
            "\ndata: " + getData() +
            "\nhorario_inicio: " + getHorario_inicio()+
            "\nhorario_fim: " + getHorario_fim();
    }

    
}
