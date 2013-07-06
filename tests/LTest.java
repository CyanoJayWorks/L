import com.agopinath.lthelogutil.L;
import com.agopinath.lthelogutil.Al;
import com.agopinath.lthelogutil.streams.LFileStream;
import com.agopinath.lthelogutil.streams.LGuiStream;

/**
 * Class used to test out logging functionality of <code>L</code>.
 * @author Ajay
 *
 */
public class LTest {
	public static void main(String args[]) {
		Al.og("TESTING L DEFAULT OUTPUT");
		Al.err("TESTING L DEFAULT OUTPUT");
		Al.dbg("TESTING L DEFAULT OUTPUT");
		L.og("FAST LOG OUTPUT");
		
		Al.addLStream(new LFileStream("./tests/test4.txt", true), "test1logger");
		Al.og("should be sent to ./test/test1.txt and console only");
		
		Al.addLStream(new LFileStream("./tests/test2.txt", true), "test2logger");
		Al.og("should be sent to test1.txt, test2.txt and console only");
		
		Al.addLStream(new LFileStream("./tests/test3.txt", true), "test3logger");
		Al.og("should be sent to test1.txt, test2.txt, test3.txt and console only");
		
		Al.removeLStream("test3logger");
		Al.og("should be sent to test1.txt, test2.txt and console only after removing test3logger");
		
		Al.addLStream(new LGuiStream(), "gui1logger");
		Al.og("logging to gui as well as other registered LStreams...");
		
		Al.removeLStream("gui1logger");
	}
}
