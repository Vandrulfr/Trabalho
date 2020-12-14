package Consulta;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

import Abstract.View;

public class ConsultaView extends View{
    ConsultaController consultas_index;
    Scanner scanner;
    public ConsultaView(){
        consultas_index = new ConsultaController();
        scanner = new Scanner(System.in);
    }


    protected void remove() {
        System.out.println("Qual o id da consulta que deseja remover?");
        int id = scanner.nextInt();
        System.out.println("Tem certeza que deseja prosseguir? A remoção é irreversivel(s/N");
        String confirmacao = scanner.next();
        if(confirmacao.toLowerCase().equals("s")){
            if(consultas_index.deleteObject(id, "Consulta")){
                System.out.println("Consulta removida com sucesso.");
            }else{System.out.println("Ocorreu um problema na remoção");}
        }else{System.out.println("Remoção cancelada");}
        home();
    }

    public void home(){
        String opcao = "0";
        System.out.println("O que gostaria de fazer?");
        System.out.println("1 - Ver todas consultas");
        System.out.println("2 - Agendar consulta");
        System.out.println("3 - Remover consulta");
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
    public void index(){
        consultas_index.consultas.forEach((p)->System.out.println(consultas_index.getObject(p).toString()+"\n"));
        home();
    }
    public void novo(){
        System.out.println("Insira o id do psicologo:");
        int psicologo = scanner.nextInt();
        System.out.println("Insira o id do paciente");
        int paciente =scanner.nextInt();
        System.out.println("Para que mês deseja marcar a consulta?(Numero)");
        int mes = scanner.nextInt();
        System.out.println("Em que dia?");
        int dia = scanner.nextInt();
        int ano = LocalDate.now().getYear();
        LocalDate data = LocalDate.of(ano, mes, dia);
        System.out.println("Comecando que horas?(Sem minutos)");
        int hora = scanner.nextInt();
        LocalTime hora_inicio = LocalTime.of(hora, 0, 0);
        if(consultas_index.criarConsulta(paciente, psicologo, data, hora_inicio)){
            System.out.println("Consulta agendada com sucesso!");
        }else{
            System.out.println("Esse psicologo já tem uma consulta nesse horario");
        }
        home();
    }
    
}
