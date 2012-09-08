import com.agopinath.lthelogutil.FL;
import com.agopinath.lthelogutil.L;
import com.agopinath.lthelogutil.streams.LFileStream;

/**
 * Class used to test out logging functionality of <code>L</code>.
 * @author Ajay
 *
 */
public class LTest {
	public static void main(String args[]) {
		L.og("TESTING");
		L.err("TESTING");
		L.dbg("TESTING");
		FL.og("d");
		
		L.addLStream(new LFileStream("./tests/test1.txt", true), "test1logger");
		L.og("should be sent to ./test/test1.txt and console only");
		
		L.addLStream(new LFileStream("./tests/test2.txt", true), "test2logger");
		L.og("should be sent to test1.txt, test2.txt and console only");
		
		L.addLStream(new LFileStream("./tests/test3.txt", true), "test3logger");
		L.og("should be sent to test1.txt, test2.txt, test3.txt and console only");
		
		L.removeLStream("test3logger");
		L.og("should be sent to test1.txt, test2.txt and console only after removing test3logger");
	}
}
