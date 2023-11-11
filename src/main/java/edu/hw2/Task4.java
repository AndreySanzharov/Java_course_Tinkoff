package edu.hw2;

public class Task4 {
    public record CallingInfo(String className, String methodName) {
    }

    public static CallingInfo callingInfo() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();

        // Obtain information about the calling class and method
        StackTraceElement callingMethod = stackTrace[2];
        String className = callingMethod.getClassName();
        String methodName = callingMethod.getMethodName();

        return new CallingInfo(className, methodName);
    }
}
