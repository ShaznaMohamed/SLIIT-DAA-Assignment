/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daaassignment;
import java.util.Scanner;
/**
 *
 * @author Shaznaa-IT14118432
 */
public class SeventhTry {
    
     public static void main(String[] args)
    {
       
        
        Scanner s =new Scanner(System.in);
        System.out.print("Give the Number of Memory Regions: ");
        int nmem = s.nextInt();
        
        System.out.print("Give the Number of Processes: ");
        int npro = s.nextInt();
        
        int[] pair = new int[npro];
        
        Scanner s1 =new Scanner(System.in);
        int[] Segment = new int[nmem];
        for( int v=0; v<Segment.length; v++)
        {   
            int u=v+1;
            System.out.print("Give the Memory size of Region "+u+" : ");
            Segment[v]= s1.nextInt();
          
        }
        for( int i=0; i<pair.length; i++)
        {
            int y=i+1;
            System.out.print("Give the Number of Pairs in process "+y+" : ");
            pair[i]=s.nextInt();
        }
      
        int a=0, b=0, c=0, d=0;
        int e=0, f=0, g=0, h=0;
        int i=0, j=0;
        int k=0, l=0;
        int m=0, n=0, o=0, p=0;
        
            
            System.out.println("Give line by line the program size & the execution time of each process: " );
            System.out.println("for process 1:");
            a=s1.nextInt();
            b=s1.nextInt();
            c=s1.nextInt();
            d=s1.nextInt();
            System.out.println("For Process 2:");
            e=s1.nextInt();
            f=s1.nextInt();
            g=s1.nextInt();
            h=s1.nextInt();
            System.out.println("For Process 3:");
            i=s1.nextInt();
            j=s1.nextInt();
            System.out.println("For Process 4:");
            k=s1.nextInt();
            l=s1.nextInt();
            System.out.println("For Process 5:");
            m=s1.nextInt();
            n=s1.nextInt();
            o=s1.nextInt();
            p=s1.nextInt();
            System.out.println("Memory Allocation for the input: " );
            int pro[][]={{a,b,c,d},
                          {e,f,g,h},
                          {i,j},
                          {k,l},
                          {m,n,o,p}};
            
           
        
//         int pro[][] ={{10,50,12,30},   //input
//                      {10,100,20,25},
//                      {25,19},
//                      {19,41},
//                      {10,18,30,42}};
        // int Segment[] = {10,20,30};
         int Region[][] = {{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}};
        
        // int pair[] = {2,2,1,1,2};
         int lim=pair[0];
         int noOfProcess = 5;
        
         int Bigraw = 0;
         int [][]copysorted= {{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}};
         int maxval[] ={0};
         int y=0;
         for(int x=0; x<noOfProcess ; x++)
         {   
             y=x+1;
             lim = pair[x];
             int file = FindMinTimeSpentFile(pro[x],lim);
             int time = FindMinExecutionTime(pro[x],lim);
             int reg =  FindBestMemoryPartition( file, Segment );
             InsetingChosenTimeIntoRegions(file,Segment, pro[x],lim, Region);    
             GettingtheOutput(noOfProcess, pro[x], lim, Segment,y,Region );
         }
         
         copysorted= SortingtheTimesInRegions(Region);
         ArrangingTimesInTheBestRegion(copysorted, Region);
         FindingtheTotalOfEachRegions(Region );    
         Bigraw = GettingTheMaximumTotalTakenRegion(Region);
         
         
//         for ( int t=0; t<Region.length; t++)
//         {
//             for( int v=0; v<Region[t].length ; v++)
//             {
//                System.out.print(Region[t][v] +"  ");
//             }
//             System.out.println(" ");
//         }
         CalculatingTurnaroundAverage(Region,noOfProcess);
         
         
         
         
    }



    static int FindMinTimeSpentFile(int[] pro, int limit) //Finding the Min execution time taken file in each process
    {
       int min = pro[1];
       int minsize = 0;
      
      
                for(int i=1; i<pro.length ; i=i+2)      
                {
                    if(limit == 1)    //for process which has only one pair 
                    {
                        minsize=pro[0];
                        
                    }
                    else  if ( i+2 >= pro.length )    //preventing from ArrayIndex Outof boundry Exception throw
                     {
                        //minsize=pro[0];
                     }
                     else if ( min <= pro[i+2]  )
                          {
                                 min = pro[i];
                                 minsize = pro[i-1];
                                 
                          }
                     else if( min > pro[i+2])
                          {
                                 min = pro[i+2];
                                 minsize = pro[i+2-1];
                          }
//                    else if(min == pro[i+2] && min == pro[i] )
//                         {
//                                 if( pro[i-1] >= pro[i+2-1] )
//                                 min =  pro[i-1];
//                                 else
//                                     min = pro[i+2-1];
//                         }
                      
                }
       
       return minsize;
     }   
  
  
  
