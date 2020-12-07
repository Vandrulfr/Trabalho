package Consulta;


import java.sql.Date;
import java.sql.Time;

import Clinica.Clinica;
import Paciente.Paciente;
import Psicologo.Psicologo;

public class Consulta {
    private Clinica clinica;
    private Paciente paciente;
    private Psicologo psicologo;
    private Date data;
    private Time horario_inicio;
    private Time horario_fim;


    public Consulta(Clinica clinica) {
        this.clinica = clinica;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setHorario_inicio(Time horario_inicio) {
        this.horario_inicio = horario_inicio;
    }

    public void setHorario_fim(Time horario_fim) {
        this.horario_fim = horario_fim;
    }

    public void setPsicologo(Psicologo psicologo) {
        this.psicologo = psicologo;
    }




    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Consulta)) {
            return false;
        }
        Consulta consulta = (Consulta) o;
        return (clinica == consulta.clinica) &&
            (psicologo == consulta.psicologo) && 
            (data == consulta.data) && 
            (horario_inicio == consulta.horario_inicio) && 
            (horario_fim == consulta.horario_fim);
    }

    
}
