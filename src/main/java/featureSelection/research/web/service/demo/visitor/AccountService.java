package featureSelection.research.web.service.demo.visitor;

import featureSelection.research.web.entity.Result;
import featureSelection.research.web.entity.demo.visitor.ApplyAccount;

public interface AccountService {
    public void apply(ApplyAccount applyAccount);
    public Result loginByEmail(String email, String password);
}
