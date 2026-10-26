package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java_main.Task;

class TaskTest {

	@Test
	void testTask() {
		Task task = new Task("1284479", "Do dishes", "For this chore you are to wash the dishes");
		assertTrue(task.getTaskId().equals("1284479"));
		assertTrue(task.getTaskName().equals("Do dishes"));
		assertTrue(task.getTaskDesc().equals("For this chore you are to wash the dishes"));
	}
	// This test verifies the length does not exceed 10 characters
	@Test
	void testTaskIdToLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("12844798423984", "Do dishes", "For this chore you are to wash the dishes");
		});
	}
	// This test verifies the length does not exceed 20 characters
	@Test
	void testTaskNameToLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("1284479", "Do the dishes and put them away", "For this chore you are to wash the dishes");
		});
	}
	// This test verifies the length does not exceed 50 characters
	@Test
	void testTaskDescToLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("1284479", "Do dishes", "For this chore you are to wash the dishes with soap and water, then you are to rinse them off, then dry them off.");
		});
	}
	@Test
	void testNullTaskId() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task(null, "Do dishes", "For this chore you are to wash the dishes");
		});
	}
	@Test
	void testNullTaskName() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("1284479", null, "For this chore you are to wash the dishes");
		});
	}
	@Test
	void testNullTaskDesc() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("1284479", "Do dishes", null);
		});
	}
	
	
}
