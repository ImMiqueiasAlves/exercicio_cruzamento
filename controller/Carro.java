package controller;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Carro extends Thread {
	// U - Up | D - Down | R - Right | L - Left
	private String sentido;
	private Semaphore semaforo_cruzamento;
	
	public Carro(Semaphore _semaforo) {
		semaforo_cruzamento = _semaforo;
		sentido = getRandomSentido();
	}
	
	public void run() {
		try {
			semaforo_cruzamento.acquire();
			atravessar();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			semaforo_cruzamento.release();
		}
	}
	
	private void atravessar() {
		System.out.println("Carro #" + getId() + " atravessando no sentido " + sentido);

	}
	
	private static String getRandomSentido() {
		String sentido[] = {"CIMA", "BAIXO", "DIREITA", "ESQUERDA"};
	    int rnd = new Random().nextInt(sentido.length);
	    return sentido[rnd];
	}
}