    static int FindMinExecutionTime(int[] pro, int limit) //Finding the Min execution time taken  in each process
    {
       int min = pro[1];
       int minsize = 0;
      
      
                for(int i=1; i<pro.length ; i=i+2)      
                {
                    if(limit == 1)    //for process which has only one pair 
                    {
                        minsize=pro[0];
                        
                    }
                    else  if ( i+2 >= pro.length )    //preventing from ArrayIndex Outof boundry Exception throw
                     {
                        //minsize=pro[0];
                     }
                     else if ( min <= pro[i+2]  )
                          {
                                 min = pro[i];
                                 minsize = pro[i-1];
                                 
                          }
                     else if( min > pro[i+2])
                          {
                                 min = pro[i+2];
                                 minsize = pro[i+2-1];
                          }
//                    else if(min == pro[i+2] && min == pro[i] )
//                         {
//                                 if( pro[i-1] >= pro[i+2-1] )
//                                 min =  pro[i-1];
//                                 else
//                                     min = pro[i+2-1];
//                         }
                      
                }
       
       return min;
     }   
 
    static int FindBestMemoryPartition(int filesize, int[] Seg )//Finding the Best Memory Partition according to the size of the program & the Region allocated
        {
            //int Seg[] = {10,20,30};
            
            int region = 0;
            
            for( int c=0; c<=Seg.length; c++)
            {
                if ( filesize <= Seg[c])
                {
                    region = Seg[c];
                   
                    break;
                }
            }
            
         
            return region;
        }
    
    static int FindMemoryPartitionRegion(int filesize, int[] Seg ) //This finds the allocated region number where it is used as the raw index of region after allocating the programs 
        {
            //int Seg[] = {10,20,30};
            
            int r = 0;
            
            for( int c=0; c<=Seg.length; c++)
            {
                if ( filesize <= Seg[c])
                {
                   // region = Seg[c];
                    r=c;
                    break;
                }
            }
            
         
            return r;
        }
    
    static void InsetingChosenTimeIntoRegions(int file, int[]Seg, int[] pro, int limit, int [][]Region1) //Programs are allocated into regions according to their execution time
    {
       // int Region1[][] = {{0},{0}, {0}};
        
        int m=0, c=0;
       
        int out =0;
        int reg = FindBestMemoryPartition(file,Seg ); //Gives the Best Programe size chosen from each process
        int time =FindMinExecutionTime(pro,limit);    //Gives the Minimum the time spent for execution in each process 
       
        for( int v=0; v<Seg.length; v++)
        {
              
            if ( reg == Seg[v])
            {
              m=v;
              while( Region1[m][c] != 0)
              {
                  c=c+1;
              }
              if( Region1[m][c]==0)
              {
                    Region1[m][c]=time;
              }
              
            }
        }
        
        
       // int copychosenregion[][] = Arrays.copyOf(Region1, Region1.length);
                  
        }
        
