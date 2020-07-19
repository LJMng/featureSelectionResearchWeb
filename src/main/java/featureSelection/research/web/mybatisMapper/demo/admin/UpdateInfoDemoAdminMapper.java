package featureSelection.research.web.mybatisMapper.demo.admin;

import featureSelection.research.web.entity.demo.admin.UpdateInfoDemoAdmin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author jjz
 * @create 2020-07-19 8:55
 **/
@Component
@Mapper
public interface UpdateInfoDemoAdminMapper {
    //查询所有更新信息
    public List<UpdateInfoDemoAdmin> findAll();
    //通过ID查询更新信息
    public UpdateInfoDemoAdmin getUpdateInfoDemoAdminById(Integer id);
    //增加更新信息
    public int insertUpdateInfoDemoAdmin(UpdateInfoDemoAdmin updateInfoDemoAdmin);
    //删除被绑定ID的更新信息
    public int deleteUpdateInfoDemoAdmin(Integer id);
    //更新被绑定ID的更新信息
    public int updateUpdateInfoDemoAdmin(UpdateInfoDemoAdmin updateInfoDemoAdmin);
}
