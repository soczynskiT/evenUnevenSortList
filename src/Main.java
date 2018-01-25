import java.util.*;

class ArrayDequeGenerator {
    private Random random = new Random();

    public ArrayDeque<String> filledByAQue(int elementsNo, int maxElementsLength) {
        ArrayDeque<String> newDeque = new ArrayDeque<>();
        while (newDeque.size() < elementsNo) {
            StringBuilder queElement = new StringBuilder("a");
            int repeatedANo = random.nextInt(maxElementsLength);
            for (int i = 0; i < repeatedANo; i++) {
                queElement.append("a");
            }
            newDeque.offer(queElement.toString());
        }
        return newDeque;
    }
}

class QueToArraySorter {
    public List<String> getEvenArrayFrom(ArrayDeque<String> aQue) {
        List<String> evenArray = new ArrayList<>();
        ArrayDeque<String> sortList = aQue.clone();
        while (sortList.size() > 0) {
            if (sortList.peek().length() % 2 == 0) {
                evenArray.add(sortList.poll());
            } else {
                sortList.poll();
            }
        }
        return evenArray;
    }

    public List<String> getUnevenArrayFrom(ArrayDeque<String> aQue) {
        List<String> unevenArray = new ArrayList<>();
        ArrayDeque<String> sortList1 = aQue.clone();
        while (sortList1.size() > 0) {
            if (sortList1.peek().length() % 2 != 0) {
                unevenArray.add(sortList1.poll());
            } else {
                sortList1.poll();
            }
        }
        return unevenArray;
    }
}

class Main {

    public static void main(String[] args) {
        final ArrayDequeGenerator generator = new ArrayDequeGenerator();
        final QueToArraySorter queToArraySorter = new QueToArraySorter();

        final ArrayDeque<String> randomQue = generator.filledByAQue(50, 50);
        System.out.print("ArrayDeque contains: " + randomQue.size() + "\n");

        System.out.println("\nArray with String, which have even no of \"a\" letters.");
        final List<String> evenArray = queToArraySorter.getEvenArrayFrom(randomQue);
        for (String even : evenArray) {
            System.out.println("(" + even.length() + ") " + even);
        }

        System.out.println("\n\nArray with String, which have uneven no of \"a\" letters.");
        final List<String> unevenArray = queToArraySorter.getUnevenArrayFrom(randomQue);
        for (String uneven : unevenArray) {
            System.out.println("(" + uneven.length() + ") " + uneven);
        }
    }
}