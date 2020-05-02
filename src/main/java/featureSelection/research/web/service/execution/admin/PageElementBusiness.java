package featureSelection.research.web.service.execution.admin;

import featureSelection.research.web.entity.execution.admin.PageElement;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PageElementBusiness {
    public boolean createPageElement(PageElement pageElement);

    public List<PageElement> findAll();

    public boolean updateElement(PageElement pageElement);

    public boolean delete(String htmlName, String moduleKey);

    public boolean delete(String moduleKey);
}
