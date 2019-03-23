public class TaskListTester {
	public static void main(String[] args) {
		
		TaskList tl = new TaskList();
		tl.addTask(2019, 11, 12, 22, 30, "first test", 0, 0);
		tl.addTask(2019, 3, 5, 20, 00, "second test repeat", 10, 7);
		tl.addTask(2019, 4, 8, 20, 00, "third test", 0, 0);
		tl.addTask(2019, 3, 30, 14, 00, "Buy Milk", 0, 0);
		tl.addTask(2019, 3, 10, 9, 00, "Clean Desk", 0, 0);
		tl.setDone(2019, 3, 26, 20, 00);
		tl.getNextTask();
		tl.setDone(2019, 3, 30, 14, 00);
		tl.getDoneTasks();
		tl.getAllTasks();
		tl.setDone(2019, 4, 9, 20, 00);
		tl.setDone(2019, 3, 19, 20, 00);
		tl.getAllTasks();
		tl.delTask(2019, 4, 30, 20, 00);
		tl.getAllTasks();
		tl.addTask(2019, 4, 1, 10, 30, "task four", 0, 0);
		tl.getAllTasks();
		tl.getDoneTasks();
		tl.getOpenTasks();
		tl.getNextTask();
		tl.getTaskByDescription("ilk");
		tl.printToFile();
	}
}
