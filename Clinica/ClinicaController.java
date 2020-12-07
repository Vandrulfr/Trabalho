package Clinica;

import java.util.HashSet;

public class ClinicaController{
    HashSet<Clinica> clinicas;

    void criarClinica(String cidade, String bairro, String endereco_0, String endereco_1){
        Clinica newClinica = new Clinica(cidade, bairro, endereco_0, endereco_1);
        clinicas.add(newClinica);
    }

}
