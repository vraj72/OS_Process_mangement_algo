
import java.util.*; 
import java.lang.*; 
import java.io.*; 

class SortByBurstsjf implements Comparator<sjf> 
{ 
    
    public int compare(sjf a, sjf b) 
    { 
        return a.brst - b.brst; 
    } 
} 


public class sjf {

	int arvl,brst,status,startpt,name;

	public sjf(int arrival ,int burst,char ch )
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

       	sjf[] job =new sjf[size];
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

	
		System.out.println();
		
	job[i]=new sjf(a,b,(char)('A'+i));

	 }

	System.out.println("unsorted\nJOB NO\tname\tarrival time\tburst time\n");
	for(int i=0;i<size;i++)
	System.out.println((i+1)+"\t"+(char)(job[i].name)+"\t    "+job[i].arvl+"\t         "+job[i].brst+"\n");

	Arrays.sort(job, new SortByBurstsjf()); 

	System.out.println("\n\nsorted\nJOB NO\tname\tarrival time\tburst time\n");
	for(int i=0;i<size;i++)
	System.out.println((i+1)+"\t"+(char)(job[i].name)+"\t    "+job[i].arvl+"\t         "+job[i].brst+"\n");
	

	int time=0,pt=0,flag=-1,min;
	System.out.print("Grant Chart - |");

	while(pt<size)
	{

	flag=-1;
	for(int i=0;i<size;i++)
	if(job[i].arvl<=time && job[i].status!=0) {flag=i;break;}
	
	
	
	if(flag>-1) 
	{job[flag].startpt=time;
		for(int k=0;k<job[flag].brst;k++) System.out.print((char)job[flag].name+"|");
	time+=job[flag].brst;job[flag].status=0;pt++;
	}
	else {System.out.print("*|");time++;}
	

	
	
	}System.out.print("\n\n");

	System.out.println("Table\nJOB NO\tname\tarrivale time\tburst time\tstart time\twaiting time\tendtime\tturnaround time\n");
	for(int i=0;i<size;i++)
	
System.out.println((i+1)+"\t"+(char)(job[i].name)+"\t    "+job[i].arvl+"\t         "+job[i].brst+"\t         "+job[i].startpt+"\t          "+(job[i].startpt-job[i].arvl)+"\t        "+(job[i].startpt+job[i].brst)+"\t        "+(job[i].startpt+job[i].brst-job[i].arvl)+"\n");


System.out.print("\n\n");
float aw=0,at=0;
for(int i=0;i<size;i++){at+=+(job[i].startpt+job[i].brst-job[i].arvl);  aw+=(job[i].startpt-job[i].arvl);}
System.out.println("Average Waiting time:-  "+(aw/size)+"\nAverage Turnaround time:-  "+(at/size)+"\n");

}
}
/*


*/
