package featureSelection.research.web.mybatisMapper.demo.visitor;

import featureSelection.research.web.entity.demo.visitor.ApplyAccount;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @ClassName : ApplyAccountMapper
 * @Description :
 * @Author : WDD
 * @Date: 2020-04-13 15:07
 */
@Repository
@Mapper
public interface ApplyAccountMapper {
    @Insert("insert into apply_account(apply_email,apply_reason,apply_password)" +
            "value (#{applyEmail},#{applyReason},#{applyPassword})")
    public void insertApplyAccount(ApplyAccount applyAccount);
}
