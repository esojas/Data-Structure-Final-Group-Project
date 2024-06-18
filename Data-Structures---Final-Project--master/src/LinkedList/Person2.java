package LinkedList;
// This class is to give key pair value to the Linkedlist
public class Person2 implements Comparable<Person2> {
    String name;
    int number;

    public Person2(String name, int number) {
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
    public int compareTo(Person2 other) {
        return Integer.compare(this.number, other.number);
    }

    @Override
    public String toString() {
        return name + "-" + number;
    }
}
