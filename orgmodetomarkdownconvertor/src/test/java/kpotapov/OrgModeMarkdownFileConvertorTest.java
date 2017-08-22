package kpotapov;

import org.testng.annotations.Test;

import java.io.File;
import java.nio.charset.Charset;

import static org.testng.Assert.assertEquals;

public class OrgModeMarkdownFileConvertorTest {
	@Test
	public void testConvert() throws Exception {

		String                       inFile          = "src/test/resources/org/four-entries.txt";
		String                       outFile         = "src/test/generated-resources/org/four-entries.md";
		String                       expectedOutFile = "src/test/resources/org/four-entries.md";
		OrgModeMarkdownFileConvertor convertor       = new OrgModeMarkdownFileConvertor(inFile, outFile);

		convertor.convert();

		String expectedOutFileData = com.google.common.io.Files.toString(new File(expectedOutFile), Charset.defaultCharset());
		String actualResultData    = com.google.common.io.Files.toString(new File(outFile), Charset.defaultCharset());
		assertEquals(expectedOutFileData, actualResultData);
	}
}