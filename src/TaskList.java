import java.util.LinkedList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TaskList {
	
	LinkedList<Task> tasks = new LinkedList<Task>();
	
	public void addTask(int year, int month, int dayOfMonth, int hours, int minutes, String newDescription, int newDoesRepeat, int newDays) {
		
		LocalDateTime dd = LocalDateTime.of(year, month, dayOfMonth, hours, minutes);
		
		if(newDoesRepeat > 10) {
			System.out.println("This is only a demo, max repeating Tasks are 10.");
			return;
		}
		
		if(newDoesRepeat == 0) {
			if(tasks.size() == 0) {
				tasks.add(new Task(dd, newDescription, false));
				System.out.print("Added New Task: ");
				tasks.getFirst().printOut();
			} else {
				for(int i=0; i < tasks.size(); i++) {
					if(tasks.get(i).compareTo(dd) > 0) {
						tasks.add(i, new Task(dd, newDescription, false));
						System.out.print("Added New Task: ");
						tasks.get(i).printOut();
						return;
					}
				}
			}
		} else {
			System.out.println("Adding Task To Repeat For "+newDoesRepeat+" Times Every "+newDays+" Days:");
			for(int i=0; i < newDoesRepeat; i++) {
				if(tasks.get(i).compareTo(dd) > 0) {
					tasks.add(i, new Task(dd, newDescription, false));
					dd = dd.plusDays(newDays);
					System.out.print("Added New Task: ");
					tasks.get(i).printOut();
				}
			}
		System.out.println("Added All Tasks Suscessfully.");
		}
	}
	
	public void delTask(int year, int month, int dayOfMonth, int hours, int minutes) {
		
		if(tasks.size() < 1) {
			System.out.println("No Tasks added yet. Please add Task first.");
			return;
		}
		
		LocalDateTime dd = LocalDateTime.of(year, month, dayOfMonth, hours, minutes);
		for(int i=0; i < tasks.size(); i++) {
				if(tasks.get(i).compareTo(dd) == 0) {
					System.out.print("Deleting Task: ");
					tasks.get(i).printOut();
					tasks.remove(i);
					return;
				}
		}
		DateTimeFormatter formatDueDate = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String formattedDate = dd.format(formatDueDate);
		System.out.println("Error: Did not find matching Task with due Date: "+formattedDate+" To Remove.");
	}
	
	public void setDone(int year, int month, int dayOfMonth, int hours, int minutes) {
		
		if(tasks.size() < 1) {
			System.out.println("No Tasks added yet. Please add Task first.");
			return;
		}
		
		LocalDateTime dd = LocalDateTime.of(year, month, dayOfMonth, hours, minutes);
		for(int i=0; i < tasks.size(); i++) {
			if(tasks.get(i).compareTo(dd) == 0) {
				if(tasks.get(i).getIsDone()) {
					System.out.print("Task Is Already Set As Done: ");
					tasks.get(i).printOut();
					return;
				} else {
					tasks.get(i).setIsDone(true);
					System.out.print("Task Is Done Now: ");
					tasks.get(i).printOut();
					return;
				}
			}
		}
		DateTimeFormatter formatDueDate = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String formattedDate = dd.format(formatDueDate);
		System.out.println("Error: Did not find matching Task with due Date: "+formattedDate+" To Set To Done.");
	}
	
	public void getAllTasks() {
		
		if(tasks.size() < 1) {
			System.out.println("No Tasks added yet. Please add Task first.");
			return;
		}
		
		System.out.println("Current Number of Tasks In Total: "+tasks.size());
		for(int i=0; i < tasks.size(); i++) {
			tasks.get(i).printOut();
		}
	}
	
	public void getDoneTasks() {
		
		if(tasks.size() < 1) {
			System.out.println("No Tasks added yet. Please add Task first.");
			return;
		}
		
		System.out.println("All Tasks Done:");
		boolean f = false;
		for(int i=0; i < tasks.size(); i++) {
			if(tasks.get(i).getIsDone()) {
				tasks.get(i).printOut();
				f = true;
			}
		}
		if(f == false) {
			System.out.println("No Tasks are Done yet.");
		}
	}

	public void getOpenTasks() {
		
		if(tasks.size() < 1) {
			System.out.println("No Tasks added yet. Please add Task first.");
			return;
		}
		
		System.out.println("All Tasks Open:");
		boolean found = false;
		for(int i=0; i < tasks.size(); i++) {
			if(tasks.get(i).getIsDone() == false) {
				tasks.get(i).printOut();
				found = true;
			}
		}
		if(found == false) {
			System.out.println("Everything is done. Enjoy your free day.");
		}
	}

	public void getNextTask() {
		
		if(tasks.size() < 1) {
			System.out.println("No Tasks added yet. Please add Task first.");
			return;
		}
		
		System.out.print("Next Upcoming Task: ");
		LocalDateTime dd = LocalDateTime.now();
		for(int i=0; i < tasks.size(); i++) {
			if(tasks.get(i).compareTo(dd) > 0 && tasks.get(i).getIsDone() == false) {
				tasks.get(i).printOut();
				break;
			}
		}
	}
	
	public void getTaskByDescription(String desc) {
		
		if(tasks.size() < 1) {
			System.out.println("No Tasks added yet. Please add Task first.");
			return;
		}
		
		System.out.println("Searching For Tasks With Description: "+desc);
		boolean found = false;
		for(int i=0; i < tasks.size(); i++) {
			if(tasks.get(i).getDescription().toLowerCase().contains(desc.toLowerCase())) {
				tasks.get(i).printOut();
				found = true;
			}
		}
		
		if(found == false) {
			System.out.println("No Matching Tasks Found.");
		}
	}
	
	public void printToFile() {
		
		if(tasks.size() < 1) {
			System.out.println("No Tasks added yet. Please add Task first.");
			return;
		}
		
		try {
			File output = new File("./tasklist.csv");
			if(output.createNewFile()) {System.out.println("New File Created.");}
			
			FileWriter wr = new FileWriter("./tasklist.csv");
			wr.write("Due Date, Due Time, Description, IsDone\n");
			DateTimeFormatter formatDueDate = DateTimeFormatter.ofPattern("yyyyMMdd");
			DateTimeFormatter formatDueTime = DateTimeFormatter.ofPattern("HH:mm");
			for(int i=0; i < tasks.size(); i++) {
				String formattedDate = tasks.get(i).getDueDate().format(formatDueDate);
				String formattedTime = tasks.get(i).getDueDate().format(formatDueTime);
				wr.append(formattedDate+","+formattedTime+","+tasks.get(i).getDescription()+","+tasks.get(i).getIsDone()+"\n");
			}
			wr.close();
			System.out.println("Writing TaskList To File Was Successful.");
		} catch (IOException e) {
			System.out.println("ERROR While Writing To File.");
			e.printStackTrace();
		}
	}
}
