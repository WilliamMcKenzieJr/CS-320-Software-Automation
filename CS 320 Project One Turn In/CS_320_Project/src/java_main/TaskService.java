package java_main;

import java.util.ArrayList;
import java.util.List;

public class TaskService {
		List<Task> tasks = new ArrayList<>();
		
	    public void addTask(Task task) {
	        if (task == null) {
	            throw new IllegalArgumentException("Task cannot be null");
	        }

	        if (findTask(task.getTaskId()) != null) {
	            throw new IllegalArgumentException("Task ID already exists");
	        }

	        tasks.add(task);
	    }
	    public void deleteTask(String taskId) {
	        Task task = findTask(taskId);

	        if (task == null) {
	            throw new IllegalArgumentException("Task not found");
	        }

	        tasks.remove(task);
	    }
	    public void updateTaskName(String taskId, String taskName) {
	        Task task = findTask(taskId);

	        if (task == null) {
	            throw new IllegalArgumentException("Task not found");
	        }

	        task.setTaskName(taskName);
	    }
	    public void updateTaskDesc(String taskId, String taskDesc) {
	        Task task = findTask(taskId);

	        if (task == null) {
	            throw new IllegalArgumentException("Task not found");
	        }

	        task.setTaskDesc(taskDesc);
	    }

	    public Task findTask(String taskId) {
	        for (Task task : tasks) {
	            if (task.getTaskId().equals(taskId)) {
	                return task;
	            }
	        }

	        return null;
	    }
	}