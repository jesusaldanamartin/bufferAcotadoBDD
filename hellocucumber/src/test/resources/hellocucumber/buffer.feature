Feature: Buffer Tests
	testing all the features the buffer has
	
	Scenario Outline: Test if the buffer creted has the same elements as Its capacity has
	Given Its capacity <capacity1>
	When I create a Buffer
	And I fill the Buffer
	Then the Buffer will have <capacity1> elements
	
	Examples: 
	| capacity1 |
	|	5	  			|
	| 10 				|
	| 2000 			|
	
		Scenario: Test if the capacity given is negative or zero it throws an exception
	Given Its capacity <capacity1>
	When The capacity is < zero
	Then test should thrown an IllegalArgumentException
	
		Examples: 
	| capacity1 |
	|	0	  		  |
	| -300      |
	
	
		Scenario Outline: Test if the capacity reduces by one when I remove the head of the buffer
	Given Its capacity <capacity1>
	When I create a Buffer
	And I fill the Buffer
	And I remove the Head of the buffer
	Then the Buffer will have <capacity1> elements minus one
	
	Examples: 
	| capacity1 |
	|	5	        |
	| 10 	      |
	| 2000      |
	
		Scenario: Test if adding an element in a full buffer throws an exception
			Given Its capacity <capacity1>
			When I create a Buffer
			And Buffer is full and I add one more element
			Then test should thrown an IllegalStateException
	
		Examples: 
	| capacity1 |
	|	10	  	  |
	| 2000      |
	
		Scenario: Test if removing an element in a empty buffer throws an exception
			Given Its capacity <capacity1>
			When I create a Buffer
			And Buffer is empty and I remove the Head
			Then test should thrown an IllegalStateException
	
		Examples: 
	| capacity1 |
	|	10	      |
	| 2000      |
	
	