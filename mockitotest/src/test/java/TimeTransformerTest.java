import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

public class TimeTransformerTest {

	/** mock a response from a function 	 */
	@org.testng.annotations.Test
	public void testFormatCurrentTimeResult() throws Exception {
		TimeTransformer time = mock(TimeTransformer.class);
		when(time.formatCurrentTime()).thenReturn("26, August, 2017 10:34:44");

		String currentTime = time.formatCurrentTime();
		assertEquals("26, August, 2017 10:34:44", currentTime);
	}
}