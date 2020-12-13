package Clinica;

import java.util.Scanner;

import Abstract.View;

public class ClinicaView extends View{
    ClinicaController clinicas_index;
    Scanner scanner;
    protected void novo() {
        System.out.println("Em que cidade fica a clinica?");
        String cidade = scanner.nextLine();
        System.out.println("Em que bairro?");
        String bairro = scanner.nextLine();
        System.out.println("Rua: ");
        String endereco_0 = scanner.nextLine();
        System.out.println("Complemento:");
        String endereco_1 = scanner.nextLine();
        if(clinicas_index.criarClinica(cidade, bairro, endereco_0, endereco_1)){
            System.out.println("Clinica registrada com sucesso!");
        }else{
            System.out.println("Houve um problema na criação da clinica");
        }
        home();
        
    }
    protected void index() {
        clinicas_index.clinicas.forEach((c) -> System.out.println(c.toString()+"\n"));
        home();
    }
    public void home() {
        String opcao = "0";
        System.out.println("O que gostaria de fazer?");
        System.out.println("1 - Ver lista de clinicas");
        System.out.println("2 - Registrar uma nova clinca");
        //TODO: System.out.println("3 - Buscar clinicas proximas");
        //TODO: System.out.println("4 - Remover Clinica");
        System.out.println("0 - Voltar para o menu inicial" );
        System.out.println("\n");
        if(scanner.hasNextLine()){
            opcao = scanner.nextLine();
        }

        switch(opcao) {
            case "1": index();
            case "2": novo();
            //case "3": consulta();
            case "0": back();
        }
    }
    
}
