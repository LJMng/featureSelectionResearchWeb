package featureSelection.research.web.service.demo.admin.impl;

import featureSelection.research.web.entity.demo.admin.HtmlElementDemoAdmin;
import featureSelection.research.web.mybatisMapper.demo.admin.HtmlElementDemoAdminMapper;
import featureSelection.research.web.service.demo.admin.HtmlElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class HtmlElementServiceImpl implements HtmlElementService {

    @Autowired
    HtmlElementDemoAdminMapper htmlElementDemoAdminMapper;

    @Override
    public List<HtmlElementDemoAdmin> findAllImages() {
        return htmlElementDemoAdminMapper.findAllImages();
    }

    @Override
    public HtmlElementDemoAdmin findByKey(String key) {
        return htmlElementDemoAdminMapper.findByKey(key);
    }

    @Override
    @Transactional
    public int deleteImage(String moduleKey) throws IOException {
        //获取当前项目下的路径
        Resource resource = new ClassPathResource("");
        HtmlElementDemoAdmin e = htmlElementDemoAdminMapper.findByKey(moduleKey);
        //获取图片路径
        String path = e.getEnValue();

        //匹配图片的名字
        Pattern p_img = Pattern.compile("<(img|IMG)(.*?)(/>|></img>|>)");
        Matcher m_img = p_img.matcher(path);
        boolean result_img = m_img.find();
        if (result_img) {
            while (result_img) {
                //获取到匹配的<img />标签中的内容
                String str_img = m_img.group(2);

                //开始匹配<img />标签中的src
                Pattern p_src = Pattern.compile("(src|SRC)=(\"|\')(.*?)(\"|\')");
                Matcher m_src = p_src.matcher(str_img);
                if (m_src.find()) {
                    String str_src = m_src.group(3);
                    int lastIndexOf = str_src.lastIndexOf("/");
                    String img_path = str_src.substring(lastIndexOf);
                    File file = new File(resource.getFile().getAbsolutePath() + "\\static\\images\\" + img_path);
                    if (file.exists()) {
                        //删除图片
                        boolean flag = file.delete();
                    }
                }
                //结束匹配<img />标签中的src
                //匹配content中是否存在下一个<img />标签，有则继续以上步骤匹配<img />标签中的src
                result_img = m_img.find();
            }
        }
        htmlElementDemoAdminMapper.deleteImage(moduleKey);
        return 0;
    }

    @Override
    @Transactional
    public int setDefault() {
        htmlElementDemoAdminMapper.dropTable();
        htmlElementDemoAdminMapper.setDefault();
        return 0;
    }

    @Override
    public int saveAboutUsPages(String html, String title) {
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        String moduleKey = str.substring(0, 8);
        HtmlElementDemoAdmin e = new HtmlElementDemoAdmin();
        e.setModuleKey(moduleKey);
        int l = 0;
        String h = html;
        do {
            l = html.indexOf("&lt;", l);
            if (l == -1) break;
            h = html.substring(0, l) + "<" + html.substring(l + "$lt;".length());
            l += "<".length();
            html = h;
        } while (true);
        do {
            l = html.indexOf("&gt;", l);
            if (l == -1) break;
            h = html.substring(0, l) + ">" + html.substring(l + "$gt;".length());
            l += ">".length();
            html = h;
        } while (true);
        e.setEnValue(html);
        e.setChValue(title);
        htmlElementDemoAdminMapper.saveAboutUsPages(e);
        return 0;
    }
}
