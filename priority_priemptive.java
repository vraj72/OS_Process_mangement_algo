/*priority preemptive scheduling, the scheduler ensures that at any given time, the processor executes the highest priority task of all those tasks that are currently ready to execute.*/

import java.util.*; 
import java.lang.*; 
import java.io.*; 

class SortByArrival implements Comparator<priority_priemptive> 
{ 
    
    public int compare(priority_priemptive a, priority_priemptive b) 
    { 
        return a.arvl - b.arvl; 
    } 
} 

class SortBypriority implements Comparator<priority_priemptive> 
{ 
    
    public int compare(priority_priemptive a, priority_priemptive b) 
    { 
        return a.pr - b.pr; 
    } 
} 

public class priority_priemptive {

	int arvl,brst,status,startpt,name,pr,end,exc;

	public priority_priemptive(int arrival ,int burst,int priority,char ch )
	{
	this.arvl=arrival;
	this.brst=burst;
	this.status=-2;
	this.startpt=-1;
	this.name=ch;
	this.pr=priority;
	this.end=0;
	this.exc=0;}


    public static void main(String[] args) {

	Scanner reader = new Scanner(System.in);
        int size;//job numbers

	do{
	System.out.print("Enter number of jobs: ");
	size = reader.nextInt();
	if(size<0) { System.out.println("entered negative value!! again enter : "); }}while(size<0);

       	priority_priemptive[] job =new priority_priemptive[size];
	int a,b,p; 

	for(int i=0;i<size;i++)
	{
	System.out.println("JOB NO - "+(i+1));

	do{
        System.out.print("Enter a Arrival Time: ");
	 a = reader.nextInt();
		if(a<0) { System.out.println("entered negative value!! again enter : "); }}while(a<0);
	
	do{
        System.out.print("Enter a burst Time: ");
	 b= reader.nextInt();
		if(b<1) { System.out.println("entered negative value!! again enter : "); }}while(b<1);

	do{
	System.out.print("Enter a priority: ");
	 p = reader.nextInt();
		if(p<0) { System.out.println("entered negative value!! again enter : "); }}while(p<0);
		System.out.println();
		
	job[i]=new priority_priemptive(a,b,p,(char)('A'+i));

	 }

	System.out.println("unsorted\nJOB NO\tname\tarrival time\tburst time\tpriority\n");
	for(int i=0;i<size;i++)
	System.out.println((i+1)+"\t"+(char)(job[i].name)+"\t    "+job[i].arvl+"\t         "+job[i].brst+"\t      "+job[i].pr+"\n");

	Arrays.sort(job, new SortBypriority()); 

	/*System.out.println("\n\nsorted\nJOB NO\tname\tarrival time\tburst time\tpriority\n");
	for(int i=0;i<size;i++)
	System.out.println((i+1)+"\t"+(char)(job[i].name)+"\t    "+job[i].arvl+"\t         "+job[i].brst+"\t      "+job[i].pr+"\n");*/
	

	int time=0,pt=0,flag=-1,min;
	System.out.print("Grant Chart - |");

	while(pt<size)
	{

	flag=-1;
	for(int i=0;i<size;i++)
	if(job[i].arvl<=time && job[i].status!=0) {flag=i;break;}
	
	
	
	if(flag>-1) 
	{if(job[flag].status==-2) {job[flag].startpt=time;  job[flag].status=-1;}

	System.out.print((char)job[flag].name+"|");
	time++;job[flag].exc+=1;

	if(job[flag].exc==job[flag].brst){pt++;job[flag].status=0;job[flag].end=time;}
	}
	else {System.out.print("*|	");time++;}
	

	
	
	}System.out.print("\n\n");

	System.out.println("Table\nJOB NO\tname\tarrivale time\tburst time\tpriority\tstart time\twaiting time\tendtime\tturnaround time\n");
	for(int i=0;i<size;i++)
	
System.out.println((i+1)+"\t"+(char)(job[i].name)+"\t    "+job[i].arvl+"\t         "+job[i].brst+"\t          "+job[i].pr+"\t         "+job[i].startpt+"\t          "+(job[i].end-job[i].arvl-job[i].brst)+"\t        "+(job[i].end)+"\t        "+(job[i].end-job[i].arvl)+"\n");


System.out.print("\n\n");
float aw=0,at=0;
for(int i=0;i<size;i++){at+=+(job[i].end-job[i].arvl);  aw+=(job[i].end-job[i].arvl-job[i].brst);}
System.out.println("Average Waiting time:-  "+(aw/size)+"\nAverage Turnaround time:-  "+(at/size)+"\n");

}
}
/*


*/
