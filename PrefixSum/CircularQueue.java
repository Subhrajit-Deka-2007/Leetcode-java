package PrefixSum;


import java.util.Scanner;

class CQ {
    int[] arr;
    int idx;
    int r_idx;
    int size = 0;

    CQ(int n)
    {
        arr = new int[n];
        idx = -1;
        r_idx = -1;
    }


    void add(int data)
    {
        if(size == arr.length )
        {
            System.out.println(" Queue is full ");
            return;
        }
        if (r_idx == arr.length - 1)
        {
            idx = 0;
            r_idx = -1;

            return;
        }
        else if (r_idx != -1) arr[r_idx] = data;
        else arr[++idx] = data;


        size++;

    }


    void remove()
    {
        if( size == 0 )
        {
            System.out.println(" Queue is empty can't remove elements ");
            return;
        }
        arr[++r_idx] = 0;
        size--;
    }


    void display()
    {
        if (idx == -1)
        {
            System.out.println(" Queue is empty ");
            return;
        }
        if (r_idx == -1)
        {
            for (int i = 0; i <= idx; i++)
                System.out.print(arr[i] + " ");
        }

        else
        {
            for (int i = r_idx + 1; i <= idx; i++)
                System.out.print(arr[i]+" ");
            for (int i = 0; i <= r_idx; i++)
                System.out.print(arr[i]+" ");
        }
    }
}
public class CircularQueue
{
    public static void main(String[] args)
    {
        System.out.println(" Enter the size of the Circular Queue ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        CQ obj = new CQ(n);
        obj.add(2);
        obj.add(3);
        obj.remove();
        obj.add(9);
        obj.display();

    }
}
