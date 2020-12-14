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
 * Para salvar em arquivos de texto, teria que re-escrever os metodos toString() de cada model,
 * e trocaria os toString() atuais para algo como print(), ja que eles são usados apenas para printar os objetos.
 * Também teria que escrever um metodo pra converter de volta de string pra objeto em cada model.
 * Acredito que para salvar num banco MySql a modelagem MVC facilitaria, pois a forma como estou salvando os
 * Serializable atualmente tenta emular a forma como um banco MySql salvaria cada objeto model (Paciente, Clinica, etc)
 * numa tabela relacionada ao seu tipo, e guardando o id de objetos relacionados que poderiam ser facilmente encontrados numa query.
 * Na verdade, um banco MySql provavelmente facilitaria a implementacao de alguns metodos dos controllers
 * (Encontrar objetos com base em um parametro especifico, por exemplo).
 * MongoDB até onde sei é uma implementação open source do MySql, então o mesmo se aplicaria a ele.
 * Em certo momento no desenvolvimento do projeto considerei salvar os objetos em JSON, e acredito que também 
 * poderia ser uma opção viável, mas não tenho certeza de como faria para encontrar cada objeto depois do jeito que
 * está implementado.
 * Em questão de todas classes que realizam operaçoes de persistencia terem os mesmos metodos, minha
 * unica classe na qual isso não é verdade é o ClinicaController, que tem buscas customizadas (que em MySql
 * seriam Queries) para encontrar clinicas no mesmo bairro ou cidade que o usuario.
 * 
 * B) 
 * Os metodos novos para escrever em tipos diferentes estão em Abstract/Model.java.
 * A criação dos objetos está sendo feita nos Controllers (Por exemplo, ClinicaController tem um metodo
 * que passa argumentos para o construtor de Clinica). O controller também é responsavel por
 * carregar os objetos dos arquivos (Chamando os metodos de Model).
 *  No controller, bastaria alterar o chamado dos metodos escreveEmArquivo()
 * e leDeArquivo para chamar os metodos de cada respectivo tipo de persistencia.
 * por exemplo, para salvar um paciente recem-criado num banco MySql usaria
 * 
        newPaciente.escreveMySql();
 * na linha 32 de PsicologosController, ao invés do atual
        newPaciente.escreveEmArquivo("Database/Paciente"+newPaciente.id);
 * Graças a PoO, seria uma adaptação minuscula dos metodos já existentes, já que todos modelos herdam de
 * Abstract.Model;
 */
