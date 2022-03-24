package controller;

import java.util.concurrent.Semaphore;

public class Show extends Thread {
	private int acesso;
	private int compra;
	private Semaphore semaforo;
	
	public Show(int acesso, Semaphore semaforo) {
		this.acesso = acesso;
		this.compra = compra;
		this.semaforo = semaforo;
		
	}
	public void run() {
		loginsistema();
		try {
			semaforo.acquire();
			ValidaçãoCompra();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}finally {
			semaforo.release();
		}
	}
	public void loginsistema() {
		int tempo = 0;
		tempo = (int) ((int) (Math.random() * 2001 + 1000 ));
		System.out.println("O "+acesso+"º acessou e levou "+tempo+"ms");
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void ValidaçãoCompra() {
		int limite = 100;
		int maximo = 0;
		int t = 0;
		compra = (int) ((int) (Math.random() * 4 * 1 ));
		while (maximo < limite){
		maximo += compra;	
		}
		int tempo = 0;
		t = (int) ((int) (Math.random() * 2001 + 1000 ));
		System.out.println("A compra de "+compra+" ingressos levou "+t+"ms");
		if (t < 2500) {
			System.out.println("O compra do "+ acesso +" de "+ compra+ " ingressos foi validada");
		}
		else {
			if(t > 2500) {
				System.out.println("O compra do "+ acesso +" de "+ compra + " ingressos esta invalidada");	
			}
		}
		try {
			sleep(t);
//			System.out.println("O "+acesso+"º conseguiu comprar " + compra);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	
		
	}
 }
}


