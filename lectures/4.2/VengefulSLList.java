public class VengefulSLList<Item> extends SLList<Item>{
    SLList<Item> deletedItems; //= new SLList<>();          Alternative to the constructor

    public VengefulSLList() {
        super(); //Super constructor is called first, if this line is removed, super() is called by the compiler
        deletedItems = new SLList<>();
    }

    public VengefulSLList(Item x) {
        super(x);  //Not the same as just leaving the super call blank, since the implicit call is super();
        deletedItems = new SLList<>();
    }

    @Override
    public Item removeLast() {
        Item temp = super.removeLast();
        deletedItems.addLast(temp);
        return temp;
    }

    public void printLostItems() {
        deletedItems.print();
    }

    public static void main(String[] args) {
        VengefulSLList<Integer> rs2 = new VengefulSLList<>();
        //Add items to the SLList
        rs2.addLast(10);
        rs2.addLast(11);
        rs2.addLast(12);
        rs2.addLast(13);

        //Remove 2 items
        rs2.removeLast();
        rs2.removeLast();

        //Print removed items
        rs2.printLostItems();

    }
}
