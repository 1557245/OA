package com.woniuxy.oa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniuxy.oa.entity.Work;
import com.woniuxy.oa.entity.WorkPart;
import com.woniuxy.oa.mapper.WorkMapper;
import com.woniuxy.oa.service.WorkService;

@Service("workService")
public class WorkServiceImpl implements WorkService {
	
	@Autowired
	WorkMapper workMapper;
	
	@Override
	public List<Work> getAllWork() {
		List<Work> works=workMapper.selectAllWork();
		return works;
	}

	@Override
	public Work getWorkByName(String name) {
		Work work=workMapper.selectWorkByName(name);
		return work;
	}

	@Override
	public void updateWork(Work work) {
		workMapper.updateWork(work);
		
	}

	@Override
	public void deleteWorkById(Integer id) {
		workMapper.deleteWorkById(id);
	}

	@Override
	public Work selectWorkById(Integer id) {
		Work work=workMapper.selectWorkById(id);
		return work;
	}

	@Override
	public void insertWork(Work work) {
		workMapper.insertWork(work);
	}

	@Override
	public WorkPart<Work> showPartByWork(int num, Integer curent, Work work) {
		WorkPart<Work> works= new WorkPart<Work>();
		List<Work> lwork=workMapper.selectWorkByWork((curent-1)*num,num,work);
		
		int total=workMapper.selectTotalByWork(work);
		
		works.setWork(lwork);
		works.setTotal(total);
		works.setNum(num);
		works.setCurent(curent);
		works.setTotalPage();
		works.setBeginPageANDEndPage();
		works.setPages();
		
		return works;
	}

	@Override
	public WorkPart<Work> showPartByWork1(int num, Integer curent, Work work, Integer year, Integer month) {
		System.out.println("service----------showPartByWork1");
		WorkPart<Work> works= new WorkPart<Work>();
		List<Work> lwork=workMapper.selectWorkByWork1((curent-1)*num,num,work,year,month);
		int total=workMapper.selectTotalByWork(work);
		works.setWork(lwork);
		works.setTotal(total);
		works.setNum(num);
		works.setCurent(curent);
		works.setTotalPage();
		works.setBeginPageANDEndPage();
		works.setPages();
		System.out.println("servicezhelile ");
		return works;
	}

	

}
