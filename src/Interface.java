import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Interface extends Remote{
	
	public void orderNewGoods(int id, int quantity) throws RemoteException;
	public void sendGoods(String example) throws RemoteException;
	
	
}
