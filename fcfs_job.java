import java.util.*; 
import java.lang.*; 
import java.io.*; 

class SortByArrival implements Comparator<fcfs_job> 
{ 
    
    public int compare(fcfs_job a, fcfs_job b) 
    { 
        return a.arvl - b.arvl; 
    } 
} 

public class fcfs_job {

	int arvl,brst,status,startpt,name;

	public fcfs_job(int arrival ,int burst,char ch )
	{
	this.arvl=arrival;
	this.brst=burst;
	this.status=-2;
	this.startpt=-1;
	this.name=ch;}


    public static void main(String[] args) {

	Scanner reader = new Scanner(System.in);
        int size;//job numbers

	do{
	System.out.print("Enter number of jobs: ");
	size = reader.nextInt();
	if(size<0) { System.out.println("entered negative value!! again enter : "); }}while(size<0);

       	fcfs_job[] job =new fcfs_job[size];
	int a,b; 

	for(int i=0;i<size;i++)
	{
	System.out.println("JOB NO - "+(i+1));

	do{
        System.out.print("Enter a Arrival Time: ");
	 a = reader.nextInt();
		if(a<0) { System.out.println("entered negative value!! again enter : "); }}while(a<0);
	do{
	System.out.print("Enter a Burst Time: ");
	 b = reader.nextInt();
		if(b<1) { System.out.println("entered negative value!! again enter : "); }}while(b<1);
		System.out.println();
		
	job[i]=new fcfs_job(a,b,(char)('A'+i));

	 }
	System.out.println("unsorted\nJOB NO\tname\tarrivale time\tburst time\n");
	for(int i=0;i<size;i++)
	
	System.out.println((i+1)+"\t"+(char)(job[i].name)+"\t    "+job[i].arvl+"\t         "+job[i].brst+"\n");

	Arrays.sort(job, new SortByArrival()); 

	/*System.out.println("\n\nsorted\nJOB NO\tname\tarrivale time\tburst time\tstatus\n");
	for(int i=0;i<size;i++)
	
	System.out.println((i+1)+"\t"+(char)(job[i].name)+"\t    "+job[i].arvl+"\t         "+job[i].brst+"\t      "+job[i].status+"\n");*/


       
	
	
	
	int time=0,p=0,flag=1;
	System.out.print("Gantt Chart - |");

	while(flag!=0&&p<size)
	{

	flag=0;
	for(int i=0;i<size;i++)
	if(job[i].status==-2) {flag=1;break;}
	
	if(time>=job[p].arvl) 
	{job[p].startpt=time;
		for(int k=0;k<job[p].brst;k++) System.out.print((char)job[p].name+"|");
	time+=job[p].brst;job[p].status=-1;p++;
	}
	else {System.out.print("*|");time++;}
	
	
	}System.out.print("\n\n");

	System.out.println("Table\nJOB NO\tname\tarrivale time\tburst time\tstart time\twaiting time\tturnaround time\n");
	for(int i=0;i<size;i++)
	
System.out.println((i+1)+"\t"+(char)(job[i].name)+"\t    "+job[i].arvl+"\t         "+job[i].brst+"\t         "+job[i].startpt+"\t          "+(job[i].startpt-job[i].arvl)+"\t           "+(job[i].startpt+job[i].brst-job[i].arvl)+"\n");


System.out.print("\n\n");

float aw=0,at=0;
for(int i=0;i<size;i++){at+=+(job[i].startpt+job[i].brst-job[i].arvl);  aw+=(job[i].startpt-job[i].arvl);}
System.out.println("Average Waiting time:-  "+(aw/size)+"\nAverage Turnaround time:-  "+(at/size)+"\n");
	
}     
}  
