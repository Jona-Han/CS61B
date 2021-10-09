public class DogLauncher {
    public static void main(String [] args) {
//        Dog d = new Dog(8);
//        Dog d2 = new Dog(15);
//        Dog bigger = Dog.maxDog(d, d2);
//        bigger.makeNoise();

//        Dog bigger = d.maxDog(d2);
//        bigger.makeNoise();
//
//        System.out.println(d.binomen);
//        System.out.println(d2.binomen);
//        System.out.println(Dog.binomen);

//        d.makeNoise();

        //Larger than four dogs function
        Dog [] dogs = new Dog[] {
                new Dog(10),
                new Dog(15),
                new Dog(20),
                new Dog(15),
                new Dog(10),
                new Dog(5),
                new Dog(10),
                new Dog(15),
                new Dog(22),
                new Dog(15),
                new Dog(20)
        };
        Dog[] bigDogs1 = Dog.largerThanFourNeighbors(dogs);

        for (int k = 0; k < bigDogs1.length; k++) {
            System.out.print(bigDogs1[k].weightInPounds + " ");
        }
        System.out.println();

    }
}