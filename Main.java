import Clinica.Clinica;
import Consulta.Consulta;
import Paciente.Paciente;
import Psicologo.Psicologo;

public class Main {
    public static void main(String[] args) {
        /***
         * Testes
         */
        Clinica clinica = new Clinica("Itaborai", "Rio Varzea", "Rua Afonso Mello", "200");
        Clinica clinica2 = new Clinica("Niteroi", "Centro", "Rua Marechal Peixoto", "123");
        Consulta consulta = new Consulta(clinica);
        Psicologo psicologo = new Psicologo("Psicologo McPsicologoface", clinica);
        Paciente paciente = new Paciente("Paciente McPacienteface", 12345678912l);
        System.out.println(clinica.toString());
        System.out.println(clinica2.toString());
        System.out.println(consulta.toString());
        System.out.println(psicologo.toString());
        System.out.println(paciente.toString());
    }
    
}
