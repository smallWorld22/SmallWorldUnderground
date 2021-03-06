package server;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface CombatServiceClientSkeleton extends Remote{

	void syncTerrain(ServerTerrain terrain) throws RemoteException;

	void syncLoses(String name, int losingTokens) throws RemoteException;

}
