import java.util.*;
class DoublyLinkedList 
{
    Node head;
    class Node 
    {
        int data;
        Node prev;
        Node next;
        public Node(int data) 
        {
            this.data = data;
            prev = null;
            next = null;
        }
    }
    public void dllcreation(int num) 
    {
        Node newNode = new Node(num);
        if (head == null) 
        {
            head = newNode;
        } 
        else 
        {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }
    public void insertAtBeginning(int num)
    {
        Node newNode=new Node(num);
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }
    public void insertAtEnd(int num)
    {
        Node newNode=new Node(num);
        Node temp=head;
        while(temp.next!=null)
        {
            temp=temp.next;
        }
        temp.next=newNode;
        newNode.prev=temp;
    }
    public void insertAtmiddle(int num)
    {
        Scanner s = new Scanner(System.in);
		System.out.println("Enter the position: ");
		int pos=s.nextInt();
		Node newNode=new Node(num);
		Node temp=head;
		if (pos == 0)
		{
			newNode.next = head;
			if (head != null)
			{
				head.prev = newNode;
			}
			head = newNode;
		}
		int i = 1;
		while (temp != null && i < pos)
		{
			temp = temp.next;
			i++;
		}
		if(temp!=null)
		{
		    newNode.next=temp.next;
			if (temp.next != null)
			{
				temp.next.prev = newNode;
			}
			temp.next = newNode;
			newNode.prev = temp;
		}
    }
    public void deleteAtStart()
    {
        Node temp = head;
        head=head.next;
        head.prev= null;
    }
    public void deleteAtEnd()
    {
        if(head==null)
        {
            return;
        }
        if(head.next==null)
        {
            head=null;
        }
        else
        {
            Node temp=head;
            while(temp.next!=null)
            {
                temp=temp.next;
            }
            temp.prev.next=null;
            temp=null;
        }
    }
    public void deleteAtmiddle()
    {
        Scanner s=new Scanner(System.in);
        System.out.println("Enter the position: ");
		int pos=s.nextInt();
		if(head==null)
		{
		    System.out.println("List is empty");
		}
		Node temp=head;
		int i=0;
		if(pos==0)
		{
		    deleteAtStart();
		    return;
		}
		while (temp != null && i < pos)
		{
			temp = temp.next;
			i++;
		}
		if(temp!=null)
		{
		    if(temp.next!=null)
		    {
		        temp.next.prev=temp.prev;
		    }
		    if(temp.prev!=null)
		    {
		        temp.prev.next=temp.next;
		    }
		    temp=null;
		}
    }
    public void display() 
    {
        Node temp = head;
        while (temp != null) 
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) 
    {
        Scanner s = new Scanner(System.in);
        DoublyLinkedList dll = new DoublyLinkedList();
        System.out.println("Enter the items to insert:");
        while (true) 
        {
            int num = s.nextInt();
            if (num == -1) 
            {
                break;
            }
            dll.dllcreation(num);
        }
        // System.out.println("Enter the value of new node:");
        // int n=s.nextInt();
        System.out.println("Enter your choice for deletion:");
        int choice=s.nextInt();
        if(choice==1)
        {
            dll.deleteAtStart();
        }
        else if(choice==2)
        {
            dll.deleteAtEnd();
        }
        else if(choice==3)
        {
            dll.deleteAtmiddle();
        }
        else
        {
            System.out.println("Wrong choice");
        }
        dll.display();
    }
}
