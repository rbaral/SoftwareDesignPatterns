/**
 * 
 */
package com.design.creational;

interface Button{
	public void paint();
}


interface GUIFactory{
	public Button createButton();
}


class WinFactory implements GUIFactory{
	public Button createButton(){
		return new WinButton();
	}
}


class OSXFactory implements GUIFactory{
	public Button createButton(){
		return new OSXButton();
	}
}


class WinButton implements Button{
	public void paint() {
		System.out.println("I am a WinButton");
	}
}


class OSXButton implements Button{
	public void paint(){
		System.out.println("I am a OSXButton");
	}
}

class Application{
	
	public Application(){}//a default constructor
	public Application(GUIFactory factory){
		Button button = factory.createButton();
		button.paint();	
	}
}

/**
 * this is the client module
 * @author rbaral
 *
 */
public class AbstractFactoryDemo {

	public AbstractFactoryDemo(GUIFactory factory){
		Button button = factory.createButton();
		button.paint();	
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//lets suppose the value of the variable os is read from configuration in runtime
		String os="windows";
		GUIFactory factory;
		if(os.equalsIgnoreCase("windows"))
			factory = new WinFactory();
		else
			factory = new OSXFactory();
		//lets create the object of the client
		AbstractFactoryDemo client = new AbstractFactoryDemo(factory);
	}
	
	

}
