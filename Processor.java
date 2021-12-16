
public class Processor implements Comparable<Processor>{
	public List<Task> processedTasks = new List<Task>();
	//private Task[] pt;
	private int id;
	//private int time;
	
	public Processor(int id){
		this.id = id;
	}
	
	public void add(Task t) {
		processedTasks.insert(t);
	}
	
	public int getActiveTime() {
		return processedTasks.getTime();
	}

	@Override
	public int compareTo(Processor o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
