1.                                IMPLEMENTS HEAP

public class PQ
{
    ArrayList<Integer> arr = new ArrayList<>();
    public PQ()
    {
        heap = new ArrayList<>();
    }

    boolean isEmpty()
    {
        return heap.size == 0;
    } 
    int Size()
    {
        return heap.size();
    }
    int getMin()
    {
        if(heap.isEmpty())
        {

        }
        return heap.get(0);
    }
    void insert(int ele)
    {
        heap.add(ele);
        int childIndex = heap.size() - 1 ;
        int parentIndex = (childeIndex - 1) / 2 ;
        
        while(childIndex >  0 )
        {
            if(heap.get(childIndex) < heap.get(parentIndex))
            {
                int tmp = heap.get(parentIndex);
                heap.set(parentIndex , heap.get(childIndex));
                heap.set(childIndex , tmp );
                childIndex = parentIndex ; 
                parentIndex = (childINdex -1) /2 ;

            }
            else 
            return;
        }
    } 
  
    int removeMin ()
    {
        int min = heap.get(0);
        heap.set(0,heap.get(heap.size() - 1));
        heap.remove(heap.size() -1 );
        int childIndex =0 ,parentIndex = 0;
        if(heap.get(0) > heap.get(1))
        {
            childIndex = 1;
            parentINdex = (chilIndex - 1 ) / 2; 
        }
        else if(heap.get(0) > heap.get(2))
        {
            childIndex = 2;
            parentINdex = (chilIndex - 1 ) / 2; 
        }
        while(parentIndex < heap.size())
        {
            if(heap.get(parentIndex) >  heap.get(childindex))
            {
                int tmp = heap.get(childIndex);
                heap.set(chilIndex , heap.get(parentIndx))
                heap.set(parentIndex , tmp);
                parentIndex = childIndex ; 
                childIndex = 
            }
            else
            return min;
        }

        return min;
    }
}