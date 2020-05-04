package featureSelection.research.web.mybatisMapper.execution.admin;

import org.apache.ibatis.annotations.Update;

public interface AlgorithmParamMapper {
    @Update("update parameter set parameter_setting_info=#{parameterSettingInfo}  where  algorithm_id=#{algorithmId}")
    public void createParamSettingInfo(int algorithmId, String parameterSettingInfo);
}
