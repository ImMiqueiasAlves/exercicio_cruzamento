package view;

import java.util.concurrent.Semaphore;

import controller.Carro;

public class Main {
	public static void main(String[] args) {
		Semaphore semaforo_cruzamento = new Semaphore(1);
		
		for(int i=0; i < 4; i++)
			new Carro(semaforo_cruzamento).run();
	}
}
