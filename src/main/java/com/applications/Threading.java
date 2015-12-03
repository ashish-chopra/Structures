package com.applications;

public class Threading {

	public static void main(String[] args) {
		Token t = new Token();
		Thread t1 = new Thread(new JobA(t));
		Thread t2 = new Thread(new JobB(t));

		t1.start();
		t2.start();
	}
	
}	

class Token {
	public boolean token = false;
	
	public boolean isReadyForB() {
		return token == true;
	}
	public boolean isReadyForA() {
		return token == false;
	}
	
	public void setBDone() {
		token = false;
	}
	public void setADone() {
		token = true;
	}
}
class JobA implements Runnable {
	Token b;
	static int i = 0;
	public JobA(Token b) {
		this.b = b;
	}
	
	public void run() {
		while (true) {
			synchronized (b) {
				while (!b.isReadyForA()) {
					try {
						b.wait();
					} catch(InterruptedException e) {}
				}
				// this ensures the jobA will now continue
				System.out.println("A");
				b.setADone();
				b.notify();	
			}
			
		}
	}
}

class JobB implements Runnable {
	Token b;
	
	public JobB(Token b) {
		this.b = b;
	}
	
	public void run() {
		while (true) {
			synchronized (b) {
				while (!b.isReadyForB()) {
					try {
						b.wait();
					} catch(InterruptedException e) {}
				}
				// this ensures that now jobB can continue
				System.out.println("B");
				b.setBDone();
				b.notify();
			}
			
		}
	}
}