package Paciente;

import java.util.Scanner;

import Consulta.Consulta;
import Consulta.ConsultaController;

public class PacienteView extends Abstract.View {
    PacienteController pacientes_index;
    Scanner scanner;

    public PacienteView(){
        this.pacientes_index = new PacienteController();
        scanner = new Scanner(System.in);

    }
    public void home(){
        String opcao = "0";
        System.out.println("O que gostaria de fazer?");
        System.out.println("1 - Ver lista de pacientes");
        System.out.println("2 - Registrar um novo paciente");
        System.out.println("3 - Verificar a proxima consulta de um paciente");
        System.out.println("4 - Remover um paciente");
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

    protected void index(){
        pacientes_index.pacientes.forEach((p)->System.out.println(pacientes_index.getObject(p).toString()+"\n"));
        home();
    }

    protected void novo(){
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
    private void consulta(){
        ConsultaController consultas = new ConsultaController();
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
    protected void remove() {
        System.out.println("Qual o id do paciente que deseja remover?");
        int id = scanner.nextInt();
        System.out.println("Tem certeza que deseja prosseguir? A remoção é irreversivel(s/N)");
        String confirmacao = scanner.next();
        System.out.println(confirmacao);
        if(confirmacao.toLowerCase().equals("s")){
            if(pacientes_index.deleteObject(id, "Paciente")){
                System.out.println("Paciente removido com sucesso.");
            }else{System.out.println("Ocorreu um problema na remoção");}
        }else{System.out.println("Remoção cancelada");}
        home();
    }
}
