
public class Processor implements Comparable<Processor>{
	private int id;
	private int time;
	DataList<Task> processedTasks = new DataList<Task>();
	
	Processor(int id){
		this.id = id;
		this.processedTasks = null;
	}
	
	Processor(int id , int timeP){
		this.id = id;
		this.processedTasks = null;
		this.time = time;
	}
	
	
	void getActiveTime() {
		for(int i = 0; i<processedTasks.size();i++) {
			this.time += processedTasks.get(i).getTime();
		}
		
	}
	
	public int getTimeP() {
		return time;
		}
	public int getId() {
		return this.id;
	}
	
	public DataList<Task> getProcessedTasks(){
		return this.processedTasks;
	}
	
	public int compareTo(Processor p1) {
		// TODO Auto-generated method stub
		if(this.getTimeP() > p1.getTimeP())
			return 0;
		else if (this.getTimeP() == p1.getTimeP()) {
			if(this.getId() > p1.getId()) {
				return 1;
			}
			else
				return 2;
		}
		return 3;
	}
	
}
