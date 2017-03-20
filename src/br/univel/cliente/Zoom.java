package br.univel.cliente;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import br.univel.comum.CONSTANTES;
import br.univel.comum.Plact;

public class Zoom extends Thread implements Runnable, Plact {

	private Integer vlr = null;

	public Zoom() throws Exception{
		Registry registry = LocateRegistry.getRegistry("192.168.56.1", 1818);
		Plact servico = (Plact) registry.lookup(Plact.NOME);
		Integer retorno =  servico.calcule(CONSTANTES.RA_DEZENA);
		System.out.println(retorno);
	}

	public static void main(String[] args) throws Exception {
		new Zoom();
	}

	public void run() {
		Zoom servico;
		try {
			servico = (Zoom) UnicastRemoteObject.exportObject(Zoom.this, 0);
			Registry registry = LocateRegistry.createRegistry(1818);
			registry.rebind(Plact.NOME, servico);

		} catch (Exception e) {
		}
	}

	@Override
	public Integer calcule(Integer vlr) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
}
