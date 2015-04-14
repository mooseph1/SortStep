import java.util.*;

public class Sorts
{
  public void bubbleSort(int[] list)
  {
    for(int a = 0; a < list.length - 1; a++)
      for(int b = 0; b < list.length - a - 1; b++)
        if (list[b] > list[b + 1])
        {
          int temp = list[b];
          list[b] = list[b + 1];
          list[b + 1] = temp;
        }
  }

  public void selectionSort(int[] list)
  {
    int flag, temp;
    for (int a = 0; a < list.length - 1; a++)
    {
      flag = a;  
      for (int b = a + 1; b < list.length; b++)
        if (list[b] < list[flag])
          flag = b;
      temp = list[a];
      list[a] = list[flag];
      list[flag] = temp;
    }
  }

  public void insertionSort(int[] list)
  {
    for (int a = 1; a < list.length; a++)
    {
      int position = a;
      int key = list[position];
      while (position > 0 && list[position - 1] > key)
      {
        list[position] = list[position - 1];
        position--;
      }
      list[position] = key;
    }
  }

  private void merge(int[] a, int first, int mid, int last)
  { int something = a.length;
    int [] special = new int[something];
    int onepos = first; 
    int twopos = mid + 1;
    
    for(int i = first; i <= last; i++){
      if(onepos > mid){
        special[i] = a[twopos];
        twopos++;
      }
      else if(twopos > last){
        special[i] = a[onepos];
        onepos++;
      }
      else if(a[onepos] < a[twopos]){
        special[i] = a[onepos];
        onepos++;
      }
      else if(a[onepos] > a[twopos]){
        special[i] = a[twopos]; 
        twopos++; 
      }
      
    }
    for(int j = first; j <=last; j++){
        a[j] = special[j];
    }
    
  }

  public void mergeSort(int[] a, int first, int last)
  {   
     int mid = (first + last)/2;
     if(first < last){
      mergeSort(a, first, mid);
      mergeSort(a, mid + 1, last);
     }
    merge(a, first, mid, last);
  }
}
