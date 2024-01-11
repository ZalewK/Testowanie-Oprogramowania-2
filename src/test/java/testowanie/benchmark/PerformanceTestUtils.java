//package testowanie.benchmark;
//
//public class PerformanceTestUtils {
//
//    public static void measureExecutionTime(Runnable methodToTest, String methodName) {
//        long startTime = System.nanoTime();
//        for( int i = 0; i < 1000; i++) {
//            methodToTest.run();
//        }
//        long endTime = System.nanoTime();
//
//        long duration = (endTime - startTime)/1000;
//        System.out.println("Sredni czas wykonania metody " + methodName + ": " + duration + " nanosekund");
//    }
//
//
//
//}
