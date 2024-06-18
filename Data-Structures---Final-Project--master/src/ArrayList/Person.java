package ArrayList;
// This class is to give key pair value to the Arraylist
public class Person implements Comparable<Person> {
    String name;
    int number;

    public Person(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Person other) {
        return Integer.compare(this.number, other.number);
    }

    @Override
    public String toString() {
        return name + "-" + number;
    }
}
