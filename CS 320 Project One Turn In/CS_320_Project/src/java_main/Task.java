package java_main;

public class Task {
	private final String taskId;
	private String taskName;
	private String taskDesc;
	
	public Task(String taskId, String taskName, String taskDesc) {
		if(taskId == null || taskId.length()>10) {
			throw new IllegalArgumentException("Invalid id");
		}
		if(taskName == null || taskName.length()>20) {
			throw new IllegalArgumentException("Invalid name");
		}
		if(taskDesc == null || taskDesc.length()>50) {
			throw new IllegalArgumentException("Invalid Description");
		}
		this.taskId = taskId;
		this.taskName = taskName;
		this.taskDesc = taskDesc;
	}
	public String getTaskId() {
		return taskId;
	}
	public String getTaskName() {
		return taskName;
	}
	public String getTaskDesc() {
		return taskDesc;
	}
	
	public void setTaskName(String taskName) {
        if (taskName == null || taskName.length() > 20) {
            throw new IllegalArgumentException("Invalid name");
        }

        this.taskName = taskName;
    }
	
	public void setTaskDesc(String taskDesc) {
        if (taskDesc == null || taskDesc.length() > 50) {
            throw new IllegalArgumentException("Invalid description");
        }

        this.taskDesc = taskDesc;
    }
	
}