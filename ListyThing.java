public class ListyThing
{
    public static void main(String args[]){
        Node head = new Node(5);
        head.setNext(new Node(13));
        
        Node curr = head;
        curr = curr.getNext();
        for (int i = 0; i < 10; i++){
            int n = (int)(Math.random() * 100) + 1;
            curr.setNext(new Node(n));
            curr = curr.getNext();
        }
        
        
        //print it out
        curr = head;
        while(curr != null){
            System.out.println(curr.getValue());
            curr = curr.getNext();
        }
    }
}
