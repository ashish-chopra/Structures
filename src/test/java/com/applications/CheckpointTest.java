package com.applications;

import junit.framework.TestCase;

public class CheckpointTest extends TestCase {

	public void testBasicOperations() {
		Checkpoint<Integer> checkpoint = new Checkpoint<Integer>();
		assertEquals(0, checkpoint.size());
		assertEquals(true, checkpoint.isEmpty());
		
	}
	
	public void testAddOperation() {
		Checkpoint<Integer> checkpoint = new Checkpoint<Integer>();
		checkpoint.add(23);
		checkpoint.add(11);
		checkpoint.add(43);
		checkpoint.add(12);
		checkpoint.add(11);
		checkpoint.add(10);
		
		assertEquals(false, checkpoint.isEmpty());
		assertEquals(6, checkpoint.size());
		
		checkpoint.add(99);
		assertEquals(7, checkpoint.size());
		
	}
	
	public void testUndoRedoOperations() {
		Checkpoint<Integer> checkpoint = new Checkpoint<Integer>();
		checkpoint.add(23);
		checkpoint.add(11);
		checkpoint.add(43);
		checkpoint.add(12);
		checkpoint.add(11);
		checkpoint.add(10);
		
		assertEquals(false, checkpoint.isEmpty());
		assertEquals(6, checkpoint.size());
		
		Integer code = checkpoint.undo();
		assertEquals(6, checkpoint.size());
		assertEquals(new Integer(10), code);
		
		code = checkpoint.undo();
		assertEquals(6, checkpoint.size());
		assertEquals(new Integer(11), code);
		
		checkpoint.add(100);
		assertEquals(5, checkpoint.size());
		
		code = checkpoint.redo();
		assertNull(code);
		
		checkpoint.undo();
		checkpoint.undo();
		
		code = checkpoint.redo();
		assertEquals(new Integer(12), code);
		assertEquals(5, checkpoint.size());
		
	}
}
