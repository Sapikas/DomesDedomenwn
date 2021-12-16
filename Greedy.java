import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Greedy {
	public static void main(String[] args) throws IOException {
		
		File file = new File("E:\\ssd_m2\\Desktop\\Ergasia2_Domes.txt");
		Scanner input = new Scanner(file);
		Processor temp;
		int count = 0;
		PQInterface pq = new MaxPQ();
		ListOfNodes<Processor> lon = new ListOfNodes<Processor>();
		ListOfNodes<Processor> new_lon = new ListOfNodes<Processor>();
	  	Processor min = null;
	  	int min1 = 0;
	  	Task temp1 = null;
	  	Processor temp2 = null;
	  	int z = 1;
	  	int numOfProc = 0;
		while (input.hasNext()) {
		      String word  = input.next();
		      int word1 = Integer.parseInt(word);
		      count++;
		      if (count == 1) {
		    	  int i =1; 
		    	  numOfProc = word1;
		    	  while (word1 != 0) {
		    		  Processor pr = new Processor(i);
		    		  pq.insert(pr);
		    		  i++;
		    		  word1--;
		    	  }
		      }else if (count == 2) {
		    	  continue;
		      }else {
		    	  String new_word  = input.next();
		    	  int new_word1 = Integer.parseInt(new_word);
		    	  Task T = new Task(word1, new_word1); //task
		    	  temp = pq.getmax(); //processor
		    	  if (temp!=null) {
		    		  lon.insert(temp, T); //pairnaw san parametro to Processor temp kai to Task T  kai dhmiourgw syndesh anamesa tous
		    		  //System.out.println(T.getTime());
		    	  }else {
			    	  while (lon.isEmpty() != true) {
				    	  if (z==1) {
				    		temp1 = lon.peek_task_item();
				    		temp2 = lon.peek_item();
				    		min = lon.get(); 
				    		min1 = min.getActiveTime();
				    	  }else {
				    		 Task temp_task = lon.peek_task_item();
				    		 Processor temp_proc = lon.peek_item();
				    		 Processor new_min = lon.get();
				    		 //System.out.println(new_min.getActiveTime());
				    		 if (new_min.getActiveTime() < min1) {
				    			 new_lon.insert(temp2, temp1);
				    			 temp1 = temp_task;
				    			 temp2 = temp_proc;
				    			 min = new_min;
				    			 min1 = new_min.getActiveTime();
				    			 //System.out.println(min1);
				    		 }else {
				    			 new_lon.insert(temp_proc, temp_task);
				    		 }
				    		 
				    	  }
				    	  //System.out.println(min.getActiveTime());
				    	  z++;
			    	  }
			    	  min.add(T);
			    	  System.out.println(min.getActiveTime());
			    	  if (new_lon.Size() < numOfProc) {
			    		 new_lon.insert(temp2, temp1);  
				    	  while (new_lon.isEmpty()!=true) {
				    		  Task temp11 = new_lon.peek_task_item();
					  		  Processor temp12 = new_lon.peek_item();
					  		  new_lon.get();
					  		  lon.insert(temp12,temp11);
					  		  System.out.println(lon.peek_item().getActiveTime());
			    		 //System.out.println(new_lon.Size());
				    	  }
//			    	  System.out.println(min.processedTasks.get());
//			    	  System.out.println(min.processedTasks.get());
			    	  System.out.println(min.getActiveTime());
			    	  }
//		    	  new_lon.insert(temp2, temp1);
//		    	  }
		     }
		 }
//		new_lon.insert(temp2, temp1);
//	  	  //lon = new_lon;
//	  	  while (new_lon.isEmpty()!=true) {
//	  		  Task temp11 = new_lon.peek_task_item();
//	  		  Processor temp12 = new_lon.peek_item();
//	  		  new_lon.get();
//	  		  lon.insert(temp12,temp11);
//	  		  //System.out.println(lon);
//	  	  }
	}
	}
}
