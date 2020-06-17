package Graph;

import java.util.*;

public class PrintAllPathUsingDfs {
	static ArrayList<Integer> arr[];
	
	public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
//      int V =s.nextInt();
//      int E =s.nextInt();
        arr = new ArrayList[4];
      //arrays cant be generic in java
      for(int i =0 ; i< 4;i++)
      {
    	  arr[i]=new ArrayList<Integer>();
      }
      arr[0].add(1); 
      arr[0].add(2); 
      arr[0].add(3); 
      arr[2].add(0); 
      arr[2].add(1); 
      arr[1].add(3); 
     int src = 2;
     int d =3;
     boolean visited[] = new boolean[4];
      ArrayList<Integer> ar=new ArrayList<Integer>();
     printAllPaths(src, d,ar,visited);
 }
	static void printpath(ArrayList<Integer> ar)
	{
		for(int i = 0; i<ar.size();i++)
		{
			System.out.print(ar.get(i)+" ");
		}
		System.out.println();
	}
	static  void printAllPaths(int s , int d,ArrayList<Integer> ar, boolean visited[])
	{
		boolean visi[]=new boolean[4];
       Iterator<Integer> it = arr[s].listIterator();
       ArrayList<Integer> ar1=new ArrayList<>();
       
       for(int i=0;i<ar.size();i++)
       {
    	   ar1.add(ar.get(i));
    		   visi[ar.get(i)]=true;
    	   
       }
//       ar1.add(0);
       ar1.add(s);
       visi[s]=true;

      if(ar1.size()>0 && d==ar1.get(ar1.size()-1))
      {
    	  printpath(ar1);
      }
      
        while(it.hasNext())
        {   int a = it.next();
        	if(!visited[a])
        	printAllPaths(a,d,ar1,visi);
        }
	}
}