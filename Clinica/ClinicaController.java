package Clinica;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/***
 * Controller de Clinica. Através dele são criadas e manipuladas as Clinicas.
 */
public final class ClinicaController{
    private static ArrayList<Integer> clinicas = new ArrayList<Integer>();

    /**
     * Cria uma clinica usando o construtor de clinica.
     * Carrega um HashSet com todas as clinicas existestes, caso a nova clinica ja exista não salva ela
     * @param cidade
     * @param bairro
     * @param endereco_0
     * @param endereco_1
     * @return
     */
    public static boolean criarClinica(String cidade, String bairro, String endereco_0, String endereco_1){
        Clinica newClinica = new Clinica(cidade, bairro, endereco_0, endereco_1);
        if(!clinicas.isEmpty()){
            // Confere se não existem duplicatas
            ArrayList<Clinica> clinicasExistentes = new ArrayList<Clinica>();
            clinicas.forEach((c) -> clinicasExistentes.add(getClinica(c.toString())));
            if(clinicasExistentes.contains(newClinica)){return false;}
            // Setta id da clinica
            newClinica.setId(clinicas.size());
        }else{
            newClinica.setId(0);
        }
        newClinica.escreveEmArquivo("Database/Clinica"+String.valueOf(newClinica.getId()));
        clinicas.add(newClinica.getId());
        return salvaIndex();
     }
     

     public static Clinica getClinica(String id){
         return Clinica.leDeArquivo("Database/Clinica"+id);
     }

     private static boolean salvaIndex() {
        try{
            FileOutputStream fos = new FileOutputStream("Database/IndexClinicas");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(clinicas);
            oos.close();
            return true;
        }catch(Exception e){System.out.println(e); return false;}
     }
     public static boolean carregaIndex(){
        try {
            FileInputStream fin = new FileInputStream("Database/IndexClinicas");
            ObjectInputStream ois = new ObjectInputStream(fin);
            ArrayList<Integer> clinicasArq = (ArrayList<Integer>) ois.readObject();
            ois.close();
            clinicas = clinicasArq;
            return true;
        } catch (Exception e){System.out.println(e); return false;}
     }
}
