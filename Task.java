
public class Task {
	private int timeT;
	private int id;
	
	public Task(int id, int timeT) {
		this.id = id;
		this.timeT = timeT;
	}
	public Task() {
		this.id = id;
	}
	
	public int getTime() {
		return this.timeT;
	}
	
	public int getAllTime() {
		return 1;
	}
}
