package base;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;

@SpringBootTest(classes = {
        com.demo.data.Application.class,
        com.demo.common.Application.class})
@ActiveProfiles(profiles = "development")
public class TestBase extends AbstractTransactionalTestNGSpringContextTests {
}
