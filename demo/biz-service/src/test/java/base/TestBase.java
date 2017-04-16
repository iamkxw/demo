package base;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;

@SpringBootTest(classes = {
        com.demo.biz.service.Application.class,
        com.demo.service.Application.class,
        com.demo.external.service.Application.class,
        com.demo.model.Application.class,
        com.demo.data.Application.class,
        com.demo.common.Application.class})
@ActiveProfiles(profiles = "development")
public class TestBase extends AbstractTransactionalTestNGSpringContextTests {
}
