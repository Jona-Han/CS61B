public class RotatingSLList<Item> extends SLList<Item> {

    public void rotateRight() {
        Item temp = removeLast();
        addFirst(temp);
    }

    public static void main(String[] args) {
        RotatingSLList<Integer> rs1 = new RotatingSLList<Integer>();
        //Creates SLList
        rs1.addLast(10);
        rs1.addLast(11);
        rs1.addLast(12);
        rs1.addLast(13);

        //Rotate
        rs1.rotateRight();
        rs1.print();
    }
}
