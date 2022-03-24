package view;

import java.util.concurrent.Semaphore;

import controller.Show;

public class PrincipalShow {

public static void main(String[] args) {
	Semaphore semaforo = new Semaphore(300);
	
	for (int acesso = 1; acesso < 100; acesso++) {
		
		Thread threadP = new Show(acesso, semaforo);
		threadP.start();
	
		}

	}
}
