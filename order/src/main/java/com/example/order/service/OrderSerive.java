package com.example.order.service;

import com.example.order.domain.dao.ItemDAO;
import com.example.order.domain.dao.OrderDAO;
import com.example.order.domain.vo.ItemVO;
import com.example.order.domain.vo.OrderDTO;
import com.example.order.domain.vo.OrderVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderSerive {
    private final ItemDAO itemDAO;
    private final OrderDAO orderDAO;

//    결제
//    외부에서 주문할 항목들을 전달받는다.
    public void addOrder(List<OrderVO> orders){
//        주문 번호를 1 증가시킨다.
        orderDAO.setOrderSequence();
        for(OrderVO order: orders){
            ItemVO itemVO =  itemDAO.findById(order.getItemNumber());
//            원래 재고에서 주문한 만큼 뺸다
            itemVO.setItemStock(itemVO.getItemStock() - order.getItemCount());
            itemDAO.setItem(itemVO);
//            주문 번호를 생성한다.
//            생성자에 매개변수로 전달하면 첫번째 속성부터 순서대로 채워진다
            OrderDTO orderDTO = new OrderDTO(orderDAO.findId());
//            전달받은 주문 정보를 담아준다.
            orderDTO.setItemCount(order.getItemCount());
            orderDTO.setItemNumber(order.getItemNumber());
//            주문한 상품의 한 개 가격을 담아준다.
            orderDTO.setItemPrice(itemDAO.findById(order.getItemNumber()).getItemPrice());
//            주문한 상품의 총 가격을 담아준다.
            orderDTO.setOrderPrice();
            orderDAO.save(orderDTO);
        }
    }
//    취소
    public void cancel(String orderId){
        for(OrderDTO order : orderDAO.findByOrderId(orderId)){
            ItemVO itemVO =  itemDAO.findById(order.getItemNumber());
            itemVO.setItemStock(itemVO.getItemStock() + order.getItemCount());
            itemDAO.setItem(itemVO);
        }
        orderDAO.deleteById(orderId);
    }
//    조회
    public List<OrderDTO> show(String itemName){
        return orderDAO.findByItemNumber(itemName);
    }

//    전체 조회
    public List<OrderDTO> showAll(){return orderDAO.findAll();}
}











