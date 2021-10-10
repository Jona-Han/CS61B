/* Tests the Sort class. */
public class TestSort {
    //Test the Sort.sort method
    public static void testSort() {
        String[] input = {"I", "have", "an", "egg");
        String[] expected = {"an", "egg", "have", "i"};

        Sort.sort(input);

        if (input != expected) {
            System.out.println("Error! There seems to be a problem with Sort.sort");
        }
    }

    public static void main(String[] args) {
            testSort();
        }
}