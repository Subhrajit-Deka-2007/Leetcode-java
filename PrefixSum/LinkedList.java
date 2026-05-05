package PrefixSum;
class Node
{
    int data;
    Node next;
    Node(int data){
        this.data = data;
    }
}
class LL
{
    // The linked we are considering is 0th based indexing
    Node head ;
    Node tail ;
    int size ;


    void insertAtMiddle(int data,int idx )
    {
        if( idx<0 || idx == size )
        {
            System.out.println(" Invalid Index ");
            return;
        }
        else if (idx == 0 )insertAtHead(data);
        else if( idx == size-1 )insertAtTail(data);
        else
        {
            int x = idx;
            Node a = new Node(data);
            Node p = head;
            if(idx-1!=0)
            while( p.next != null && x-- >idx-1 )p = p.next;


            a.next = p.next;
            p.next = a;

        }
        size ++;

    }

    void insertAtHead( int data )
    {
        Node a = new Node(data);
        if( head == null && tail == null )
        {
            head = a;
            tail = a;
        }
        else
        {
            a.next = head;
            head = a;
        }
        size++;
    }

    void insertAtTail( int data )
    {
        Node a = new Node(data);
        if( head == null && tail == null )
        {
            head = a;
            tail = a;
        }
        else
        {
            tail.next =a;
            tail = a;

        }
        size++;
    }


    void display()
    {
        if(head == null && tail == null )
        {
            System.out.println(" Linked List is empty ");
            return;
        }
        Node temp = head;
        while(temp!=null)
        {
            System.out.print(temp.data+ " ");
            temp = temp.next;
        }
    }

    int  size()
    {
        return size;
    }

}

public class LinkedList {
    public static void main(String[] args) {
        LL obj = new LL();
        obj.insertAtHead(2);
        obj.insertAtTail(3);
        obj.insertAtMiddle(3,0);
        int size = obj.size();
        obj.insertAtMiddle(4,size-1);
        obj.display();
    }
}
