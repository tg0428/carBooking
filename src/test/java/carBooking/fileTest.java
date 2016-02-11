package carBooking;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.wg.carbooking.utils.pictureCatch;


public class fileTest {

	@Test
	public void test() throws IOException {
		String url = "E:\\work\\carBooking\\src\\main\\webapp\\carBooking\\ueditor";
		List<String> files = pictureCatch.getServerPicturePaths(url);
		for (String string : files) {
			System.out.println(string);
		}
	}

}
