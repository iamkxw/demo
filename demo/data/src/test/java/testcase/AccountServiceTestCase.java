package testcase;

import base.TestBase;
import com.demo.data.domain.Account;
import com.demo.data.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

public class AccountServiceTestCase extends TestBase {

    @Autowired
    AccountService accountService;

    @Test
    public void testFindByPhone() {
        Account account = accountService.findByPhone("137");
        if (account == null) {
            System.out.println("no such account");
        } else {
            System.out.println(account.getAccountId());
        }
    }
}
