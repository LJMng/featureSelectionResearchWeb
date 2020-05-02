package featureSelection.research.web.service.demo.visitor.impl;

import featureSelection.research.web.entity.demo.visitor.PageElement;
import featureSelection.research.web.mybatisMapper.demo.visitor.PageElementMapper;
import featureSelection.research.web.service.demo.visitor.PageElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName : pageElementServiceImpl
 * @Description : 页面元素服务类
 * @Author : WDD
 * @Date: 2020-04-24 11:45
 */
@Service
public class pageElementServiceImpl implements PageElementService {

    @Autowired
    private PageElementMapper pageElementMapper;

    /**
     * 获取所有页面信息
     * @return
     */
    @Override
    public List<PageElement> findAll() {
        return pageElementMapper.findAll();
    }

    /**
     * 根据页面名称获取该页面所有元素
     * @param HtmlName
     * @return List<PageElement>
     */
    @Override
    public List<PageElement> findelemetsByHtml(String HtmlName) {
        return pageElementMapper.findelemetsByHtml(HtmlName);
    }
}
