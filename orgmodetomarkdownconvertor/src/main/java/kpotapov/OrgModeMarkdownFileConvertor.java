package kpotapov;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

@Component
public class OrgModeMarkdownFileConvertor {

	private final String infile;
	private final String outfile;

	@Autowired
	public OrgModeMarkdownFileConvertor(@Value("${infile}") String infile, @Value("${outfile}") String outfile) {
		this.infile = infile;
		this.outfile = outfile;
	}

	public void convert() throws IOException {
		String inString = com.google.common.io.Files.toString(new File(infile), Charset.defaultCharset());
		String convertedString  = OrgModeMarkdownConvertor.convert(inString);
		File targetFile = new File(outfile);
		com.google.common.io.Files.createParentDirs(targetFile);
		com.google.common.io.Files.write(convertedString.getBytes(), targetFile);
	}
}