        static int[][] SortingtheTimesInRegions(int[][] Region)   //Sorts the allocated times in each region for finding the running order & the average  
        {      
             int maxval[] ={0};
             int min =0;
          for( int n=0; n<Region.length; n++)
          {
           for( int step =0; step<=Region.length-1; step++ )
          {
              min = step;
              for(int i= step+1; i<=Region.length-1 ;i++)
              {
                  if( Region[n][i] < Region[n][min])
                  {
                      min=i;
                  }
              }
              int temp=Region[n][step];
              Region[n][step] = Region[n][min];
              Region[n][min] = temp;
          }
          }
          
          int copysortedregion[][] = Region.clone();  //Getting a copy of sorted array of the allocated times
         
          
         
          
//          
//           for ( int t=0; t<copysortedregion.length; t++)
//         {
//             for( int v=0; v<copysortedregion[t].length ; v++)
//             {
//                System.out.print(copysortedregion[t][v] +"  ");
//               
//             }
//             System.out.println(" ");
//         }
           
           
          return  copysortedregion;
        }
        
        
       static void FindingtheTotalOfEachRegions(int[][] Region ) //Gets the total time allocated in each region 
       {
           for( int p=0; p<Region.length; p++)
           {
               for(int y=0; y<Region[p].length; y++)
               {
                   if( y+1 >= Region[p].length)
                   {
                       
                   }
                   else
                       {
                         Region[p][y+1] = Region[p][y] + Region[p][y+1];
                       }
                  
               }
              
           }
       }
       
       
       static int GettingTheMaximumTotalTakenRegion(int[][] Region) // Comparing the total time spent in each region to find the maximum time needed region
       {
           
          int lastval =0;
          int max=0;
          int Bigraw =0;
          for(int r=0; r<Region.length; r++)
          {
             for ( int y=0; y<Region[r].length; y++)
             {
                   lastval= Region[r][y];
                   
             }
              if( lastval >= max)
              {
                  max=lastval;
                  Bigraw=r;
              }
              
             
          }
          return Bigraw;
          
         
       }
       
       
       static void ArrangingTimesInTheBestRegion(int [][] copysorted, int [][] Region)//Arranging the time slots of maximum used region to the smallest time taken region
       {
         
          int time =0 ; 
          int temp =0;
          int max=0;
          int count =0;
          int i =0;
          int s=0;
          int w=0;
                  
          for(int r=0; r<copysorted.length; r++)
          { 
              count=0;
             for ( int y=0; y<copysorted[r].length; y++)
             {

                 if(copysorted[r][y] !=0 )
                 {
                   
                    count =count+1;
                    temp=copysorted[r][y];
                    s=y;
                 
                 }
             }
            
              if( count >max)
              {
                  max=count;
                  i=r;
                  time=temp;
                  w=s;
              
              }
              
          }
 
           
         for(int r=0; r<Region.length; r++)         //Freeing the region which was having the largest time slot
          {              
             for ( int y=0; y<Region[r].length; y++)
             {
                 if ( r==i && y==w)
                 {
                     Region[r][y]=0;
                 }
             }
          }    
           
         
         int q=0;
           
          for(int r=i+1; r<Region.length; r++)      //Allocating the sheduling time slot into the most suitable region 
          { 
              
             for ( int y=0; y<Region[r].length; y++)
             {
                 
                 if (Region[r][y] != 0)
                 {
                     q=Region[r][y];
                 }
                 if( y+2 >= Region[r].length)
                 {
                     
                 }
                 else if(Region[r][y] != 0  )
                      {
                            Region[r][y]=q;
                            Region[r][y+1]=time;
                         
                      }
             }
             
          }
           // System.out.println(q);
         
       }
       
       
       static void CalculatingTurnaroundAverage(int [][]Region, int noOfProcess)//Turn aaround average for the whole case is calculated
       {
           int total =0;
           double tot = 0.0;
           double avg = 0;
          for(int r=0; r<Region.length; r++)
          { 
              
             for ( int y=0; y<Region[r].length; y++)
             {
                 if(y+1 >= Region[r].length)
                 {
                     
                 }
                 else{
                     
                     if( Region[r][y] != Region[r][y+1])
                     {
                     total = Region[r][y] + Region[r][y+1];
                     }
                   
                     }
             }
             tot = tot + total;
             
          }
          
          avg = tot / noOfProcess;
         
         System.out.println("Average Turn Around Time = "+ avg+ " ");
           
       }
       
       
       static void GettingtheOutput(int noOfProcess, int[] pro, int  lim, int[] Segment, int x, int [][]Region )//printing the output
       {
           
         int file = FindMinTimeSpentFile(pro,lim);
             int time = FindMinExecutionTime(pro,lim);
             int reg =  FindMemoryPartitionRegion(file,Segment );
             int d=0, w=25, b=41;
             int c= reg+1;       
             if( x == 4  )
                 c=3;
             int to=0 , e=0;
             int raw1=0, raw2=0, raw3=0 ;
             
             
             
             for(int r=0; r<Region.length; r++)
             { 
                 
                        for ( int y=0; y<Region[r].length; y++)
                        {
                            if(Region[r][y] != 0)
                            {
                                to =Region[r][y];
                              
                            }
                        }
                     
                if (r==0)
                {
                     raw1=to;
                }
                if( r==1)
                {
                     raw2 = to;
                }
                if(r==2)  
                {
                     raw3 = to;
                }
                                  
             }
              if( x==1)
              {
                    d=raw2+w;
                    e=w;
              }
              if( x==3)
              {
                    d=raw3;
              }
              if( x== 5)
              {
                    d=raw1;
              }
              if(x==4)
              {
                  d=raw3+b;
                  e=raw3;
              }
              if(x==2)
              {
                  d=w;
              }
              
             
              System.out.println("Program "+x+" runs in region "+c +" from "+e+" to "+d);
       }
       
          
  
}


