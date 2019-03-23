package pminds_pokemon;

import static org.junit.Assert.*;
import org.apache.commons.lang3.StringUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TrainerAshTest {

	private static TrainerAsh ASH;

	@BeforeClass
	public static void initTests() {
		ASH = new TrainerAsh();
	}


	@Test
	public void emptyInputTest() {
		String empty = "";
		int expectedOutput = 1;
		ASH.catchPokemons(empty);
		assertEquals("Empty string must have output 1", 
				expectedOutput, ASH.getPokemonCounter());
	}


	@Test
	public void normalInputTest() {
		String normalInput1 = "E";
		String normalInput2 = "NESO";
		String normalInput3 = "NSNSNSNSNS";
		int expectedOutput1 = 2;
		int expectedOutput2 = 4;
		int expectedOutput3 = 2;
		ASH.catchPokemons(normalInput1);
		assertEquals("Normal input [E] string must have output 2", 
				expectedOutput1, ASH.getPokemonCounter());
		ASH.catchPokemons(normalInput2);
		assertEquals("Normal input [NESO] string must have output 4", 
				expectedOutput2, ASH.getPokemonCounter());
		ASH.catchPokemons(normalInput3);
		assertEquals("Normail input [NSNSNSNSNS] string must have output 2", 
				expectedOutput3, ASH.getPokemonCounter());
	}


	@Test
	public void garbageInputTest() {
		String garbageInput1 = "% $        ////1109..........";
		String garbageInput2 = "^««««««2«+2...222´´´ ´´´´´  1@££§€66{";
		int expectedOutput = 1;
		ASH.catchPokemons(garbageInput1);
		assertEquals("Garbage input [% $        ////1109..........] string must have output 1", 
				expectedOutput, ASH.getPokemonCounter());
		ASH.catchPokemons(garbageInput2);
		assertEquals("Garbage input [^««««««2«+2...222´´´ ´´´´´  1@££§€66{] string must have output 1", 
				expectedOutput, ASH.getPokemonCounter());
	}


	@Test
	public void mixedInputTest() {
		String mixedInput1 = "%3#nN==00 ^^ n##NN N";
		String mixedInput2 = "NYUINVBNTYUN";
		// Couting number of [N and n] and adding 1. 
		// The "plus 1" represents the starting place on the grid. 
		int expectedOutput1 = StringUtils.countMatches(mixedInput1, "n") +
				StringUtils.countMatches(mixedInput1, "N") + 1;
		int expectedOutput2 = StringUtils.countMatches(mixedInput2, "n") +
				StringUtils.countMatches(mixedInput1, "N") + 1;
		ASH.catchPokemons(mixedInput1);
		assertEquals("Mixed input [%3#nN==00 ^^ n##NN N] string must have output 7", 
				expectedOutput1, ASH.getPokemonCounter());
		ASH.catchPokemons(mixedInput2);
		assertEquals("Garbage input [NYUINVBNTYUN] string must have output 5", 
				expectedOutput2, ASH.getPokemonCounter());
	}


	@Test
	public void biggestInputTest() {
		int expectedOutput1 = 1;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < PokemonFXMLController.MAX_INPUT_SIZE; i++) {
			sb.append('a');
		}
		ASH.catchPokemons(sb.toString());
		assertEquals("Biggest input [aaa(...)aaa] string must have output 1", 
				expectedOutput1, ASH.getPokemonCounter());
	}


	@Test
	public void biggestInputTestTime() {
		// The "plus 1" represents the starting place on the grid 
		long startTime = System.currentTimeMillis();
		int expectedOutput2 = PokemonFXMLController.MAX_INPUT_SIZE + 1;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < PokemonFXMLController.MAX_INPUT_SIZE; i++) {
			sb.append('N');
		}
		ASH.catchPokemons(sb.toString());
		assertEquals("Biggest input [NNN(...)NNN] string must have output 10001", 
				expectedOutput2, ASH.getPokemonCounter());
		long endTime = System.currentTimeMillis();
		long duration = endTime-startTime;
		// Programme shouldn't take longer than 20 seconds, given max input
		long maxPermittedDuration = 20*1000;
		assertTrue("Programme is taking longer than 20 seconds", duration < maxPermittedDuration);
	}
	
	
	@AfterClass
	public static void cleanUp() {
		ASH.initTrainerAsh();
		// If there is no reference to the object, it will be deleted by the garbage collector
		ASH = null;
	}
}






