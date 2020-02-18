package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "member") // Order의 member라는 필드에 의해 매핑되어 있다는 의미(연관 관계에서 주인이 아닌 쪽에 적어줌.)
    private List<Order> orders  = new ArrayList<>();
}
