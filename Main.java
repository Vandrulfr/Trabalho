import Home.Menu;

import java.time.LocalDate;
import java.time.LocalTime;

import Clinica.Clinica;
import Clinica.ClinicaController;
import Consulta.Consulta;
import Consulta.ConsultaController;
import Paciente.Paciente;
import Paciente.PacienteController;
import Psicologo.Psicologo;
import Psicologo.PsicologoController;


public class Main {
    public static void main(String[] args) {
        /***
         * Testes
         */
        boolean teste = false;
        if(teste){
            ClinicaController clinicas = new ClinicaController();
            PsicologoController psicologos = new PsicologoController();
            ConsultaController consultas = new ConsultaController();
            PacienteController pacientes = new PacienteController();
            clinicas.criarClinica("Sao Goncalo", "Centro", "Rua Principal", "");
            clinicas.criarClinica("Sao Goncalo", "Apollo", "Rua Marginal", "");
            Clinica clinica = clinicas.getObject(0);
            pacientes.criarPaciente("Paciente McPacienteface", 12345678912l);
            Paciente paciente = pacientes.getObject(0);
            psicologos.criarPsicologo("Psicologo McPsicologoface", clinica);
            Psicologo psicologo = psicologos.getObject(0);
            consultas.criarConsulta(paciente.getId(),psicologo.getId(),LocalDate.now().plusDays(1),LocalTime.now());// Esse construtor ficou enorme
            Consulta consulta = consultas.getObject(0);
            System.out.println(clinica.toString());
            System.out.println(consulta.toString());
            System.out.println(psicologo.toString());
            System.out.println(paciente.toString());
        
        }else{

            Menu menu = new Menu();
            menu.home();
        }
    }
    
}
