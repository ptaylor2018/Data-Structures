import java.io.*;
import java.util.*;

/**
 * Write a description of class MinHeap here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MinHeap
{
    ArrayList<int[]> heap = new ArrayList<int[]>(0);
    public void insert(int toInsert, int nodeNumber){
        int[] toInsertArray = {toInsert, nodeNumber};
        
        heap.add(toInsertArray);
        int insertedIndex = heap.size() - 1;
        int parentIndex = 0;
        if(insertedIndex != 0){
            parentIndex = (insertedIndex-1)/2;
        } else{
            parentIndex = insertedIndex;
        }
        while(toInsert < (heap.get(parentIndex))[0]){
            heap.set(insertedIndex, heap.get(parentIndex));
            heap.set(parentIndex, toInsertArray);
            insertedIndex = parentIndex;
            if(insertedIndex != 0){
                parentIndex = (insertedIndex-1)/2;
            } else{
                parentIndex = insertedIndex;
            }
        }
        
    }

    public int delete(){
        int toReturn = (heap.get(0))[0];
        int[] sifting = (heap.get(heap.size()-1));
        heap.set(0, sifting);
        int siftingIndex = 0;
        
        if(heap.size() ==1){
            return (heap.get(0))[0];
        }
        heap.remove(heap.size()-1);
        int childIndexLeft = 0;
        int childIndexRight = 0;
        if((siftingIndex * 2 + 1) <= heap.size() - 1){
            childIndexLeft = siftingIndex * 2 + 1;

        }else{
            childIndexLeft = siftingIndex;
        }
        if((siftingIndex * 2 + 2) <= heap.size() - 1){
            childIndexRight = siftingIndex * 2 + 2;
        }else{
            childIndexRight = siftingIndex;
        }
        int toSwapIndex = 0;
        if(heap.get(childIndexLeft)[0] > heap.get(childIndexRight)[0]){
            toSwapIndex = childIndexRight;
        } else {
            toSwapIndex = childIndexLeft;
        }

        while(sifting[0] > (heap.get(toSwapIndex))[0]){
            //System.out.println(heap);
            heap.set(siftingIndex, heap.get(toSwapIndex));
            heap.set(toSwapIndex, sifting);
            siftingIndex = toSwapIndex;
            if((siftingIndex * 2 + 1) <= heap.size() - 1){
                childIndexLeft = siftingIndex * 2 + 1;
            }else{
                childIndexLeft = siftingIndex;
            }
            if((siftingIndex * 2 + 2) <= heap.size() - 1){
                childIndexRight = siftingIndex * 2 + 2;
            }else{
                childIndexRight = siftingIndex;
            }
            if(heap.get(childIndexLeft)[0] > heap.get(childIndexRight)[0]){
                toSwapIndex = childIndexRight;
            } else {
                toSwapIndex = childIndexLeft;
            }
        }
        //System.out.println(heap);
        return toReturn;
    }

    public int peek(){
        return heap.get(0)[0];
    }
    public int peekNode(){
        return heap.get(0)[1];
    }
}
