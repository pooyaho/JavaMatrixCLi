package matrix;

import org.junit.Test;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;

/**
 * User: pooya
 * Date: 2/6/13
 * Time: 2:25 PM
 */
public class MatrixTest {

    @Test
    public void testR() throws RserveException, REXPMismatchException {
        RConnection c=new RConnection();
        System.out.println(c.eval("rnorm(10)").asString());

    }
}
