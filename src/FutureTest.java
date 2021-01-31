import java.util.Map;
import java.util.concurrent.*;

public class FutureTest {

    private Integer k;

    private Map<Integer, Integer> map = new ConcurrentHashMap<>();

    private final ExecutorService executorService = Executors.newSingleThreadExecutor();

    public Future compute(Integer x, Callable<Integer> function) {
        k = x;
        if (map.containsKey(k)) {
            return executorService.submit(() -> map.get(k));
        }
        Future<Integer> result = executorService.submit(function);
        executorService.shutdown();
        return result;
    }

    public Callable<Integer> someFunction() {
        return () -> k * 25 + 7;
    }
}
