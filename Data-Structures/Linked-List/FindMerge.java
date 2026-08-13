import java.util.*;

public class FindMerge 
{
    public static void main(String args[])
    {
        Node x = new Node(100);
        Node y = new Node(200);
        Node z = new Node(300);

        Node head1 = new Node(10);
        head1.insertNode(y);
        head1.insertNode(new Node(20));
        head1.insertNode(new Node(30));

        Node head2 = new Node();
        head2.insertNode(x);
        head2.insertNode(y);
        head2.insertNode(z);

        head1.findMerge(head2);
    }
}


class Node
{
    int number;
    Node next;

    Node()
    {
        this.number = -1;
        this.next = null;
    }

    Node(int num)
    {
        this.number = num;
        this.next = null;
    }

    int insertNode(Node newNode)
    {
        if(this.next == null)
        {
            this.next = newNode;
            return 1;
        }

        Node temp = this;

        while(temp.next != null)
        {
            temp = temp.next;
        }

        temp.next = newNode;
        return 1;
    }

    void findMerge(Node head2)
    {
        Node temp1 = this;
        Node temp2 = head2;

        int len1 = 0;
        int len2 = 0;

        while(temp1 != null)
        {
            len1++;
            temp1 = temp1.next;
        }

        while(temp2 != null)
        {
            len2++;
            temp2 = temp2.next;
        }

        temp1 = this;
        temp2 = head2;

        if(len1 > len2)
        {
            int difference = len1 - len2;

            for(int i = 0; i < difference; i++)
            {
                temp1 = temp1.next;
            }
        }
        else
        {
            int difference = len2 - len1;

            for(int i = 0; i < difference; i++)
            {
                temp2 = temp2.next;
            }
        }

        while(temp1 != temp2)
        {
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        System.out.println("Merge Node = " + temp1.number);
    }
}