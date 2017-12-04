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
    ArrayList<Integer> heap = new ArrayList<Integer>(0);
    public void insert(int toInsert){
        heap.add(toInsert);
        int insertedIndex = heap.size() - 1;
        int parentIndex = 0;
        if(insertedIndex != 0){
            parentIndex = (insertedIndex-1)/2;
        } else{
            parentIndex = insertedIndex;
        }
        while(toInsert < heap.get(parentIndex)){
            heap.set(insertedIndex, heap.get(parentIndex));
            heap.set(parentIndex, toInsert);
            insertedIndex = parentIndex;
            if(insertedIndex != 0){
                parentIndex = (insertedIndex-1)/2;
            } else{
                parentIndex = insertedIndex;
            }
        }
        System.out.println(heap);
    }

    public int delete(){
        int toReturn = heap.get(0);
        int sifting = heap.get(heap.size()-1);
        heap.set(0, sifting);
        int siftingIndex = 0;
        heap.remove(heap.size()-1);
        if(heap.size() ==1){
            return heap.get(0);
        }
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
        if(heap.get(childIndexLeft) > heap.get(childIndexRight)){
            toSwapIndex = childIndexRight;
        } else {
            toSwapIndex = childIndexLeft;
        }

        while(sifting > heap.get(toSwapIndex)){
            System.out.println(heap);
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
            if(heap.get(childIndexLeft) > heap.get(childIndexRight)){
                toSwapIndex = childIndexRight;
            } else {
                toSwapIndex = childIndexLeft;
            }
        }
        System.out.println(heap);
        return toReturn;
    }

    public int peek(){
        return heap.get(0);
    }
}
