public class Queue<Item> {
    private class Node
    {
        Item num;
        Node next;
    }

    private Node head;
    private Node last;
    private int size;

    public Queue()
    {
        head = null;
    }

    public void enqueue(Item data)
    {
        Node newNode = new Node();
        newNode.num = data;
        newNode.next = head;
        head = newNode;
        if(last == null)
        {
            last = head;
        }
        size++;
    }

    public Item dequeue()
    {
        if(head == null)
        {
            return null;
        }
        Item data = head.num;
        head = head.next;
        return data;

    }

    public boolean isEmpty()
    {
        return head == null;
    }

    public int size()
    {
        return size;
    }
}
