package featureSelection.research.web.mybatisMapper;

import featureSelection.research.web.entity.UpdateInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UpdateInfoMapper {
    public int recorder(UpdateInfo updateInfo);
}
