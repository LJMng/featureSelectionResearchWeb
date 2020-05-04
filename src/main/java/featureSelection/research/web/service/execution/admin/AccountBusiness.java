package featureSelection.research.web.service.execution.admin;

import featureSelection.research.web.entity.execution.admin.Account;
import featureSelection.research.web.entity.execution.admin.ApplyAccount;
import featureSelection.research.web.entity.execution.admin.Power;

import javax.mail.MessagingException;
import java.util.List;

public interface AccountBusiness {

    public List<Account> getAccounts();

    public void updateAccount(Account account);

    public void addAccount(Account account);

    public void deleteAccount(int accountId);

    public void updateAccountPower(Power power);

    public List<ApplyAccount> getApplyAccounts();

    public void passApplyAccount(ApplyAccount applyAccount) throws MessagingException;
}
