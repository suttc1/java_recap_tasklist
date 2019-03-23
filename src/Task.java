import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task {
	
	private LocalDateTime dueDate;
	private String description;
	private Boolean isDone;
	
	public Task (LocalDateTime dueDate, String description, Boolean isDone){
		this.dueDate = dueDate;
		this.description = description;
		this.isDone = isDone;
	}

	LocalDateTime getDueDate() {
		return this.dueDate;
	}
	
	String getDescription() {
		return this.description;
	}
	
	Boolean getIsDone() {
		return this.isDone;
	}
	
	void setIsDone(Boolean b) {
		this.isDone = b;
	}
	
	void printOut() {
		DateTimeFormatter formatDueDate = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String formattedDate = this.dueDate.format(formatDueDate);
		System.out.println("Duedate: "+formattedDate+" Description: "+this.description+" Done: "+this.isDone);
	}

	public int compareTo(LocalDateTime dueDate) {
		//System.out.println(getDueDate().compareTo(dueDate));
		return getDueDate().compareTo(dueDate);
	}
	
}
