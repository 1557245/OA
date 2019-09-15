package com.woniuxy.oa.service;

import java.util.List;

import com.woniuxy.oa.entity.Work;
import com.woniuxy.oa.entity.WorkPart;


public interface WorkService {
	
	/**
	 * 查看所有用户工作计划
	 * @param 
	 * @return List<Work>
	 */
	List<Work> getAllWork();

	Work getWorkByName(String name);

	void deleteWorkById(Integer id);

	Work selectWorkById(Integer id);

	void updateWork(Work work);

	void insertWork(Work work);

	WorkPart<Work> showPartByWork(int num, Integer curent, Work work);

	WorkPart<Work> showPartByWork1(int num, Integer curent, Work work, Integer year, Integer month);


}
