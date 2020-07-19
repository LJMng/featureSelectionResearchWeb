package featureSelection.research.web.mybatisMapper.demo.visitor;

import featureSelection.research.web.entity.execution.admin.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AccountMapper {
    @Select("select * from account where account_email=#{email}")
    public Account getAccountByEmail(@Param("email") String email);
    @Select("select * from account where account_power=#{power}")
    public Account getAccountByPower(@Param("power") int power);
}
