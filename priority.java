import java.util.*; 
import java.lang.*; 
import java.io.*; 

class SortByArrival implements Comparator<priority> 
{ 
    
    public int compare(priority a, priority b) 
    { 
        return a.arvl - b.arvl; 
    } 
} 

class SortBypriority implements Comparator<priority> 
{ 
    
    public int compare(priority a, priority b) 
    { 
        return a.pr - b.pr; 
    } 
} 

public class priority {

	int arvl,brst,status,startpt,name,pr;

	public priority(int arrival ,int burst,int priority,char ch )
	{
	this.arvl=arrival;
	this.brst=burst;
	this.status=-2;
	this.startpt=-1;
	this.name=ch;
	this.pr=priority;}


    public static void main(String[] args) {

	Scanner reader = new Scanner(System.in);
        int size;//job numbers

	do{
	System.out.print("Enter number of jobs: ");
	size = reader.nextInt();
	if(size<0) { System.out.println("entered negative value!! again enter : "); }}while(size<0);

       	priority[] job =new priority[size];
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
	System.out.print("Enter a Priority: ");
	 p = reader.nextInt();
		if(p<0) { System.out.println("entered negative value!! again enter : "); }}while(p<0);
		System.out.println();
		
	job[i]=new priority(a,b,p,(char)('A'+i));

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
	if(job[i].arvl<=time && job[i].status==-2) {flag=i;break;}
	
	
	
	if(flag>-1) 
	{job[flag].startpt=time;
		for(int k=0;k<job[flag].brst;k++) System.out.print((char)job[flag].name+"|");
	time+=job[flag].brst;job[flag].status=0;pt++;
	}
	else {System.out.print("*|");time++;}
	
	
	}System.out.print("\n\n");

	System.out.println("Table\nJOB NO\tname\tarrivale time\tburst time\tpriority\tstart time\twaiting time\tturnaround time\n");
	for(int i=0;i<size;i++)
	
System.out.println((i+1)+"\t"+(char)(job[i].name)+"\t    "+job[i].arvl+"\t         "+job[i].brst+"\t          "+job[i].pr+"\t         "+job[i].startpt+"\t          "+(job[i].startpt-job[i].arvl)+"\t           "+(job[i].startpt+job[i].brst-job[i].arvl)+"\n");


System.out.print("\n\n");
float aw=0,at=0;
for(int i=0;i<size;i++){at+=+(job[i].startpt+job[i].brst-job[i].arvl);  aw+=(job[i].startpt-job[i].arvl);}
System.out.println("Average Waiting time:-  "+(aw/size)+"\nAverage Turnaround time:-  "+(at/size)+"\n");

}
}
/*
unsorted
JOB NO	name	arrival time	burst time	priority

1	A	    2	         2	      2

2	B	    3	         1	      4

3	C	    2	         2	      3

4	D	    9	         4	      1

5	E	    11	         2	      0



sorted
JOB NO	name	arrival time	burst time	priority

1	E	    11	         2	      0

2	D	    9	         4	      1

3	A	    2	         2	      2

4	C	    2	         2	      3

5	B	    3	         1	      4

Grant Chart - **AACCB**DDDDEE

Table
JOB NO	name	arrivale time	burst time	start time	waiting time	turnaround time

1	E	    11	         2	         13	          2	           4

2	D	    9	         4	         9	          0	           4

3	A	    2	         2	         2	          0	           2

4	C	    2	         2	         4	          2	           4

5	B	    3	         1	         6	          3	           4



Average Waiting time:-1.4
Average Turnaround time:-3.6


*/
