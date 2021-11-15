import java.util.Comparator;

public class DogLauncher {
    public static void main(String[] args) {
        Dog[] myDogs = {new Dog("Jim", 40), new Dog("Stacia", 20),
                new Dog("Cookie", 30), new Dog("Mick", 200)};
        Dog maxDog = (Dog) Maximizer.max(myDogs);
        maxDog.bark();

        Comparator<Dog> nc = Dog.getNameComparator();
        if (nc.compare(myDogs[0], myDogs[3]) > 0) {
            myDogs[0].bark();
        } else {
            myDogs[2].bark();
        }
    }
}
