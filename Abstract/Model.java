package Abstract;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/**
 * int id
 * escreveEmArquivo()
 * getId()
 * setId()
 */
public abstract class Model {
    public void escreveEmArquivo(String nome){
        try{
            FileOutputStream fos = new FileOutputStream(nome);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this);
            oos.close();
        }catch(Exception e){System.out.println(e);}
    }
    
    protected static Object leDeArquivo(String nome){
        try {
            FileInputStream fin = new FileInputStream(nome);
            ObjectInputStream ois = new ObjectInputStream(fin);
            Object objetoArquivo = ois.readObject();
            ois.close();
            return objetoArquivo;
        } catch (Exception e){System.out.println(e); return null;}
    }

    public void escreveMysql(){
        //Não precisaria passar parametros pois chamaria como newObjeto.escreveMysql();
        //no controller.
        //usaria this.getClass() para saber em que tabela do banco salvar
    }

    protected static Object carregaDeMysql(String tipo, int id){
        
        //String para saber em que tabela do banco procurar, id para encontrar o objeto
        //Depois em cada modelo respectivo faria typecasting de Object para a classe correta
        Object o = new Object();
        return o;
    }

    public void salvaEmTexto(){
        //esse metodo dispensaria argumentos, pois cada objeto seria salvo em uma linha do arquivo de texto
        //Para encontrar o objeto bastaria buscar pela linha correta.
        //A remocao de objetos do "banco de dados" seria feita trocando sua linha por algum indicador que o objeto
        //foi removido, por exemplo uma linha comecando com !!!. Assim um objeto salvo sempre manteria a mesma posicao
        //no banco mesmo que objetos anteriores a ele fossem removidos.
    }

    protected static Object leDeTexto(String nome, int linha){
        //Nome é o nome do arquivo.
        //Carregaria o arquivo para memoria e leria a linha x
        //Não tenho certeza de como faria para converter os dados de volta para um arquivo.
        //Acho que poderia quebrar a linha a cada ' para separar os parametros e passar eles para um
        //Object objeto = new Objeto(params)
        Object o = new Object();
        return o;
    }
    
}
