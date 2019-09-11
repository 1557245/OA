package com.woniuxy.oa.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.woniuxy.oa.entity.Work;

@Mapper
public interface WorkMapper {
	List<Work> selectAllWork();

	Work selectWorkByName(@Param("name")String name);

	void updateWork(@Param("work")Work work);

	void deleteWorkById(Integer id);

	Work selectWorkById(Integer id);

	void insertWork(Work work);

	int selectTotalByWork(@Param("work")Work work);

	List<Work> selectWorkByWork(@Param("curent")int curent, @Param("num")int num, @Param("work")Work work);

	List<Work> selectWorkByWork1(@Param("curent")int curent, @Param("num")int num, @Param("work")Work work, 
			@Param("year")Integer year, @Param("month")Integer month);
	
}
