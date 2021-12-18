import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;
public class Greedy {
	int pros;
	int tasks;
	int counter=0;
	int Makespan=0;
	Processor tempP;
	PQInterface pq = new MaxPQ();
	String s;
	DataList<Task> x;
	Greedy(DataList<Task> x,int pros,int tasks) throws FileNotFoundException{
		this.x =x;
		this.pros = pros;
		this.tasks=tasks;
		}
		
	public void run() {
	for(int i =1;i<=pros;i++) {  //edo ftiaxno kai bazo tous Processors sthn MaxPQ
		Processor p = new Processor(i);
		pq.insert(p);
	}
	for(int i=0;i<x.size();i++) {  //edo ginetai h anauesh ton diergasion 
		tempP = pq.getmax();
		tempP.processedTasks.add(x.get(i));
		pq.insert(tempP);
		counter++;
	}
	check:  //o counter metra apo thn 3h grammh os to telos ki an den einai idios me ton ariumo ton diergasion emfanizei mhnuma gia error
	{
	if(counter!=tasks) {
		System.out.println("error!\nThe number of Tasks that given doesnt match with number of Tasks i received");
		break check;
		}
	
	for(int i=1;i<= pros;i++) {
		System.out.print("id " + pq.max().getId() + ", load=" + pq.max().getTimeP() + ": ");
			for(int j=0;j<pq.max().processedTasks.size();j++) {
				System.out.print(pq.max().processedTasks.get(j).getTime()+" ");
			}
			System.out.println();
			if(Makespan< pq.max().getTimeP());
			Makespan = pq.max().getTimeP();
			pq.getmax();
	}
	
	System.out.println("Makespan = " + Makespan);
	}
	counter=0;
	
}
//	public void Sorting() {
//		Sort z = new Sort(this.x);
//	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		txtReader k = new txtReader(args[0]);
		Greedy x = new Greedy(k.taskList,Integer.parseInt(k.lines.get(0)),Integer.parseInt(k.lines.get(1)));
		x.run();	
		System.out.println("\nSORTED\n");
		//x.Sorting();
		x.run();
	}

}
