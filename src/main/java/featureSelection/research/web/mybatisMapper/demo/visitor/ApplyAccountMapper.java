package featureSelection.research.web.mybatisMapper.demo.visitor;

import featureSelection.research.web.entity.demo.visitor.ApplyAccount;
import org.springframework.stereotype.Repository;

/**
 * @ClassName : ApplyAccountMapper
 * @Description :
 * @Author : WDD
 * @Date: 2020-04-13 15:07
 */
@Repository
public interface ApplyAccountMapper {
    public void insertApplyAccount(ApplyAccount applyAccount);
}
