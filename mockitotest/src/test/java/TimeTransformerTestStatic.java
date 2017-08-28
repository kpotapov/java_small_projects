import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(DateTime.class)
public class TimeTransformerTestStatic {

	/** mock a response from a static third party function */
	@Test
	public void testFormatCurrentTimeResult() throws Exception {

		PowerMockito.mockStatic(DateTime.class);

		DateTime mockedTime = new DateTime(2017, 8, 26, 10, 34, 44);
		PowerMockito.when(DateTime.now()).thenReturn(mockedTime);

		org.junit.Assert.assertEquals(DateTime.now(), mockedTime);

		TimeTransformer jodaTime            = new TimeTransformer();
		String          actualFormattedTime = jodaTime.formatCurrentTime();

		org.junit.Assert.assertEquals("25, August, 2017 10:34:44", actualFormattedTime);

	}
}