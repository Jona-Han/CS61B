public class Dog {
    public int weightInPounds;
    public static String binomen = "Canis familiaris";

    //Constructor for Dog
    public Dog(int startingWeight) {
        weightInPounds = startingWeight;
    }

    public void makeNoise() {
        if (weightInPounds < 10) {
            System.out.println("yip!");
        } else if (weightInPounds < 30) {
            System.out.println("bark.");
        } else {
            System.out.println("woooof!");
        }
    }

    //Static or class method to compare 2 dogs. When we call it we use Dog.maxDog
    public static Dog maxDog(Dog d1, Dog d2) {
        if (d1.weightInPounds > d2.weightInPounds) {
            return d1;
        }
        return d2;
    }

    //Instance or nonstatic method to compare an instance of a dog with another dog
    public Dog maxDog(Dog d2) {
        if (weightInPounds > d2.weightInPounds) {
            return this;
        }
        return d2;
    }

    public static Dog[] largerThanFourNeighbors(Dog[] dogs) {
        Dog[] returnDogs = new Dog[dogs.length];
        int cnt = 0;

        for (int i = 0; i < dogs.length; i++) {
            if (isBiggestOfFour(dogs, i)) {
               returnDogs[cnt] = dogs[i];
               cnt++;
            }
        }
        return arrayWithNoNulls(returnDogs, cnt);
    }

    //Returns an array without null
    public static Dog[] arrayWithNoNulls(Dog[] dogs, int cnt) {
        Dog[] noNullDogs = new Dog[cnt];
        for (int i = 0; i < cnt; i++) {
            noNullDogs[i] = dogs[i];
        }
        return noNullDogs;
    }

    //Returns true if dogs[i] is larger than its four neighbors
    public static boolean isBiggestOfFour(Dog[] dogs, int i) {
        for (int j = -2; j <= 2; j++) {
            int compareIndex = i + j;
            if (j != 0 && validIndex(dogs, compareIndex)) {
                if (dogs[compareIndex].weightInPounds >= dogs[i].weightInPounds) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean validIndex(Dog[] dogs, int i) {
        return (i >= 0) && (i < dogs.length);
    }
}