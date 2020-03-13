package org.xiaom.vhr.mapper;

import org.apache.ibatis.annotations.Param;
import org.xiaom.vhr.model.JobLevel;

import java.util.List;

public interface JobLevelMapper {
    int insert(JobLevel record);

    int insertSelective(JobLevel record);

    JobLevel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(JobLevel record);

    int updateByPrimaryKey(JobLevel record);

    List<JobLevel> getAllJobLevels();

    List<JobLevel> getEnabledJobLevels();

    Integer deleteJobLevelsByIds(@Param("ids") Integer[] ids);
}