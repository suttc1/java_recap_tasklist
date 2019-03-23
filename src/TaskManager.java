import java.time.LocalDateTime;

public abstract class TaskManager {
	
	//public TaskList tl = new TaskList();
	
	public void addTask(TaskManager newTask) {
		throw new UnsupportedOperationException();
	}
	
	public void delTask(TaskManager newTask) {
		throw new UnsupportedOperationException();
	}
	
	public void setDone(TaskManager newTask) {
		throw new UnsupportedOperationException();
	}

/*
	public void addTask(int year, int month, int dayOfMonth, int hours, int minutes, String description, int doesRepeat) {
		LocalDateTime dueDate = LocalDateTime.of(year, month, dayOfMonth, hours, minutes);
		tl.addTask(dueDate, description, doesRepeat);
	}
	
	public void delTask(int year, int month, int dayOfMonth, int hours, int minutes) {
		LocalDateTime dueDate = LocalDateTime.of(year, month, dayOfMonth, hours, minutes);
		tl.delTask(dueDate);
	}
	
	public void setDone(int year, int month, int dayOfMonth, int hours, int minutes) {
		LocalDateTime dueDate = LocalDateTime.of(year, month, dayOfMonth, hours, minutes);
		tl.setTaskDone(dueDate);
	}
*/
}
