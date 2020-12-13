package Psicologo;

import java.util.ArrayList;

import Abstract.Controller;
import Clinica.Clinica;
import Clinica.ClinicaController;

public class PsicologoController extends Controller {
    private static String tipo = "Psicologos";
    ArrayList<Integer> psicologos = index;
    
    public PsicologoController(){
        this.carregaIndex(tipo);
    }

    public boolean criarPsicologo(String nome, Clinica clinica) {
        Psicologo newPsicologo = new Psicologo(nome, clinica);
        //System.out.println(psicologos.toString());
        if(!psicologos.isEmpty()){
            if(find(newPsicologo)){return false;}
            // Setta id do psicologo
            newPsicologo.setId(psicologos.size());
        }else{
            newPsicologo.setId(0);
        }
        //adiciona o novo psicologo no array de psicologos da sua clinica
        clinica.addPsicologo(newPsicologo);
        //System.out.println(clinica.toString());
        ClinicaController.update(clinica);
        newPsicologo.escreveEmArquivo("Database/Psicologo"+newPsicologo.getId());
        psicologos.add(newPsicologo.getId());
        return salvaIndex(tipo);
        }
        
     public Psicologo getObject(int id){
         return Psicologo.leDeArquivo("Database/Psicologo"+id);
     }
     
     public static void update(Psicologo psicologo){
        psicologo.escreveEmArquivo("Database/Psicologo"+psicologo.getId());
     }

}

