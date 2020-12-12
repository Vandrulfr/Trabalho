import Clinica.Clinica;
import Clinica.ClinicaController;
import Consulta.Consulta;
import Consulta.ConsultaController;
import Paciente.Paciente;
import Psicologo.Psicologo;
import Psicologo.PsicologoController;

public class Main {
    public static void main(String[] args) {
        /***
         * Testes
         */
        ClinicaController clinicas = new ClinicaController();
        PsicologoController psicologos = new PsicologoController();
        ConsultaController consultas = new ConsultaController();
        clinicas.criarClinica("Sao Goncalo", "Centro", "Rua Principal", "");
        clinicas.criarClinica("Sao Goncalo", "Apollo", "Rua Marginal", "");
        Clinica clinica = clinicas.getObject(0);
        Paciente paciente = new Paciente("Paciente McPacienteface", 12345678912l);
        psicologos.criarPsicologo("Psicologo McPsicologoface", clinica);
        Psicologo psicologo = psicologos.getObject(0);
        consultas.criarConsulta(paciente,psicologo);
        Consulta consulta = consultas.getObject(0);
        System.out.println(clinica.toString());
        System.out.println(consulta.toString());
        System.out.println(psicologo.toString());
        System.out.println(paciente.toString());
    }
    
}
