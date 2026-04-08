package com.spring.naeilhome.board.board_notice.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.naeilhome.board.board_notice.domain.NoticeDomain;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NoticeDAO {
	
	public List<NoticeDomain> noticeList() throws DataAccessException;

}
