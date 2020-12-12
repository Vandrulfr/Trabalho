package Clinica;

import java.util.ArrayList;

import Abstract.Controller;
/***
 * Controller de Clinica. Através dele são criadas e manipuladas as Clinicas.
 */
public final class ClinicaController extends Controller {
    ArrayList<Integer> clinicas = index;
    private static String tipo = "Clinicas";

    /**
     * Cria uma clinica usando o construtor de clinica.
     * Carrega um HashSet com todas as clinicas existestes, caso a nova clinica ja exista não salva ela
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
            ArrayList<Clinica> clinicasExistentes = new ArrayList<Clinica>();
            clinicas.forEach((c) -> clinicasExistentes.add(getObject(c)));
            if(clinicasExistentes.contains(newClinica)){return false;}
            // Setta id da clinica
            newClinica.setId(clinicas.size());
        }else{
            newClinica.setId(0);
        }
        newClinica.escreveEmArquivo("Database/Clinica"+String.valueOf(newClinica.getId()));
        clinicas.add(newClinica.getId());
        return salvaIndex(tipo);
     }
     

     public Clinica getObject(int id){
         return Clinica.leDeArquivo("Database/Clinica"+id);
     }

     public static void update(Clinica clinica){
        clinica.escreveEmArquivo("Database/Clinica"+String.valueOf(clinica.id));
     }
     

}
