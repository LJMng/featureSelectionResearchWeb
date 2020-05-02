package featureSelection.research.web.mybatisMapper.demo.visitor;

import featureSelection.research.web.entity.demo.visitor.UpdateInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UpdateMapper {

    public List<UpdateInfo>getAllUpdateInfoList();

}
