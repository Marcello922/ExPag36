package controller;

import java.util.concurrent.Semaphore;

public class Pessoa extends Thread{
	int id;
	int corredor = 200;
	Semaphore semaforo;
	public Pessoa(Semaphore semaforo,int id) {
		this.id = id;
		this.semaforo = semaforo;
	}
	@Override
	public void run() {
		while(corredor > 0) {
			andar();
		}
			try {
				semaforo.acquire();
				abrir();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			semaforo.release();
	}

	
	public void andar() {
		int passo = (int) (Math.random() * (6 - 4 + 1) + 4);
		corredor -= passo;
		System.out.println("A pessoa " + id + " andou " + passo + " metros.");
	}
	
	public void abrir() {
		int tempo = (int)Math.random() * (2 - 1 + 1) + 1;
		try {
			sleep(tempo);
			System.out.println("A pessoa "+ id + " demorou "+ tempo + " segundos para abrir e cruzar a porta.");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
