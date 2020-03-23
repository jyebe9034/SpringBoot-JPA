package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter

public class OrderSearch {

    private String memberName = "userA"; // 회원 이름
    private OrderStatus orderStatus = OrderStatus.ORDER; // 주문 상태[ORDER, CANCEL]
}
