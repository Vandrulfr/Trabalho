package Home;

import java.util.Scanner;

import Consulta.ConsultaView;
import Paciente.PacienteView;

/** Não é uma classe abstrata, mas precisava de um lugar para ela :P */
public class Menu {
    PacienteView menu_paciente;
    ConsultaView menu_consulta;
    Scanner scanner = new Scanner(System.in);

    public Menu(){
        menu_paciente = new PacienteView();
        menu_consulta = new ConsultaView();
    }

    public void home(){
        String opcao = "0";
        System.out.println("1 - Pacientes");
        System.out.println("2 - Consultas");
        System.out.println("0 - Sair");
        //TODO: Outras opçoes
        if (scanner.hasNextLine()){
            opcao = scanner.nextLine();
        }
        switch(opcao){
            case "1": menu_paciente.home();
            case "2": menu_consulta.home();
            case "0": sair();  
        }
    }

    private void sair(){
        System.out.println("Obrigado por usar!");
        scanner.close();
        System.exit(0);
    }
    
}
