package Paciente;

import java.util.Scanner;

import Consulta.Consulta;
import Consulta.ConsultaController;
import Abstract.View;

public class PacienteView {
    PacienteController pacientes_index;

    public PacienteView(){
        this.pacientes_index = new PacienteController();
    }
    public void home(){
        String opcao = "0";
        Scanner scanner = new Scanner(System.in);
        System.out.println("O que gostaria de fazer?");
        System.out.println("1 - Ver lista de pacientes");
        System.out.println("2 - Registrar um novo paciente");
        System.out.println("3 - Verificar a proxima consulta de um paciente");
        System.out.println("0 - Voltar para o menu inicial" );
        System.out.println("\n");
        if(scanner.hasNextLine()){
            opcao = scanner.nextLine();
        }

        switch(opcao) {
            case "1": index();
            case "2": novo();
            case "3": consulta();
            case "0": back();
        }
    }

    private void index(){
        pacientes_index.pacientes.forEach((p)->System.out.println(pacientes_index.getObject(p).toString()+"\n"));
        home();
    }

    private void novo(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira o nome do paciente:");
        String nome = scanner.nextLine();
        System.out.println("Insira o cpf do paciente");
        long cpf = Long.parseLong(scanner.nextLine());
        if(pacientes_index.criarPaciente(nome, cpf)){
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
        int id = scanner.nextInt();
        Paciente paciente = pacientes_index.getObject(id);
        if(paciente.getProxima_consulta() == -1){
            System.out.println("Não há consulta agendada");
            home();
        }
        Consulta consulta = consultas.getObject(paciente.getProxima_consulta());
        if(!paciente.primeira_consulta){
            System.out.println("Essa será a proxima consulta do paciente:");
        }else{
            System.out.println("Essa será a primeira consulta do paciente:");
        }
        System.out.println(consulta.toString());
        home();
    }
    void back(){
        View mainview = new View();
        mainview.home();
    }
    
}
