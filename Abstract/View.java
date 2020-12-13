package Abstract;

import java.util.Scanner;

import Paciente.PacienteView;

/** Não é uma classe abstrata, mas precisava de um lugar para ela :P */
public class View {
    PacienteView menu_paciente;
    Scanner scanner = new Scanner(System.in);

    public View(){
        menu_paciente = new PacienteView();
    }

    public void home(){
        String opcao = "0";
        System.out.println("1 - Pacientes");
        System.out.println("0 - Sair");
        //TODO: Outras opçoes
        if (scanner.hasNextLine()){
            opcao = scanner.nextLine();
        }
        switch(opcao){
            case "1": menu_paciente.home();
            case "0": sair();  
        }
    }

    private void sair(){
        System.out.println("Obrigado por usar!");
        scanner.close();
        System.exit(0);
    }
    
}
