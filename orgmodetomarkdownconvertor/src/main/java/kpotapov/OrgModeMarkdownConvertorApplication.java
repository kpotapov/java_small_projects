package kpotapov;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class OrgModeMarkdownConvertorApplication implements CommandLineRunner {

    @Autowired
    private OrgModeMarkdownFileConvertor orgModeMarkdownConvertor ;

    @Override
    public void run(String... args) {
        if (args.length != 2) {
            throw new ExitException();
        } else {
            try {
                this.orgModeMarkdownConvertor.convert();
            } catch (IOException e) {
                throw new ExitException();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(OrgModeMarkdownConvertorApplication.class, args);
    }

}
