package Consulta;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import Abstract.Controller;
import Paciente.Paciente;
import Paciente.PacienteController;
import Psicologo.Psicologo;
import Psicologo.PsicologoController;

public class ConsultaController extends Controller{
    ArrayList<Integer> consultas;
    private static String tipo = "Consultas";

    public ConsultaController(){
        this.carregaIndex(tipo);
        consultas = index;
    }

    public boolean criarConsulta(int paciente_id, int psicologo_id, LocalDate data, LocalTime horario_inicio){
        Consulta newConsulta = new Consulta(psicologo_id, paciente_id);
        newConsulta.setData(data);
        newConsulta.setHorario_inicio(horario_inicio);
        PsicologoController psicologos = new PsicologoController();
        Psicologo psicologo = psicologos.getObject(psicologo_id);
        PacienteController pacientes = new PacienteController();
        Paciente paciente = pacientes.getObject(paciente_id);

        if(!consultas.isEmpty()){
            // Confere se não existem duplicatas
            if(find(newConsulta)){return false;}
            // Setta id da clinica
            newConsulta.id = ((consultas.get(consultas.size()-1))+1);
        }else{
            newConsulta.id = (0);
        }
        newConsulta.escreveEmArquivo("Database/Consulta"+newConsulta.id);
        psicologo.addConsulta(newConsulta);
        PsicologoController.update(psicologo);
        if(paciente.isPrimeira_consulta()){
            if(paciente.getProxima_consulta()==-1){
                paciente.setProxima_consulta(newConsulta.id);
            }else{paciente.setPrimeira_consulta(false);}
        }else{
            if(getObject(paciente.getProxima_consulta()).getData().isBefore(LocalDate.now())){
                paciente.setProxima_consulta(newConsulta.id);
            }
        }
        PacienteController.update(paciente);
        consultas.add(newConsulta.id);
        return salvaIndex(tipo);

    }

    public Consulta getObject(int id) {
        return Consulta.leDeArquivo("Database/Consulta"+id);
    }
    
    public boolean find(Consulta newConsulta){
        return index.stream().anyMatch(o -> getObject(o).equals(newConsulta));
    }
}
