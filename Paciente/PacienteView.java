package Paciente;

import java.util.Scanner;

import Consulta.ConsultaController;

public class PacienteView {
    PacienteController pacientes = new PacienteController();

    public void home(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("O que gostaria de fazer?");
        System.out.println("1 - Ver lista de pacientes");
        System.out.println("2 - Registrar um novo paciente");
        System.out.println("3 - Verificar a proxima consulta de um paciente");
        System.out.println("0 - Voltar para o menu inicial" );
        System.out.println("\n");
        String opcao = scanner.nextLine();
        scanner.close();

        switch(opcao) {
            case "1": index();
            case "2": novo();
            case "3": consulta();
            case "0": back();
        }
    }

    private void index(){
        pacientes.pacientes.forEach((p)->System.out.println(pacientes.getObject(p).toString()+"\n"));
        home();
    }

    private void novo(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira o nome do paciente:");
        String nome = scanner.nextLine();
        System.out.println("Insira o cpf do paciente");
        long cpf = Long.parseLong(scanner.nextLine());
        scanner.close();
        if(pacientes.criarPaciente(nome, cpf)){
            System.out.println("Paciente criado com sucesso!");
        }else{
            System.out.println("Houve um erro na criacao do paciente");
        }
        home();
    }
    void consulta(){
        ConsultaController consultas = new ConsultaController();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Qual o id do paciente?");
        int id = Integer.valueOf(scanner.nextLine());
        scanner.close();
        System.out.println("Essa será a proxima consulta do paciente:");
        System.out.println(consultas.getObject(pacientes.getObject(id).getProxima_consulta()).toString());
    }
    
}
