import com.rs.service.FutureService;
import org.junit.Rule;
import org.junit.Test;
import org.junit.internal.runners.statements.FailOnTimeout;
import org.junit.rules.Timeout;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public class FutureTest {

    int MIN_TIMEOUT = 1000;


    @Rule
    public Timeout timeout = new Timeout(MIN_TIMEOUT) {
        public Statement apply(Statement base, Description description) {
            return new FailOnTimeout(base, MIN_TIMEOUT) {
                @Override
                public void evaluate() throws Throwable {
                    try {
                        super.evaluate();
                        throw new TimeoutException();
                    } catch (Exception e) {}
                }
            };
        }
    };


    @Test(expected = TimeoutException.class)
    public void simpleFutureTest() throws ExecutionException, InterruptedException {
        FutureService<String> futureService= new FutureService<>();
        futureService.simpleFuture().get();

    }
}
