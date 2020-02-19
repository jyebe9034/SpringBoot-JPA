package jpabook.jpashop.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("B") // 상속관계 매핑에서 자식 엔티티에 넣어주는 것. SingleTable전략을 사용하긴 때문에 각 엔티티의 구분값을 지정해 주는 부분.
@Getter @Setter
public class Book extends Item {

    private String author;
    private String isbn;
}
