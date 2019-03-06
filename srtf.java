
import java.util.*; 
import java.lang.*; 
import java.io.*; 


class SortByRemsrtf implements Comparator<srtf> 
{ 
    
    public int compare(srtf a, srtf b) 
    { 
        return a.exc - b.exc; 
    } 
} 



public class srtf {

	int arvl,brst,status,startpt,name,exc,end;

	public srtf(int arrival ,int burst,char ch )
	{
	this.arvl=arrival;
	this.brst=burst;
	this.status=-2;
	this.startpt=-1;
	this.name=ch;
	this.exc=burst;
	this.end=0;}


    public static void main(String[] args) {

	Scanner reader = new Scanner(System.in);
        int size;//job numbers

	do{
	System.out.print("Enter number of jobs: ");
	size = reader.nextInt();
	if(size<0) { System.out.println("entered negative value!! again enter : "); }}while(size<0);

       	srtf[] job =new srtf[size];
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
		
	job[i]=new srtf(a,b,(char)('A'+i));

	 }

	System.out.println("unsorted\nJOB NO\tname\tarrival time\tburst time\n");
	for(int i=0;i<size;i++)
	System.out.println((i+1)+"\t"+(char)(job[i].name)+"\t    "+job[i].arvl+"\t         "+job[i].brst+"\n");

	Arrays.sort(job, new SortByRemsrtf()); 

	System.out.println("\n\nsorted\nJOB NO\tname\tarrival time\tburst time\n");
	for(int i=0;i<size;i++)
	System.out.println((i+1)+"\t"+(char)(job[i].name)+"\t    "+job[i].arvl+"\t         "+job[i].brst+"\n");
	

	int time=0,pt=0,flag=-1,min;
	System.out.print("Grant Chart - |");

	while(pt<size)
	{
	Arrays.sort(job, new SortByRemsrtf()); 
	
	flag=-1;
	for(int i=0;i<size;i++)
	if(job[i].arvl<=time && job[i].status!=0) {flag=i;break;}
	
	if(flag>-1) 
	{if(job[flag].status==-2) {job[flag].startpt=time;  job[flag].status=-1;}

	System.out.print((char)job[flag].name+"|");
	time++;job[flag].exc-=1;

	if(job[flag].exc==0){pt++;job[flag].status=0;job[flag].end=time;}}
	else {System.out.print("*|");time++;}
	

	
	
	}System.out.print("\n\n");

	System.out.println("Table\nJOB NO\tname\tarrivale time\tburst time\tstart time\twaiting time\tendtime\tturnaround time\n");
	for(int i=0;i<size;i++)
	
System.out.println((i+1)+"\t"+(char)(job[i].name)+"\t    "+job[i].arvl+"\t         "+job[i].brst+"\t         "+job[i].startpt+"\t          "+(job[i].end-job[i].arvl-job[i].brst)+"\t        "+(job[i].end)+"\t        "+(job[i].end-job[i].arvl)+"\n");


System.out.print("\n\n");
float aw=0,at=0;
for(int i=0;i<size;i++){at+=+(job[i].end-job[i].arvl);  aw+=(job[i].end-job[i].arvl-job[i].brst);}
System.out.println("Average Waiting time:-  "+(aw/size)+"\nAverage Turnaround time:-  "+(at/size)+"\n");

}
}
/*


*/
