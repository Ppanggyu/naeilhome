package com.spring.naeilhome.order.dao;

import com.spring.naeilhome.order.domain.OrderDomain;
import com.spring.naeilhome.order.domain.OrderJoinDomain;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderDAO {

	OrderDomain getUserInfo(String memberId);

	// ��ǰ���� ��ȸ �޼��� �߰�
	OrderDomain getProductInfo(int productNO);
	
	OrderDomain getBasketInfo(OrderDomain domain);

	// �ֹ������� orders ���̺� �����ϴ� �޼��� �߰�
	int insertOrder(OrderDomain orderDomain);
	
	// 주문 상품(ordersJoin) 삽입 메서드
    int insertOrdersJoin(OrderJoinDomain orderJoinDomain);
}
