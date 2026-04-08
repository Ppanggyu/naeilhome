package com.spring.naeilhome.mypage.delivery.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.spring.naeilhome.mypage.delivery.domain.DeliveryDomain;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeliveryDAO {

	public List<DeliveryDomain> ordersList(String memberId) throws DataAccessException;
	public void buyCompleteDelivery(Map<String, Object> map) throws DataAccessException;

}
