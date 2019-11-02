package onlineCoaching.course2.generics;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

public class SortedPairTest {
	
	@Test
	public void shouldRetainOrderOfOrderedPair() {
		//Integer implements Comparable<Integer>
		
		SortedPair<Integer> pair = new SortedPair<>(1,2);
		
		assertEquals(1, pair.getFirst().intValue());
		assertEquals(2, pair.getSecond().intValue());
	}
	
	@Test
	public void shouldFlipOrderOfMisorderedPair() {
		SortedPair<Integer> pair = new SortedPair<>(2,1);
		
		assertEquals(1, pair.getFirst().intValue());
		assertEquals(2, pair.getSecond().intValue());
	}
}
