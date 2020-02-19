package jpabook.jpashop.domain;

import jpabook.jpashop.domain.item.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Category {

    @Id @GeneratedValue
    @Column(name = "category_id")
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(name = "category_item",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    // N : N 관계에서는 컬럼이 아니라 테이블을 조인함. 디비쪽에서 N : N은 1 : N과 N : 1로 변경해서 풀어내야 하기때문에 중간에 매핑테이블이 필요함.
    // 실무에서는 이렇게 사용하지 않음. 왜냐면 매핑테이블에 어떤 다른 컬럼을 추가할 수 없기 때문.
    private List<Item> items = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private List<Category> child = new ArrayList<>();
}
