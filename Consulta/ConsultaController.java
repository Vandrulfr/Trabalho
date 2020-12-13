package Consulta;

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

    public boolean criarConsulta(Paciente paciente, Psicologo psicologo){
        Consulta newConsulta = new Consulta(psicologo, paciente);
        if(!consultas.isEmpty()){
            // Confere se não existem duplicatas
            if(find(newConsulta)){return false;}
            // Setta id da clinica
            newConsulta.setId(consultas.size());
        }else{
            newConsulta.setId(0);
        }
        newConsulta.escreveEmArquivo("Database/Consulta"+newConsulta.getId());
        psicologo.addConsulta(newConsulta);
        PsicologoController.update(psicologo);
        if(paciente.getProxima_consulta()==-1){paciente.setProxima_consulta(newConsulta.getId());}
        PacienteController.update(paciente);
        consultas.add(newConsulta.getId());
        return salvaIndex(tipo);

    }

    public Consulta getObject(int id) {
        return Consulta.leDeArquivo("Database/Consulta"+id);
    }
    
}
