import java.io.Serializable;
import java.rmi.RemoteException;

public class Product implements Serializable{

    private String type;
    private String name;
    private int id;

    public Product( int i, String n, String t) throws RemoteException {
        this.type = t;
        this.name = n;
        this.id = i;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
