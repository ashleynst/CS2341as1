class Stack<Item> {
    private class Node
    {
        Item num;
        Node next;
    }

    private Node head;
    private int size;

    public Stack()
    {
        head = null;
    }

    public void push(Item data)
    {
        Node newNode = new Node();
        newNode.num = data;
        newNode.next = head;
        head = newNode;
    }

    public Item pop()
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
