package Abstract;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/*** 
 * abstract getObject
 * salvaIndex
 * carregaIndex
*/
public abstract class Controller {
    public ArrayList<Integer> index = new ArrayList<Integer>();

    //public abstract void update(Object o);
    public abstract Object getObject(int id);

    public boolean deleteObject(int id, String tipo){
        File f = new File("Database/"+tipo+id);
        if (f.delete()){
            index.remove(Integer.valueOf(id));
            return salvaIndex(tipo+"s");
        }else{return false;}
    }
    
    public boolean salvaIndex(String tipo) {
        try{
            FileOutputStream fos = new FileOutputStream("Database/Index"+tipo);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(index);
            oos.close();
            return true;
        }catch(Exception e){System.out.println(e); return false;}
    }
     public boolean carregaIndex(String tipo){
        try {
            FileInputStream fin = new FileInputStream("Database/Index"+tipo);
            ObjectInputStream ois = new ObjectInputStream(fin);
            ArrayList<Integer> indexArq = (ArrayList<Integer>) ois.readObject();
            ois.close();
            index = indexArq;
            return true;
        }catch (FileNotFoundException e){
            System.out.println("Arquivo de Index de "+tipo+" não encontrado.");
            return false;
        }
        catch (Exception e){System.out.println(e); return false;}
     }


    
}
