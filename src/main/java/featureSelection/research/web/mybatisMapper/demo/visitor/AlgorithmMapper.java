package featureSelection.research.web.mybatisMapper.demo.visitor;

import featureSelection.research.web.entity.demo.visitor.Algorithm;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlgorithmMapper {
    public List<Algorithm>getAllAlgorithmParameterList();

    public List<Algorithm>getAllAlgorithmInfo();

    public Algorithm getAlgorithmInfoById(@Param("algorithmid")int algorithmid);
}
