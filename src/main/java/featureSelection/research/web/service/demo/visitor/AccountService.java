package featureSelection.research.web.service.demo.visitor;

import featureSelection.research.web.entity.demo.visitor.ApplyAccount;

import java.util.Map;

public interface AccountService {
    public void apply(ApplyAccount applyAccount);
    public Map<String,Object> loginByEmail(String email, String password);
}
