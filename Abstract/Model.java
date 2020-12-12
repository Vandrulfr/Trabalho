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
    public int id;
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
    
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
