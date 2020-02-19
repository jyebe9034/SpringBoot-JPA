package jpabook.jpashop;

import com.fasterxml.jackson.databind.deser.std.StdKeyDeserializer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberRepositoryTest {

//    @Autowired MemberRepository memberRepo;

    @Test
    @Transactional
    @Rollback(false) // 기본적으로 테스트때는 데이터를 넣었다가 롤백시키는데 직접 데이터를 보고싶으면 이 설정을 넣어주면 됨.
    public void testMember() throws Exception {
        // given
//        Member member = new Member();
//        member.setUsername("memberA");

        // when
//        Long savedId = memberRepo.save(member);
//        Member findMember = memberRepo.find(savedId);

        // then
//        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
//        Assertions.assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
//        Assertions.assertThat(findMember).isEqualTo(member); // JPA 엔티티 동일성 보장
//        System.out.println("findMember == member : " + (findMember == member)); // true

    }
}