package Paciente;

import java.util.ArrayList;

import Abstract.Controller;

public class PacienteController extends Controller{
    ArrayList<Integer> pacientes;
    private static String tipo = "Pacientes";

    public PacienteController(){
        this.carregaIndex(tipo);
        pacientes= index;
    }
    
    public Paciente getObject(int id) {
        return Paciente.leDeArquivo("Database/Paciente"+id);
    }

    public boolean criarPaciente(String nome, long cpf){
        Paciente newPaciente = new Paciente(nome, cpf);
        if(!pacientes.isEmpty()){
            // Confere se não existem duplicatas
            if(find(newPaciente)){return false;}
            // Setta id da clinica
            newPaciente.id = ((pacientes.get(pacientes.size()-1))+1);
        }else{newPaciente.id = (0);}
        newPaciente.escreveEmArquivo("Database/Paciente"+newPaciente.id);
        pacientes.add(newPaciente.id);
        return salvaIndex(tipo);
    }
     public static void update(Paciente paciente){
        paciente.escreveEmArquivo("Database/Paciente"+paciente.id);
     }
    
    public boolean find(Paciente newPaciente){
        return index.stream().anyMatch(o -> getObject(o).equals(newPaciente));
    }
}
