package kpotapov;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class OrgModeMarkdownConvertorTest {

	@DataProvider
	private static Object[][] getLines(){
		return new Object[][] {
				{"*", "#"},
				{"* test", "# test"},
				{"* test *", "# test *"},
				{"* test #", "# test #"},
				{"* test two.", "# test two."},
				{"**", "##"},
				{"***", "###"},
				{"**** test", "#### test"},
				{"****", "####"},
				{" #word", " #word"},
		};
	}

	@Test(dataProvider = "getLines")
	public void shouldAddSameCurrencies(String in, String expectedOut) {
		String actualResult = OrgModeMarkdownConvertor.convert(in);
		assertEquals("The '*' chars from input string should be converted into '#' chars", expectedOut, actualResult);
	}


}