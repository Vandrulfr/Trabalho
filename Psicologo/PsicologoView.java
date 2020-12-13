package Psicologo;

import java.util.Scanner;

import Abstract.View;
import Clinica.Clinica;
import Clinica.ClinicaController;

public class PsicologoView extends View{
    PsicologoController psicologos_index;
    Scanner scanner;

    public PsicologoView(){
        psicologos_index = new PsicologoController();
        scanner = new Scanner(System.in);
    }

    protected void remove() {
        System.out.println("Qual o id do Psicologo que deseja remover?");
        int id = scanner.nextInt();
        System.out.println("Tem certeza que deseja prosseguir? A remoção é irreversivel(s/N");
        String confirmacao = scanner.next();
        if(confirmacao.toLowerCase().equals("s")){
            if(psicologos_index.deleteObject(id, "Psicologo")){
                System.out.println("Psicologo removido com sucesso.");
            }else{System.out.println("Ocorreu um problema na remoção");}
        }else{System.out.println("Remoção cancelada");}
    }

    protected void novo() {
        System.out.println("Insira o nome do psicologo:");
        String nome = scanner.nextLine();
        System.out.println("Insira o ID da Clinica na qual ele irá trabalhar");
        int id = scanner.nextInt();
        ClinicaController clinicas_index = new ClinicaController();
        Clinica clinica = clinicas_index.getObject(id);
        if(psicologos_index.criarPsicologo(nome, clinica)){
            System.out.println("Psicologo registrado com sucesso");
        }else{
            System.out.println("Houve um erro na criação do Psicologo");
        }
        home();
        
    } 
    protected void index() {
        psicologos_index.psicologos.forEach((c) -> System.out.println(psicologos_index.getObject(c).toString()+"\n"));
        home();
    }
    public void home() {
        String opcao = "0";
        System.out.println("O que gostaria de fazer?");
        System.out.println("1 - Ver lista de Psicologos");
        System.out.println("2 - Registrar um novo Psicologo");
        System.out.println("3 - Remover um psicologo");
        System.out.println("0 - Voltar para o menu inicial" );
        System.out.println("\n");
        if(scanner.hasNextLine()){
            opcao = scanner.nextLine();
        }

        switch(opcao) {
            case "1": index();
            case "2": novo();
            case "3": remove();
            case "0": back();
        }
    }
    
}
