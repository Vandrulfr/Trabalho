package Clinica;

import java.util.ArrayList;

import Abstract.Controller;
/***
 * Controller de Clinica. Através dele são criadas e manipuladas as Clinicas.
 */
public final class ClinicaController extends Controller {
    ArrayList<Integer> clinicas;
    private static String tipo = "Clinicas";
    
    public ClinicaController(){
        this.carregaIndex(tipo);
        clinicas = index;
    }


    /**
     * Cria uma clinica usando o construtor de clinica.
     * @param cidade
     * @param bairro
     * @param endereco_0
     * @param endereco_1
     * @return
     */
    public boolean criarClinica(String cidade, String bairro, String endereco_0, String endereco_1){
        Clinica newClinica = new Clinica(cidade, bairro, endereco_0, endereco_1);
        if(!clinicas.isEmpty()){
            // Confere se não existem duplicatas
            if(find(newClinica)){return false;}
            // Setta id da clinica
            newClinica.id = ((clinicas.get(clinicas.size()-1))+1);
        }else{
            newClinica.id = (0);
        }
        newClinica.escreveEmArquivo("Database/Clinica"+String.valueOf(newClinica.id));
        clinicas.add(newClinica.id);
        return salvaIndex(tipo);
     }
     

     public Clinica getObject(int id){
         return Clinica.leDeArquivo("Database/Clinica"+id);
     }

     public static void update(Clinica clinica){
        clinica.escreveEmArquivo("Database/Clinica"+String.valueOf(clinica.id));
     }
     
    public boolean find(Clinica newClinica){
        return index.stream().anyMatch(o -> getObject(o).equals(newClinica));
    }

    public ArrayList<Clinica> naCidade(String cidade){
        ArrayList<Clinica> perto = new ArrayList<Clinica>();
        for(int id: index){
           if(getObject(id).getCidade().toLowerCase().equals(cidade.toLowerCase())){perto.add(getObject(id));}
        }return perto;
    }
    public ArrayList<Clinica> noBairro(String bairro){
        ArrayList<Clinica> perto = new ArrayList<Clinica>();
        for(int id: index){
           if(getObject(id).getBairro().toLowerCase().equals(bairro.toLowerCase())){perto.add(getObject(id));}
        }return perto;
    }
}
