# week3:JAVA PRIORITY QUEUE

import java.util.ArrayList;

import java.util.List;

import java.util.Scanner;

/\*

&#x20;\* Create the Student and Priorities classes here.

&#x20;\*/

class Student {

&#x20;   private int id;

&#x20;   private String name;

&#x20;   private double cgpa;



&#x20;   public Student(int id, String name, double cgpa) {

&#x20;       this.id = id;

&#x20;       this.name = name;

&#x20;       this.cgpa = cgpa;

&#x20;   }



&#x20;   public int getID() {

&#x20;       return id;

&#x20;   }



&#x20;   public String getName() {

&#x20;       return name;

&#x20;   }



&#x20;   public double getCGPA() {

&#x20;       return cgpa;

&#x20;   }

}



class Priorities {



&#x20;   public List<Student> getStudents(List<String> events) {



&#x20;       java.util.PriorityQueue<Student> pq =

&#x20;           new java.util.PriorityQueue<>(

&#x20;               (s1, s2) -> {



&#x20;                   // Higher CGPA first

&#x20;                   int cgpaCompare =

&#x20;                       Double.compare(s2.getCGPA(), s1.getCGPA());



&#x20;                   if (cgpaCompare != 0) {

&#x20;                       return cgpaCompare;

&#x20;                   }



&#x20;                   // Same CGPA -> name ascending

&#x20;                   int nameCompare =

&#x20;                       s1.getName().compareTo(s2.getName());



&#x20;                   if (nameCompare != 0) {

&#x20;                       return nameCompare;

&#x20;                   }



&#x20;                   // Same CGPA and name -> ID ascending

&#x20;                   return Integer.compare(s1.getID(), s2.getID());

&#x20;               }

&#x20;           );



&#x20;       for (String event : events) {



&#x20;           String\[] parts = event.split(" ");



&#x20;           if (parts\[0].equals("ENTER")) {



&#x20;               String name = parts\[1];

&#x20;               double cgpa = Double.parseDouble(parts\[2]);

&#x20;               int id = Integer.parseInt(parts\[3]);



&#x20;               pq.add(new Student(id, name, cgpa));



&#x20;           } else if (parts\[0].equals("SERVED")) {



&#x20;               if (!pq.isEmpty()) {

&#x20;                   pq.poll();

&#x20;               }

&#x20;           }

&#x20;       }



&#x20;       List<Student> students = new ArrayList<>();



&#x20;       while (!pq.isEmpty()) {

&#x20;           students.add(pq.poll());

&#x20;       }



&#x20;       return students;

&#x20;   }

}



public class Solution {

&#x20;   private final static Scanner scan = new Scanner(System.in);

&#x20;   private final static Priorities priorities = new Priorities();

&#x20;   

&#x20;   public static void main(String\[] args) {

&#x20;       int totalEvents = Integer.parseInt(scan.nextLine());    

&#x20;       List<String> events = new ArrayList<>();

&#x20;       

&#x20;       while (totalEvents-- != 0) {

&#x20;           String event = scan.nextLine();

&#x20;           events.add(event);

&#x20;       }

&#x20;       

&#x20;       List<Student> students = priorities.getStudents(events);

&#x20;       

&#x20;       if (students.isEmpty()) {

&#x20;           System.out.println("EMPTY");

&#x20;       } else {

&#x20;           for (Student st: students) {

&#x20;               System.out.println(st.getName());

&#x20;           }

&#x20;       }

&#x20;   }

}



## OUTPUT:



Input (stdin)

12

ENTER John 3.75 50

ENTER Mark 3.8 24

ENTER Shafaet 3.7 35

SERVED

SERVED

ENTER Samiha 3.85 36

SERVED

ENTER Ashley 3.9 42

ENTER Maria 3.6 46

ENTER Anik 3.95 49

ENTER Dan 3.95 50

SERVED

Your Output (stdout)

Dan

Ashley

Shafaet

Maria

Expected Output

Dan

Ashley

Shafaet



