//listing 1
// Demonstrate exception handling. 
class ExcDemo1 { 
  public static void main(String args[]) { 
    int nums[] = new int[4]; 
 
    try { 
      System.out.println("Before exception is generated."); 
 
      // Generate an index out-of-bounds exception. 
      nums[7] = 10; 
      System.out.println("this won't be displayed"); 
    } 
    catch (ArrayIndexOutOfBoundsException exc) { 
      // catch the exception 
      System.out.println("Index out-of-bounds!"); 
    } 
    System.out.println("After catch statement."); 
  } 
}

//listing 2
/* An exception can be generated by one 
   method and caught by another. */ 
 
class ExcTest { 
  // Generate an exception. 
  static void genException() { 
    int nums[] = new int[4];  
 
    System.out.println("Before exception is generated."); 
  
    // generate an index out-of-bounds exception  
    nums[7] = 10;  
    System.out.println("this won't be displayed");  
  } 
}     
 
class ExcDemo2 {  
  public static void main(String args[]) {  
  
    try {  
      ExcTest.genException(); 
    }  
    catch (ArrayIndexOutOfBoundsException exc) {  
      // catch the exception  
      System.out.println("Index out-of-bounds!");  
    }  
    System.out.println("After catch statement.");  
  }  
}

//listing 3
// Let JVM handle the error. 
class NotHandled { 
  public static void main(String args[]) { 
    int nums[] = new int[4]; 
 
    System.out.println("Before exception is generated."); 
 
    // generate an index out-of-bounds exception 
    nums[7] = 10; 
  } 
}

//listing 4
// This won't work! 
class ExcTypeMismatch {  
  public static void main(String args[]) {  
    int nums[] = new int[4];  
  
    try {  
      System.out.println("Before exception is generated."); 
  
      // generate an index out-of-bounds exception  
      nums[7] = 10;  
      System.out.println("this won't be displayed");  
    }  
 
    /* Can't catch an array boundary error with an  
       ArithmeticException. */ 
    catch (ArithmeticException exc) {  
      // catch the exception  
      System.out.println("Index out-of-bounds!");  
    }  
    System.out.println("After catch statement.");  
  }  
}

//listing 5
// Handle error gracefully and continue. 
class ExcDemo3 { 
  public static void main(String args[]) { 
    int numer[] = { 4, 8, 16, 32, 64, 128 }; 
    int denom[] = { 2, 0, 4, 4, 0, 8 }; 
 
    for(int i=0; i<numer.length; i++) { 
      try { 
        System.out.println(numer[i] + " / " + 
                           denom[i] + " is " + 
                           numer[i]/denom[i]); 
      } 
      catch (ArithmeticException exc) { 
        // catch the exception 
        System.out.println("Can't divide by Zero!"); 
      } 
    } 
  } 
}

//listing 6
// Use multiple catch statements. 
class ExcDemo4 { 
  public static void main(String args[]) { 
    // Here, numer is longer than denom. 
    int numer[] = { 4, 8, 16, 32, 64, 128, 256, 512 }; 
    int denom[] = { 2, 0, 4, 4, 0, 8 }; 
 
    for(int i=0; i<numer.length; i++) { 
      try { 
        System.out.println(numer[i] + " / " + 
                           denom[i] + " is " + 
                           numer[i]/denom[i]); 
      } 
      catch (ArithmeticException exc) { 
        // catch the exception 
        System.out.println("Can't divide by Zero!"); 
      } 
      catch (ArrayIndexOutOfBoundsException exc) { 
        // catch the exception 
        System.out.println("No matching element found."); 
      } 
    } 
  } 
}

//listing 7
// Subclasses must precede superclasses in catch statements. 
class ExcDemo5 { 
  public static void main(String args[]) { 
    // Here, numer is longer than denom. 
    int numer[] = { 4, 8, 16, 32, 64, 128, 256, 512 }; 
    int denom[] = { 2, 0, 4, 4, 0, 8 }; 
 
    for(int i=0; i<numer.length; i++) { 
      try { 
        System.out.println(numer[i] + " / " + 
                           denom[i] + " is " + 
                           numer[i]/denom[i]); 
      } 
      catch (ArrayIndexOutOfBoundsException exc) { 
        // catch the exception 
        System.out.println("No matching element found."); 
      } 
      catch (Throwable exc) { 
        System.out.println("Some exception occurred."); 
      } 
    } 
  } 
}

