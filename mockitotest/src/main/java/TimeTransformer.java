import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class TimeTransformer {

	/**
	 * returns current time minus one day
	 * @return
	 */
	public String formatCurrentTime() {
		DateTime          dt          = DateTime.now();
		DateTime          newDateTime = dt.minusDays(1);
		DateTimeFormatter fmt         = DateTimeFormat.forPattern("dd, MMMM, yyyy HH:mm:ss");
		String            result      = fmt.print(newDateTime);
		return result;
	}
}

