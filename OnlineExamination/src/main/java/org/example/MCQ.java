package org.example;

import java.util.Scanner;

public class MCQ {
        public static void MCQs(String username) {
            Scanner scanner = new Scanner(System.in);
            int limitTime = 120;
            long startTime = System.currentTimeMillis();


            while (System.currentTimeMillis() - startTime < limitTime * 1000) {
                System.out.println("MCQs:");

                System.out.println("Which of the following is not an OOP concept in Java?\n " +
                        "1. Legacy\n" +
                        "\n" +
                        "2. Encapsulation\n" +
                        "\n" +
                        "3. Polymorphism\n" +
                        "\n" +
                        "4. Compilation");

                int choiceQ1 = scanner.nextInt();
                System.out.println("Time left: " + ((limitTime * 1000 - (System.currentTimeMillis() - startTime)) / 1000) + " seconds");

                System.out.println("When is method overloading determined?\n" +
                        " 1. At runtime\n" +
                        "\n" +
                        "2. At compile time\n" +
                        "\n" +
                        "3. At the time of coding\n" +
                        "\n" +
                        "4. At runtime");
                int choiceQ2 = scanner.nextInt();
                System.out.println("What concept of Java is used in combining methods and attributes in a class?\n" +
                        "1. Polymorphism\n" +
                        "\n" +
                        "2. Encapsulation\n" +
                        "\n" +
                        "3. Abstraction\n" +
                        "\n" +
                        "4. Heritage");
                int choiceQ3 = scanner.nextInt();
                System.out.println("Do you want to submit? (yes/no)");
                String Choice = scanner.next();

                if (Choice.equalsIgnoreCase("yes")) {
                    Question.saveAnswers(username,choiceQ1,choiceQ2,choiceQ3);
                    System.out.println("Answers submitted successfully.");
                    break;
                }
                Question.saveAnswers(username,choiceQ1,choiceQ2,choiceQ3);
                System.out.println("Answers submitted successfully.");
                }System.out.println("Time's up!");
            }


        }

