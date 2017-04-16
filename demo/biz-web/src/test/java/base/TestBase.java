package base;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;

@SpringBootTest(classes = {
        com.demo.biz.web.Application.class,
        com.demo.biz.service.Application.class,
        com.demo.service.Application.class,
        com.demo.external.service.Application.class,
        com.demo.model.Application.class,
        com.demo.data.Application.class,
        com.demo.common.Application.class})
@ActiveProfiles(profiles = "development")
@WebAppConfiguration
public class TestBase extends AbstractTransactionalTestNGSpringContextTests {
}
