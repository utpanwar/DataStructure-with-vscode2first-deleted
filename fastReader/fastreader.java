package graph;

/*
######  ######    #####  ######  ######  #####
#    #  #    #      #    #    #  #    #    #
#    #  # #  #      #    # ## #  # ## #    #
#    #  #  #    #   #    #    #  #    #    #
######  #   #   # # #    #    #  #    #    #
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.io.*;
import java.math.*;
import java.util.StringTokenizer;
class RangeSum{
static PrintStream p = System.out;

public static void main(String args[] ) throws Exception {
    int t = nextInt(); 
    long arr[] = new long[1000002];
    arr[0] = 0;
    StringBuilder str = new StringBuilder();
    while(t-->0){
        int num = nextInt();
        for(int i=1;i<=num;i++){
            arr[i] = nextLong();
            arr[i] +=arr[i-1];
        }
        int q = nextInt();
        while(q-->0){
            int q1 = nextInt();
            int q2 = nextInt();
            str.append((arr[q2]-arr[q1-1])+"\n");
        }
    }
    p.println((""+str).trim());
}



//-------------------------------------------------fast Method---------------------------------------------------------------\\
static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
static StringTokenizer st;
private static int[] inta(int n){
    int [] a = new int[n];
    for(int i = 0;i < n;i++)a[i] = nextInt();
        return a;
}
private static long[] longa(long n){
long[] a = new long[(int)n];
    for(int i = 0;i < n;i++)a[i] = nextLong();
        return a;
}
private static void pla(long[] a){
    for(int i = 0;i <a.length;i++)
        p.print(a[i]+" ");
}
private static void pia(int[] a){
    for(int i = 0;i <a.length;i++)
        p.print(a[i]+" ");
}
private static String next(){
    while (st == null || !st.hasMoreElements()){
        try{
            st = new StringTokenizer(br.readLine());
        }
        catch (IOException  e){
            e.printStackTrace();
        }
    }
    return st.nextToken();
}
private static int nextInt(){
    return Integer.parseInt(next());
}

private static long nextLong(){
    return Long.parseLong(next());
}

private static double nextDouble(){
    return Double.parseDouble(next());
}
private static String nextLine(){
    String str = "";
    try{
        str = br.readLine();
    }
    catch (IOException e){
        e.printStackTrace();
    }
    return str;
}
//-------------------------------------------------fast Method---------------------------------------------------------------\\
}