package com.spring.naeilhome.cre.dao;

import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.spring.naeilhome.mypage.delivery.domain.DeliveryDomain;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CreDAO {
	
	public DeliveryDomain creProductApplication(Map<String, Object> map) throws DataAccessException;
	public void addCre(Map<String, Object> map) throws DataAccessException;
	public void addCreImage(Map<String, Object> map) throws DataAccessException;
	public int creCount() throws DataAccessException;

}
