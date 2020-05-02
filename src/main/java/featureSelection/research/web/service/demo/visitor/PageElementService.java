package featureSelection.research.web.service.demo.visitor;

import featureSelection.research.web.entity.demo.visitor.PageElement;

import java.util.List;

public interface PageElementService {
    public List<PageElement> findAll();
    public List<PageElement> findelemetsByHtml(String HtmlName);
}
