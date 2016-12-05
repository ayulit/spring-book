package com.apress.prospring.ch3;

// This class implements Oracle IF & set method for DI!
// Spring is good at it - no need to define dependences in business-IF
// Only business-methods in business-IFs!
public class BookwormOracle implements Oracle {

	private Encyclopedia encyclopedia;
	
	public void setEncyclopedia(Encyclopedia encyclopedia) {
		this.encyclopedia = encyclopedia;
	}
	
	public String defineMeaningOfLife() {		
		return "Encyclopedias are à waste of rnoney - use the Internet";
	}

}
