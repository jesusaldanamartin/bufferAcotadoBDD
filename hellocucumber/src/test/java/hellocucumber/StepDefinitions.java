package hellocucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.jupiter.api.Assertions.*;

public class StepDefinitions {
	


		private bufferAcotado<Integer> buffer;
		private int capacity;
		private boolean IllegalArgument_thrown, IllegalStateException_thrown;

		/**
		 * GIVEN
		 * Inicializo la capacidad del buffer con el parametro capacity1
		 */
		@Given("Its capacity {int}")
		public void its_capacity(Integer capacity1) {
			capacity = capacity1;
		}
		
		/**
		 * WHEN
		 * Creo el Buffer y le paso la capacidad indicada
		 */
		
		@When("I create a Buffer")
		public void i_create_a_buffer() {
			buffer = new bufferAcotado<Integer>(capacity);
			
		}
		
		/**
		 * WHEN
		 * Si pasamos una capacidad negativa al Buffer 
		 * lanzaremos una excepción IllegalArgument
		 */
		@When("The capacity is < zero")
		public void the_capacity_is_zero() {
			try {
				buffer = new bufferAcotado<Integer>(capacity);
			}catch(IllegalArgumentException e) {
			
				IllegalArgument_thrown = true;
				
			}
		}
		
		/**
		 * WHEN
		 * LLeno el Buffer para luego comprobar si el Buffer se ha creado con la capacidad indicada
		 */
		@When("I fill the Buffer")
		public void i_fill_the_buffer() {
		   while(!buffer.isFull()) {
			   buffer.put(0);
		   }
		}
		
		/**
		 * Elimino el primer elemento del buffer
		 */
		@When("I remove the Head of the buffer")
		public void i_remove_the_head_of_the_buffer() {
		    buffer.get();
		}
		
		
	   /**
	    * WHEN
	    * Elimino todos los elementos del Buffer hasta estar vacío
	    * e intento eliminar uno más y comprueba con el try-catch si se lanza
	    * una excepción IllegalState
	    */
		
		@When("Buffer is empty and I remove the Head")
		public void buffer_is_empty_and_i_remove_the_head() {		
			try {
				while(!buffer.isEmpty()) {
					   buffer.get();
				   }
				buffer.get();
			}catch(IllegalStateException e) {
			
				IllegalStateException_thrown = true;
				
			}
		}
		
		 /**
		  * WHEN
		  * Añado tantos elementos al Buffer hasta llenarlo
		  * e intento añadir uno más y compruebo con el try-catch si se lanza
		  * una excepción IllegalState
		  */
		
		@When("Buffer is full and I add one more element")
		public void buffer_is_full_and_i_add_one_more_element() {
			try {
				while(!buffer.isFull()) {
					   buffer.put(0);
				   }
				buffer.put(0);
			}catch(IllegalStateException e) {
			
				IllegalStateException_thrown = true;				
			}
		}
		
		/**
		 * Para comprobar que el buffer se ha creado correctamente al llenarlo al maximo
		 * comparandolo con el tamaño del buffer (.size())
		 * @param capacity1
		 */
		
		@Then("the Buffer will have {int} elements")
		public void the_buffer_will_have_elements(Integer capacity1) {
			assertEquals(capacity1, buffer.size());

		}
				
		/**
		 * THEN
		 * Comprueba si al eliminar un elemento del Buffer también se reduce
		 * en 1 la cantidad de elementos
		 * @param capacity1
		 */
		@Then("the Buffer will have {int} elements minus one")
		public void the_buffer_will_have_elements_minus_one(Integer capacity1) {
			assertEquals(capacity1-1, buffer.size());
		}
		
		
		/**
		 * THEN
		 * Test común que comprueba si se ha recogido en la variable IllegalStateException_thrown la excepción
		 */
		
		@Then("test should thrown an IllegalStateException")
		public void test_should_thrown_an_illegal_state_exception() {
			assertTrue(IllegalStateException_thrown);

		}
		
		/**
		 * THEN
		 * Test común que comprueba si se ha recogido en la variable IllegalArgument_thrown la excepción
		 */
		
		@Then("test should thrown an IllegalArgumentException")
		public void test_should_thrown_an_illegal_argument_exception() {
			assertTrue(IllegalArgument_thrown);
		}
		
	}
	
	

