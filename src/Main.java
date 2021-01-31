import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Main {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTest futureTest = new FutureTest();
        Future result = futureTest.compute(25, futureTest.someFunction());
        System.out.println(result.get());
    }

}
