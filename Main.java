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
            Clinica clinica = clinicas.getObject(0);
            clinicas.criarClinica("Sao Goncalo", "Apollo", "Rua Marginal", "");
            pacientes.criarPaciente("Paciente McPacienteface", 12345678912l);
            Paciente paciente = pacientes.getObject(0);
            psicologos.criarPsicologo("Psicologo McPsicologoface", clinica);
            Psicologo psicologo = psicologos.getObject(0);
            consultas.criarConsulta(paciente.id,psicologo.id,LocalDate.now().plusDays(1),LocalTime.now());// Esse construtor ficou enorme
            Consulta consulta = consultas.getObject(0);
            System.out.println(clinica.toString()+"\n");
            System.out.println(consulta.toString()+"\n");
            System.out.println(psicologo.toString()+"\n");
            System.out.println(paciente.toString()+"\n");
        
        }else{

            Menu menu = new Menu();
            menu.home();
        }
    }
    
}

/**
 * A)
 * As classes que realizam a persistencia implementariam a interface Persistencia, que define o contrato para seus
 * metodos em comum. O controller que desejasse salvar de uma forma diferente poderia instanciar cada
 * uma dessas classes e usar seus metodos. Caso fosse implementar esses diferentes tipos de persistencia,
 * também criaria um modelo Persistencia/Serializer, que implementaria essa interface salvando de forma serializavel,
 * para que ficasse mais facil trocar entre ele e os outros tipos de persistencia
 * 
 * B) 
 * Criei uma interface Persistencia, que é implementada pelos objetos do Package Persistencia.
 * Para usar esses outros tipos de persistencia bastaria extender essas classes nos controllers
 * e instanciar como por exemplo MySql persistencia = new MySql(); 
 * (ao invés de Abstract.Controller, cujos metodos se tornariam redundantes) onde deseja usa-los
 * E chamar seus metodos onde se aplicam, como por exemplo mySql.insere(newClinica)
 * na linha 37 do ClinicaController.
 * Para trocar entre eles bastaria mudar o tipo de persistencia 
 * por exemplo, Texto persistencia = new Texto(); ao invés do exemplo dado acima com MySql
 *
 * 
 */
