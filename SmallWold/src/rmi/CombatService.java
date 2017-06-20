package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import controllers.CombatController;
import server.CombatServiceClientSkeleton;
import server.CombatServiceSkeleton;
import server.SetServiceClientSkeleton;

public class CombatService extends UnicastRemoteObject implements CombatServiceClientSkeleton  {
	private CombatController combatController;

	public CombatService(CombatController combatController) throws RemoteException {
		super();
		this.combatController = combatController;
	}

}
