package edu.guilford;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;


public class ArrayvsLinked {
    public static void main(String[] args) {
        int size = 10000;
        ArrayList<Student> students = new ArrayList<Student>(size);
        // start a timer
        long startTime = System.nanoTime();

        for (int i = 0; i < size; i++) {
            Student s = new Student();
            s.setStudentName("Student " + (int) (Math.random() * size));
            s.setGuilfordCredits((int) (Math.random() * 120));
            s.setTransferCredits(Math.random() * size);
            s.setExamCredits(Math.random() * size);
            s.setStudyAway(Math.random() > 0.5);
            s.setInSeason(Math.random() > 0.5);
            // set the gpa to be from .5 to 4
            s.setGPA(Math.random() * 4 + 1 * 1.5);

            s.setWorkStudy(Math.random() > 0.5);
            s.setFinAid(Math.random() > 0.5);
            s.setAthlete(Math.random() > 0.5);
            s.setOnCampus(Math.random() > 0.5);
            s.setHonors(Math.random() > 0.5);
            // set decimals to 2 places
            s.setGPA(Math.round(s.getGPA() * 100.0) / 100.0);

            students.add(s);
        }
        // stop the timer
        long endTime = System.nanoTime();
        // print out the time it took to make the arraylist
        System.out.println("Time to make arraylist: " + (endTime - startTime) / 1000000 + " milliseconds");
        // print the student names

        // sort the arraylist

        // start a timer
        startTime = System.nanoTime();
        Collections.sort(students, new ArrayvsLinked().new CustomComparator());
        // stop the timer
        endTime = System.nanoTime();
        // print out the time it took to sort the arraylist
        System.out.println("Time to sort arraylist: " + (endTime - startTime) / 1000000 + " milliseconds");
        // print out the first names of the sorted objects
        // shuffle the list adn time it
        startTime = System.nanoTime();
        Collections.shuffle(students);
        endTime = System.nanoTime();
        System.out.println("Time to shuffle arraylist: " + (endTime - startTime) / 1000000 + " milliseconds");

        // Use a loop to get a random element from the list 1,000,000 times. Time it.
        startTime = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            students.get((int) (Math.random() * size));
        }
        endTime = System.nanoTime();
        System.out.println(
                "Time to get random element from arraylist: " + (endTime - startTime) / 1000000 + " milliseconds");

        // Use a loop to get each element from the loop sequentially.
        startTime = System.nanoTime();
        for (int i = 0; i < size; i++) {
            students.get(i);
        }
        endTime = System.nanoTime();
        System.out.println("Time to get each element sequentially from arraylist: " + (endTime - startTime) / 1000000
                + " milliseconds");

        // make a linked list
        LinkedList<Student> studentsLinked = new LinkedList<Student>();
        // start a timer
        startTime = System.nanoTime();
        for (int i = 0; i < size; i++) {
            Student s = new Student();
            s.setStudentName("Student " + (int) (Math.random() * size));
            s.setGuilfordCredits((int) (Math.random() * 120));
            s.setTransferCredits(Math.random() * size);
            s.setExamCredits(Math.random() * size);
            s.setStudyAway(Math.random() > 0.5);
            s.setInSeason(Math.random() > 0.5);
            // set the gpa to be from .5 to 4
            s.setGPA(Math.random() * 4 + 1 * 1.5);

            s.setWorkStudy(Math.random() > 0.5);
            s.setFinAid(Math.random() > 0.5);
            s.setAthlete(Math.random() > 0.5);
            s.setOnCampus(Math.random() > 0.5);
            s.setHonors(Math.random() > 0.5);
            // set decimals to 2 places
            s.setGPA(Math.round(s.getGPA() * 100.0) / 100.0);

            studentsLinked.add(s);
        }
        endTime = System.nanoTime();
        System.out.println("Time to make linkedlist: " + (endTime - startTime) / 1000000 + " milliseconds");

        startTime = System.nanoTime();
        Collections.sort(studentsLinked, new ArrayvsLinked().new CustomComparator());
        endTime = System.nanoTime();
        System.out.println("Time to sort linkedlist: " + (endTime - startTime) / 1000000 + " milliseconds");

        startTime = System.nanoTime();
        Collections.shuffle(studentsLinked);
        endTime = System.nanoTime();
        System.out.println("Time to shuffle linkedlist: " + (endTime - startTime) / 1000000 + " milliseconds");

        startTime = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            studentsLinked.get((int) (Math.random() * size));
        }
        endTime = System.nanoTime();
        System.out.println(
                "Time to get random element from linkedlist: " + (endTime - startTime) / 1000000 + " milliseconds");

        startTime = System.nanoTime();
        for (int i = 0; i < size; i++) {
            studentsLinked.get(i);
        }
        endTime = System.nanoTime();
        System.out.println("Time to get each element sequentially from linkedlist: " + (endTime - startTime) / 1000000
                + " milliseconds");

        // add the same students to the linked list

        // print out the first 10 students

    }

    // mkae a custom Comparator class that compares GuilfordCrdits
    class CustomComparator implements Comparator<Student> {
        @Override
        public int compare(Student s1, Student s2) {
            return Double.compare(s1.getGuilfordCredits(), s2.getGuilfordCredits());
        }
    }

}
