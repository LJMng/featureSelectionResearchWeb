package featureSelection.research.web.service.demo.visitor;

import featureSelection.research.web.entity.Result;
import featureSelection.research.web.entity.demo.visitor.ApplyAccount;

public interface IAccountService {
    public Result apply(ApplyAccount applyAccount);
    public Result loginByEmail(String email, String password);
    public int getAccountIdByEmail(String email);
}
