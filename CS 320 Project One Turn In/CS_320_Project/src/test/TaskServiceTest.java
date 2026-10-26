package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java_main.Task;
import java_main.TaskService;

class TaskServiceTest {

	@Test
	void testAddTask() {
		TaskService service = new TaskService();
		Task task = new Task("1", "Do dishes", "For this chore you are to wash the dishes");
		
		service.addTask(task);
		
		assertNotNull(service.findTask("1"));
		
		assertEquals("1", service.findTask("1").getTaskId());
		assertEquals("Do dishes", service.findTask("1").getTaskName());
		assertEquals("For this chore you are to wash the dishes", service.findTask("1").getTaskDesc());
	}
	@Test
	void testDeleteTask() {
		TaskService service = new TaskService();
		Task task = new Task("1", "Do dishes", "For this chore you are to wash the dishes");
		
		service.addTask(task);
		service.deleteTask("1");
		assertNull(service.findTask("1"));
	}
	@Test
	void testUpdateTask() {
		TaskService service = new TaskService();
		Task task = new Task("1", "Do dishes", "For this chore you are to wash the dishes");
		
		service.addTask(task);
		service.updateTaskName("1", "Dry dishes");
		service.updateTaskDesc("1", "New Description");
		
		assertEquals("Dry dishes", service.findTask("1").getTaskName());
        assertEquals("New Description", service.findTask("1").getTaskDesc());
        assertEquals("1", service.findTask("1").getTaskId());
	}
	@Test
	void testAddDuplicateTaskIdNotAllowed() {
		TaskService service = new TaskService();
		Task task1 = new Task("1", "Do laundry", "For this chore you are to wash the laundry");
		Task task2 = new Task("1", "Do dishes", "For this chore you are to wash the dishes");
			
		service.addTask(task1);
			
		assertNotNull(service.findTask("1"));
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.addTask(task2);
			
			
		});
	}
}
