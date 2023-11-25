import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       // welcome message 
        System.out.println("Welcome to Techie Emma's Quiz Game\n");
      
        // Scanner for user input
        Scanner scanner = new Scanner(System.in);

      // Quiz questions, options, and correct answers
      String[] questions = {
        "What does JVM stand for?",
        "Which keyword is used to define a constant in Java?",
        "What is the default value of the data type 'int' in Java?",
        "How do you declare an array in Java?",
        "What is the purpose of the 'finally' block in a try-catch-finally statement?"
      };
      String[][] options = {
        {"A. Java Virtual Machine", "B. Java Variable Machine", "C. Java Visual Machine", "D. Java Velocity Machine"},
        {"A. const", "B. final", "C. static", "D. constant"},
        {"A. 0", "B. 1", "C. 0.0", "D. null"},
        {"A. int[] arr = new int[5];", "B. array int[5];", "C. int arr[] = new int[];", "D. int arr[5];"},
        {"A. It always runs regardless of whether an exception is caught or not.",
                "B. It runs only when an exception is caught.",
                "C. It runs only when an exception is not caught.",
                "D. It is used to define a method that handles exceptions."}
      };
      char[] correctAnswers = {'A', 'B', 'A', 'A', 'A'};

        // Variables to track user's score
        int totalQuestions = questions.length;
        int correctResponses = 0;

        // User responses array
        char[] userResponses = new char[totalQuestions];

        // Quiz loop
        for (int i = 0; i < totalQuestions; i++) {
            System.out.println("Question " + (i + 1) + ": " + questions[i]);
            for (String option : options[i]) {
                System.out.println(option);
            }

            // Prompt user for an answer
            System.out.print("Your answer: ");
            userResponses[i] = Character.toUpperCase(scanner.next().charAt(0));
          // Compare user's answer to the correct answer
          if (userResponses[i] == correctAnswers[i]) {
              correctResponses++;
          }
        }
      // Calculate and Display the final score
      double scorePercentage = (correctResponses / (double) totalQuestions) * 100;
      System.out.println("Quiz completed! Your final score: " + scorePercentage + "%");

      // Display correct answers
      System.out.println("\nCorrect Answers:");
      for (int i = 0; i < totalQuestions; i++) {
          System.out.println("Question " + (i + 1) + ": " + correctAnswers[i]);
      }
      
        // Close the scanner
        scanner.close();
    }
}