//listing 8
// Use a nested try block. 
class NestTrys { 
  public static void main(String args[]) { 
    // Here, numer is longer than denom. 
    int numer[] = { 4, 8, 16, 32, 64, 128, 256, 512 }; 
    int denom[] = { 2, 0, 4, 4, 0, 8 }; 
 
    try { // outer try 
      for(int i=0; i<numer.length; i++) { 
        try { // nested try 
          System.out.println(numer[i] + " / " + 
                             denom[i] + " is " + 
                             numer[i]/denom[i]); 
        } 
        catch (ArithmeticException exc) { 
          // catch the exception 
          System.out.println("Can't divide by Zero!"); 
        } 
      } 
    }  
    catch (ArrayIndexOutOfBoundsException exc) { 
      // catch the exception 
      System.out.println("No matching element found."); 
      System.out.println("Fatal error -- program terminated."); 
    } 
  } 
}

//listing 9
// Manually throw an exception. 
class ThrowDemo { 
  public static void main(String args[]) { 
    try { 
      System.out.println("Before throw."); 
      throw new ArithmeticException(); 
    } 
    catch (ArithmeticException exc) { 
      // catch the exception 
      System.out.println("Exception caught."); 
    } 
    System.out.println("After try/catch block."); 
  } 
}

//listing 10
// Rethrow an exception. 
class Rethrow { 
  public static void genException() { 
    // here, numer is longer than denom 
    int numer[] = { 4, 8, 16, 32, 64, 128, 256, 512 }; 
    int denom[] = { 2, 0, 4, 4, 0, 8 }; 
 
    for(int i=0; i<numer.length; i++) { 
      try { 
        System.out.println(numer[i] + " / " + 
                           denom[i] + " is " + 
                           numer[i]/denom[i]); 
      } 
      catch (ArithmeticException exc) { 
        // catch the exception 
        System.out.println("Can't divide by Zero!"); 
      } 
      catch (ArrayIndexOutOfBoundsException exc) { 
        // catch the exception 
        System.out.println("No matching element found."); 
        throw exc; // rethrow the exception 
      } 
    } 
  }   
} 
 
class RethrowDemo { 
  public static void main(String args[]) { 
    try { 
      Rethrow.genException(); 
    } 
    catch(ArrayIndexOutOfBoundsException exc) { 
      // recatch exception 
     System.out.println("Fatal error -- " + 
                        "program terminated."); 
    } 
  } 
}

//listing 11
// Using the Throwable methods.  
 
class ExcTest { 
  static void genException() { 
    int nums[] = new int[4];  
 
    System.out.println("Before exception is generated."); 
 
    // generate an index out-of-bounds exception  
    nums[7] = 10;  
    System.out.println("this won't be displayed");  
  } 
}     
 
class UseThrowableMethods {  
  public static void main(String args[]) {  
  
    try {  
      ExcTest.genException(); 
    }  
    catch (ArrayIndexOutOfBoundsException exc) {  
      // catch the exception  
      System.out.println("Standard message is: "); 
      System.out.println(exc); 
      System.out.println("\nStack trace: "); 
      exc.printStackTrace(); 
    }  
    System.out.println("After catch statement.");  
  }  
}

//listing 12
// Use finally. 
class UseFinally { 
  public static void genException(int what) { 
    int t; 
    int nums[] = new int[2]; 
 
    System.out.println("Receiving " + what); 
    try { 
      switch(what) { 
        case 0:  
          t = 10 / what; // generate div-by-zero error 
          break; 
        case 1: 
          nums[4] = 4; // generate array index error. 
          break; 
        case 2: 
          return; // return from try block 
      } 
    } 
    catch (ArithmeticException exc) { 
      // catch the exception 
      System.out.println("Can't divide by Zero!"); 
      return; // return from catch 
    } 
    catch (ArrayIndexOutOfBoundsException exc) { 
      // catch the exception 
      System.out.println("No matching element found."); 
    } 
    finally { 
      System.out.println("Leaving try."); 
    } 
  }   
} 
 
class FinallyDemo { 
  public static void main(String args[]) { 
     
    for(int i=0; i < 3; i++) { 
      UseFinally.genException(i); 
      System.out.println(); 
    } 
  } 
}

//listing 13
// Use throws. 
class ThrowsDemo {   
  public static char prompt(String str) 
    throws java.io.IOException { 
 
    System.out.print(str + ": "); 
    return (char) System.in.read();  
  }   
 
  public static void main(String args[]) { 
    char ch; 
 
    try { 
      ch = prompt("Enter a letter"); 
    } 
    catch(java.io.IOException exc) { 
      System.out.println("I/O exception occurred."); 
      ch = 'X'; 
    } 
 
    System.out.println("You pressed " + ch); 
  } 
}

