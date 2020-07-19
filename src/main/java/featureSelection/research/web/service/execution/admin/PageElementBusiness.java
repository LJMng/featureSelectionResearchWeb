package featureSelection.research.web.service.execution.admin;

import featureSelection.research.web.entity.execution.admin.PageElement;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 页面元素管理接口类
 * @Author: 马凯健
 * @Data: 2020-07-18
 */
@Service
public interface PageElementBusiness {
    /**
     * 新增页面元素,根据输入参数（页面元素实体类）,将页面元素信息添加至数据库。
     * @param pageElement 封装页面元素的实体类
     * @return boolean "true" or "false"
     */
    public boolean createPageElement(PageElement pageElement);

    /**
     * 获取所有页面元素信息，返回给前端页面，用于前端页面元素的渲染。
     * @return List<PageElement> 封装页面元素信息实体类的线性表
     */
    public List<PageElement> findAll();

    /**
     * 根据页面元素实体类，获取页面元素Id,修改在数据库中对应的页面元素信息
     * @param pageElement 封装页面元素信息的实体类
     * @return boolean "true" or "false"
     */
    public boolean updateElement(PageElement pageElement);

    /**
     * 删除页面元素信息，根据页面元素的唯一标识htmlName,moduleKey删除数据库中的页面元素信息。
     * @param htmlName String 页面名称
     * @param moduleKey String 页面元素标识
     * @return boolean "true" or "false"
     */
    public boolean delete(String htmlName, String moduleKey);

    /**
     * 删除页面元素
     * @param moduleKey 页面元素标识
     * @return boolean "true" or "false"
     */
    public boolean delete(String moduleKey);
}
