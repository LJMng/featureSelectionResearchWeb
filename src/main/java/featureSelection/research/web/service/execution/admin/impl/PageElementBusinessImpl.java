package featureSelection.research.web.service.execution.admin.impl;


import featureSelection.research.web.entity.execution.admin.PageElement;
import featureSelection.research.web.mybatisMapper.PageElementMapper;
import featureSelection.research.web.service.execution.admin.PageElementBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PageElementBusinessImpl implements PageElementBusiness {
    @Autowired
    private PageElementMapper pageElementMapper;

    @Override
    public boolean createPageElement(PageElement pageElement) {
        pageElementMapper.createPageElement(pageElement);
        return true;
    }

    @Override
    public List<PageElement> findAll() {
        return pageElementMapper.findAll();
    }

    @Override
    public boolean updateElement(PageElement pageElement) {
        pageElementMapper.updatePageElement(pageElement);
        return true;
    }

    @Override
    public boolean delete(String htmlName, String moduleKey) {
        pageElementMapper.deletePageElement(htmlName,moduleKey);
        return true;
    }

    @Override
    public boolean delete(String moduleKey) {
        pageElementMapper.deletePageElementByModuleKey(moduleKey);
        return true;
    }
}
