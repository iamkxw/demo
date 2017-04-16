package testcase;

import base.TestBase;
import com.demo.common.enums.AccountType;
import com.demo.data.domain.Account;
import com.demo.data.domain.Admin;
import com.demo.data.repository.AccountRepository;
import com.demo.data.repository.AdminRepository;
import com.demo.data.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

/**
 * Created by Sawyer on 2017/1/16.
 */
public class AccountServiceTestCase extends TestBase {

    @Autowired
    AccountService accountService;
    @Autowired
    AdminRepository adminRepository;
    @Autowired
    AccountRepository accountRepository;

    @Test
    public void testFindByPhone() {
        Account account = accountService.findByPhone("137");
        if (account == null) {
            System.out.println("no such account");
        } else {
            System.out.println(account.getAccountId());
        }
    }

    @Test
    public Account testSave() {
        Account account = new Account();
        account.setType(AccountType.ADMIN);
        account.setPhone("13800001111");
        account.setPassword("admin");
        account.setIsValid(true);
        return accountRepository.save(account);
    }

    @Test
    public void normalSave() {
        Account account = testSave();
        Admin admin = new Admin();
        admin.setName("testAdmin");
        admin.setAccount(account);
        adminRepository.save(admin);
    }

    @Test
    public void cascadeSave() {
        Account account = new Account();
        account.setType(AccountType.ADMIN);
        account.setPhone("13700001111");
        account.setPassword("admin");
        account.setIsValid(true);
        Admin admin = new Admin();
        admin.setName("testAdmin");
        admin.setAccount(account);
        adminRepository.save(admin);
    }
}
