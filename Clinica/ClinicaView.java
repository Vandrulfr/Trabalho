package Clinica;

import java.util.ArrayList;
import java.util.Scanner;

import Abstract.View;

public class ClinicaView extends View{
    ClinicaController clinicas_index;
    Scanner scanner;

    public ClinicaView(){
        clinicas_index = new ClinicaController();
        scanner = new Scanner(System.in);
    }
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
        clinicas_index.clinicas.forEach((c) -> System.out.println(clinicas_index.getObject(c).toString()+"\n"));
        home();
    }
        
    protected void remove() {
        System.out.println("Qual o id da Clinica que deseja remover?");
        int id = scanner.nextInt();
        System.out.println("Tem certeza que deseja prosseguir? A remoção é irreversivel(s/N)");
        String confirmacao = scanner.next();
        if(confirmacao.toLowerCase().equals("s")){
            if(clinicas_index.deleteObject(id, "Clinica")){
                System.out.println("Clinica removida com sucesso.");
            }else{System.out.println("Ocorreu um problema na remoção");}
        }else{System.out.println("Remoção cancelada");}
        home();
    }
    public void home() {
        String opcao = "0";
        System.out.println("O que gostaria de fazer?");
        System.out.println("1 - Ver lista de clinicas");
        System.out.println("2 - Registrar uma nova clinica");
        System.out.println("3 - Buscar clinicas proximas");
        System.out.println("4 - Remover Clinica");
        System.out.println("0 - Voltar para o menu inicial" );
        System.out.println("\n");
        if(scanner.hasNextLine()){
            opcao = scanner.nextLine();
        }

        switch(opcao) {
            case "1": index();
            case "2": novo();
            case "3": consulta();
            case "4": remove();
            case "0": back();
        }
    }

    private void consulta(){
        System.out.println("Em que cidade você se encontra?");
        String cidade = scanner.nextLine();
        System.out.println("Em que bairro?");
        String bairro = scanner.nextLine();
        ArrayList<Clinica> na_cidade=clinicas_index.naCidade(cidade);
        if (na_cidade.isEmpty()){
            System.out.println("Não há clinicas perto de você. Deseja ver todas as clinicas?(S/n)");
            String confirmacao = scanner.next();
            if(!confirmacao.equals("n")){
                index();
            }
        }else{
            ArrayList<Clinica> no_bairro =clinicas_index.noBairro(bairro);
            if(no_bairro.isEmpty()){
                System.out.println("Foram encontradas clinicas na sua cidade!");
                na_cidade.forEach((c) -> System.out.println(c.toString()));
            }else{
                System.out.println("Foram encontradas clinicas no seu bairro!");
                no_bairro.forEach((c)->System.out.println(c.toString()));
            }
        }
        home();
    }
    
}
