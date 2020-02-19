package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter @Setter
public class Order {

    @Id @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItmes = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "delivery_id") // 1 : 1 관계에서 한쪽을 주인으로 잡아줌.
    private Delivery delivery;

    private LocalDateTime orderDate; // hibernate가 자동으로 현재시간을 지원해 줌.

    @Enumerated(EnumType.STRING)
    private OrderStatus status; // 주문 상태[ORDER, CANCEL]

}
