package PrefixSum;

import java.util.Scanner;

class Q
{

    int [] arr;
    int idx ;
    int size =0;
    int r_idx ;


    Q( int size )
    {
        arr = new int[size];
        idx = 0;
        r_idx = 0;
    }


    void insert( int data )
    {
        if( idx == arr.length )
        {
            System.out.println(" Queue is already full ");
            return;
        }
        arr[idx++]=data;
        size++;
    }

    int  remove()
    {
        if( r_idx == arr.length )
        {
            System.out.println(" Error ! Queue is already empty ");
            return -1;
        }
        size--;
        arr[r_idx] = 0;
        return arr[r_idx++];
    }

    void display()
    {
        for( int i = r_idx; i < idx ; i++ )
            System.out.print(arr[i]+" ");
    }
}
public class LinearQueue
{
    public static void main(String[] args)
    {
        System.out.println(" Enter the size of the queue ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Q obj = new Q(n);
        obj.insert(1);
        obj.insert(2);
        obj.insert(3);
        obj.remove();
        obj.insert(4);
        obj.insert(5);
        obj.display();
    }
}
