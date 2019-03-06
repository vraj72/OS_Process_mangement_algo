
import java.util.*; 
import java.lang.*; 
import java.io.*; 


class SortByArvlroundRobbin implements Comparator<roundRobbin> 
{ 
    
    public int compare(roundRobbin a, roundRobbin b) 
    { 
        return a.arvl - b.arvl; 
    } 
} 



public class roundRobbin {

	int arvl,brst,status,startpt,name,exc,end;

	public roundRobbin(int arrival ,int burst,char ch )
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
        int size,tsl;//job numbers

	do{
	System.out.print("Enter number of jobs: ");
	size = reader.nextInt();
	if(size<0) { System.out.println("entered negative value!! again enter : "); }}while(size<0);

       	roundRobbin[] job =new roundRobbin[size];
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
		
	job[i]=new roundRobbin(a,b,(char)('A'+i));

	 }

	do{
	System.out.print("Enter Time slice: ");
	tsl = reader.nextInt();
	if(tsl<0) { System.out.println("entered negative value!! again enter : "); }}while(tsl<0);

	System.out.println("unsorted\nJOB NO\tname\tarrival time\tburst time\n");
	for(int i=0;i<size;i++)
	System.out.println((i+1)+"\t"+(char)(job[i].name)+"\t    "+job[i].arvl+"\t         "+job[i].brst+"\n");

	Arrays.sort(job, new SortByArvlroundRobbin()); 

	System.out.println("\n\nsorted\nJOB NO\tname\tarrival time\tburst time\n");
	for(int i=0;i<size;i++)
	System.out.println((i+1)+"\t"+(char)(job[i].name)+"\t    "+job[i].arvl+"\t         "+job[i].brst+"\n");
	

	int time=0,pt=0,flag=-1,k=1,prev=-1,j;
	System.out.print("Grant Chart - |");

	while(pt<size)
	{
	
	flag=-1;j=prev+1;k=1;

	while(k<=size){
	
	if(j==size) j=0;
	if(job[j].arvl<=time && job[j].status!=0) {flag=j;break;}
	j++;k++;}
	
	if(flag>-1) 
	{
		if(job[flag].status==-2) 
			{job[flag].startpt=time;  job[flag].status=-1;}
	
		if(job[flag].exc<=tsl){

			for(int i=0;i<job[flag].exc;i++)
			System.out.print((char)job[flag].name+"|");

			time+=job[flag].exc;job[flag].exc=0;pt++;job[flag].status=0;job[flag].end=time;}

		if(job[flag].exc>tsl)
			{for(int i=0;i<tsl;i++)
			System.out.print((char)job[flag].name+"|");
			time+=tsl;job[flag].exc-=tsl;} 
		prev=flag;
	}
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
