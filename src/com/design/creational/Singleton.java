/**
 * this is an illustration of the singleton pattern
 */
package com.design.creational;

/**
 * @author rbaral
 *
 */
public class Singleton {

	//volatile, because we don't want to cache it locally
	private static volatile Singleton instance;

	private Singleton() { }

	public static Singleton getInstance() {
		if (instance == null) {
			synchronized (Singleton.class) {
				if (instance == null) {
					instance = new Singleton();
				}
			}
		}
		return instance;
	}

}
