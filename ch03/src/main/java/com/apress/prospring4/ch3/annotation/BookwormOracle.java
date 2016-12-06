package com.apress.prospring4.ch3.annotation;

import org.springframework.stereotype.Service;

import com.apress.prospring.ch3.Oracle;

// This class implements Oracle IF & set method for DI!
// Spring is good at it - no need to define dependences in business-IF
// Only business-methods in business-IFs!

@Service("oracle")
public class BookwormOracle implements Oracle {
	
	public String defineMeaningOfLife() {		
		return "Encyclopedias are à waste of rnoney - use the Internet";
	}

}
