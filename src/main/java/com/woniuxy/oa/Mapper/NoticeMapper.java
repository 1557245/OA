package com.woniuxy.oa.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.woniuxy.oa.entity.Emps;
import com.woniuxy.oa.entity.Notice;

@Mapper
public interface NoticeMapper {
	// 测试数据库跑通没有
	Notice selectNoticeBynid(Integer nid);

	// 插入发布的公告
	void insertNotice(Integer n_eid, Integer n_asid,String title, String content, String recipinets, String publishtime, String annex,
			Integer nstate, Integer nflag);
	// 查询全部职员
	List<Emps> selectAllEmps();
	

	// 查询当前用户自己发布的公告（带分页条件查询,每页的容量，从哪里开始（与当前页码有关）），查询总的页码数
	List<Notice> selectMyPublishNotice(Integer eid, Integer selectStart, Integer pageSize);
	// 查询审批状态
	String selectNoticeState(Integer n_asid);
	// 查询公告的总数
	Integer selectMyPublishNoticeCount(Integer eid);
	// 查询当前用户的待审批的公告(根据公告id查询修改的公告)
	Notice selectWaitedNotice(Integer nid);

	// 将修改后的内容更新到数据库中
	void updateNotice(Integer nid, String title, String content, String recipinets, String publishtime);

	// 查询接收的公告，顺便查询总数
	List<Notice> selectReceivedNotice(String eidename, Integer selectStart1, Integer pageSize1);
	Integer selectReceivedNoticeCount(String ename);
	
	// 按照公告中的发布人id查询 发布人姓名
	Emps selectPublisher(Integer n_eid);

	
	// 查询待审批的公告,带分页数据的
	List<Notice> selectAllWaitedNotice(Integer selectStart2, Integer pageSize2);
	Integer selectAllWaitedNoticeCount();
	// 同意改变状态
	void agree(Integer nid);

	// 驳回
	void refuse(Integer nid);

	Notice selectNoticeFile(Integer nidPara);
}
