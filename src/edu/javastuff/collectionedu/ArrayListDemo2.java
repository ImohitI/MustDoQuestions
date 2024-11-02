package edu.javastuff.collectionedu;

import java.util.*;

public class ArrayListDemo2 {
    public static void main(String[] args) {
        List<Foo> foolist = new ArrayList<>();
        foolist.add(new Foo(2, "A"));
        foolist.add(new Foo(1, "B"));

        Collections.sort(foolist);
        System.out.println(foolist);

        Collections.sort(foolist, new NameComparator());
        System.out.println(foolist);

    }
}

class Foo implements Comparable<Foo> {
    int rank;
    String name;
    public Foo(int rank, String name) {
        this.rank = rank;
        this.name = name;
    }
    @Override
    public int compareTo(Foo o) {

        // if(this.rank > o.rank) {
        //     return 1;
        // } else if (this.rank < o.rank) {
        //     return -1;
        // } else {
        //     return 0;
        // }

        return this.rank - o.rank;
    }
    @Override
    public String toString() {
        return "Foo [rank=" + rank + "]";
    }
}
class NameComparator implements Comparator<Foo> {

	@Override
	public int compare(Foo o1, Foo o2) {
		return o1.name.compareTo(o2.name);
	}
}