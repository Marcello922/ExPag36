package view;

import java.util.concurrent.Semaphore;

import controller.Pessoa;

public class Main {
	public static void main(String[] args) {
		Semaphore semaforo = new Semaphore(1);
		for(int i = 0; i < 4; i++) {
			Pessoa p = new Pessoa(semaforo, i+1);
			p.start();
		}
	}
}
