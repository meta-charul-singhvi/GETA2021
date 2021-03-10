/*
 * @author : Charul Singhvi
 * @date : 10-03-2021
 * @calCompTime -> Completion Time: Time taken for the execution to complete, starting from arrival time of first process.
 * @calWaitTime -> Waiting Time: Total time the process has to wait before it's execution begins. It is the difference between the Turn Around time and the Burst time of the process.
 * @calTurnAroundTime -> Turn Around Time: Time taken to complete after arrival. In simple words, it is the difference between the Completion time and the Arrival time.
 * Burst Time : Time required to execute a process.
 */

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;


public class JobSchedulingFCFS {
	
	public static HashMap<Integer, Integer> FCFS = new HashMap<Integer,Integer>();
	/*
	 * Calculation completion time for a process
	 */
	static int[] calCompTime(int[][] process, int n){
		int[] compTime = new int[n];
		
		compTime[0] = process[0][1];
		for(int i=1; i<n; i++){
			/*
			 * checking if the completion time of earlier process is less than arrival 
			 *time of the current
			 */
			if(process[i][0] > compTime[i-1]){
				compTime[i] = (process[i][0] - compTime[i-1]);
			}
			compTime[i] += process[i][1] + compTime[i-1];
		}
		return compTime;
	}
	
	/*
	 * Calculation waiting time for a process
	 */
	static int[] calWaitTime(int[][] process, int[] compTime, int n){
		int[] waitingTime = new int[n];

		for(int i=1; i<n; i++){
			if(process[i][0]<compTime[i-1])
				waitingTime[i] =  compTime[i-1] - process[i][0];
		}
		return waitingTime;
	}
	
	/*
	 * Calculation Turn Around time time for a process
	 */
	static int[] calTurnAroundTime(int[] compTime, int[][] process, int n){
		int[] turnArdTime = new int[n];
		for(int i=0; i<n; i++){
			turnArdTime[i] =  compTime[i] - process[i][0];
		}
		return turnArdTime;
	}
	
	static int[][] sortFcfs(int[][] process , int n){
		int[] smallRow = process[0];
		for(int i=0; i<n; i++){
			smallRow = process[i];
			int j=i+1;
			for(; j<n; j++){
				if(process[j][0] < process[i][0]){
					process[i] = process[j];
					process[j] = smallRow;
					smallRow = process[j];
				}
			}
		}
		return process;
	}
	
	public static void main(String[] args)throws InputMismatchException, NullPointerException, Exception {
		try{	
			Scanner scan = new Scanner(System.in);
			System.out.print("Enter the number of processes : ");
			int n = scan.nextInt();
			int[][] process = new int[n][2];
			for(int i=0; i<n; i++){
				System.out.print("Enter arrival time for process "+i+": ");
				process[i][0] = scan.nextInt();
				while(process[i][0]<0){
					System.out.print("Enter valid arrival time for process "+i+": ");
					process[i][0] = scan.nextInt();
				}
				System.out.print("Enter burst time for process "+i+": ");
				process[i][1] = scan.nextInt();
				while(process[i][1]<0){
					System.out.print("Enter valid burst time for process "+i+": ");
					process[i][0] = scan.nextInt();
				}
				
			}
			process = sortFcfs(process, n);
			int[] compTime = calCompTime(process,n);
			int[] waitTime = calWaitTime(process,compTime,n);
			int[] turnAroundTime = calTurnAroundTime(compTime,process,n);
			int maxWaitTime = 0;
			int maxTimeProcess = 0;
			int sumWait=0;
			
			System.out.println("Process\tArrival Time\tBurst Time\tCompletion Time\tWaiting Time\tTurn Around Time");
			for(int i=0; i<n; i++){
				System.out.println("P"+i+"\t"+process[i][0]+"\t\t"+process[i][1]+"\t\t"
						+compTime[i]+"\t\t"+waitTime[i]+"\t\t"+turnAroundTime[i]);
				sumWait += waitTime[i];
				if(maxWaitTime < waitTime[i]){
					maxWaitTime = waitTime[i];
					maxTimeProcess = i;
				}
			}
			double size = n;
			double avgWaitTime = sumWait/size;
			System.out.println("Average Waiting Time : "+ avgWaitTime +" ms");
			System.out.println("Maximum Waiting Time is "+ maxWaitTime+ " ms for process P"+maxTimeProcess);
			
			scan.close();
		}
		catch(InputMismatchException e){
			System.out.println("Please enter integer input!");
		}
		catch(NullPointerException e){
			System.out.println("Please enter some value!");
		}
		catch(Exception e){
			System.out.println("Invalid input!");
		}
	}

}