//listing 14
// Use the multi-catch feature.  Note: This code requires JDK 7 or
// later to compiler.
class MultiCatch {
  public static void main(String args[]) {
    int a=88, b=0;
    int result;
    char chrs[] = { 'A', 'B', 'C' };
    
    for(int i=0; i < 2; i++) {
      try {
        if(i == 0)
          result = a / b; // generate an ArithmeticException  
        else
          chrs[5] = 'X'; // generate an ArrayIndexOutOfBoundsException

      // This catch clause catches both exceptions.
      } catch(ArithmeticException |
              ArrayIndexOutOfBoundsException e) {
        System.out.println("Exception caught: " + e);
      }
    }

    System.out.println("After multi-catch.");
  }
}

//listing 15
// Use a custom exception. 
 
// Create an exception. 
class NonIntResultException extends Exception { 
  int n; 
  int d; 
 
  NonIntResultException(int i, int j) { 
    n = i; 
    d = j; 
  } 
 
  public String toString() { 
    return "Result of " + n + " / " + d + 
           " is non-integer."; 
  } 
} 
 
class CustomExceptDemo { 
  public static void main(String args[]) { 
 
    // Here, numer contains some odd values. 
    int numer[] = { 4, 8, 15, 32, 64, 127, 256, 512 }; 
    int denom[] = { 2, 0, 4, 4, 0, 8 }; 
    for(int i=0; i<numer.length; i++) { 
      try { 
        if((numer[i]%2) != 0) 
          throw new  
            NonIntResultException(numer[i], denom[i]); 
 
        System.out.println(numer[i] + " / " + 
                           denom[i] + " is " + 
                           numer[i]/denom[i]); 
      } 
      catch (ArithmeticException exc) { 
        // catch the exception 
        System.out.println("Can't divide by Zero!"); 
      } 
      catch (ArrayIndexOutOfBoundsException exc) { 
        // catch the exception 
        System.out.println("No matching element found."); 
      } 
      catch (NonIntResultException exc) { 
        System.out.println(exc); 
      } 
    } 
  } 
}

//listing 16
// An exception for queue-full errors. 
public class QueueFullException extends Exception { 
  int size; 
 
  QueueFullException(int s) { size = s; } 
 
  public String toString() { 
   return "\nQueue is full. Maximum size is " + 
          size; 
  } 
} 

//listing 17 
// An exception for queue-empty errors. 
public class QueueEmptyException extends Exception { 
 
  public String toString() { 
   return "\nQueue is empty."; 
  } 
}

//listing 18
/*  
    Try This 9-1 
 
    Add exception handling to the queue classes. 
*/

// A fixed-size queue class for characters that uses exceptions. 
class FixedQueue implements ICharQ {     
  private char q[]; // this array holds the queue     
  private int putloc, getloc; // the put and get indices     
     
  // Construct an empty queue given its size.    
  public FixedQueue(int size) {  
    q = new char[size]; // allocate memory for queue     
    putloc = getloc = 0;     
  }     
    
  // Put a characer into the queue.     
  public void put(char ch) 
    throws QueueFullException {     
 
    if(putloc==q.length)  
      throw new QueueFullException(q.length); 
         
    q[putloc++] = ch;     
  }     
     
  // Get a character from the queue.    
  public char get() 
    throws QueueEmptyException {     
 
    if(getloc == putloc)  
      throw new QueueEmptyException(); 
       
    return q[getloc++];     
  }     
}

//listing 19
// Demonstrate the queue exceptions.     
class QExcDemo {     
  public static void main(String args[]) {     
    FixedQueue q = new FixedQueue(10);     
    char ch;     
    int i;     
     
    try {  
      // overrun the queue 
      for(i=0; i < 11; i++) { 
        System.out.print("Attempting to store : " + 
                         (char) ('A' + i)); 
        q.put((char) ('A' + i));     
        System.out.println(" -- OK"); 
      } 
      System.out.println(); 
    } 
    catch (QueueFullException exc) { 
      System.out.println(exc); 
    } 
    System.out.println(); 
    
    try { 
      // over-empty the queue 
      for(i=0; i < 11; i++) {      
        System.out.print("Getting next char: "); 
        ch = q.get();     
        System.out.println(ch);     
      } 
    } 
    catch (QueueEmptyException exc) { 
      System.out.println(exc); 
    }  
  }     
}

//listing 20
// A character queue interface that throws exceptions.  
public interface ICharQ {     
  // Put a characer into the queue.     
  void put(char ch) throws QueueFullException;  
  
  // Get a character from the queue.    
  char get() throws QueueEmptyException;  
}

