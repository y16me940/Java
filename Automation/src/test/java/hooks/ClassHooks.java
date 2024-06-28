package hooks;

import io.cucumber.java.*;

public class ClassHooks {
	
	@AfterAll()
	public void mongoDB() {
		System.out.println("_________________");
		System.out.println("Mongo DB entries created");
		System.out.println("_________________");
	}


}
