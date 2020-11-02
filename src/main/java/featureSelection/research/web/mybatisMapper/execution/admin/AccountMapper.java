package featureSelection.research.web.mybatisMapper.execution.admin;

import featureSelection.research.web.entity.execution.admin.Account;
import featureSelection.research.web.entity.execution.admin.ApplyAccount;
import featureSelection.research.web.entity.execution.admin.Power;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AccountMapper {
    @Select("select * from account")
    public List<Account> getAccounts();

    @Update("update account set account_name=#{accountName},account_email=#{accountEmail} where account_id=#{accountId}")
    public void updateAccount(Account account);

    @Select("select * from power where account_power=#{accountPower}")
    Power findPowerById(int accountPower);

    @Insert("insert into power (account_power,account_id)" +
            " values (#{accountPower},#{accountId})")
    public void addPower(Power newPower);

    @Insert("insert into account (account_name,account_password,account_email,account_power) values" +
            " (#{accountName},#{accountPassword},#{accountEmail},#{accountPower})")
    public void addAccount(Account account);

    @Delete("delete from account where account_id=#{accountId}")
    public void deleteAccount(int accountId);

//    @Update("update power set execution_algorithm1=#{executionAlgorithm1},execution_algorithm2=#{executionAlgorithm2}" +
//            " where account_id=#{accountId} and account_power = #{accountPower}")
//    public void updateAccountPower(Power power);

    @Select("select * from apply_account where apply_condition='审核中'")
    public List<ApplyAccount> getApplyAccounts();

    @Select("select * from apply_account where apply_id=#{applyId}")
    public ApplyAccount findApplyAccountById(int applyId);

    @Update("update apply_account set administrator_id=#{administratorId},administrator_reason=#{administratorReason},apply_condition=#{applyCondition}" +
            " where apply_id=#{applyId}")
    public void updateApplyAccount(ApplyAccount passApplyAccount);

    @Select("select account_power from account where account_id = #{accountId}")
    public String getAccountPowerById(int accountId);

    @Update("update account set account_power = #{accountPowerJsonString} where account_id = #{accountId}")
    public void updateAccountPower(int accountId, String accountPowerJsonString);
}
