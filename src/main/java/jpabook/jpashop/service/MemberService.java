package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true) // 모든 데이터의 변경은 트랜잭션 안에서 일어나야 함. readOnly = true 는 읽기 전용!
@RequiredArgsConstructor // final이 붙어있는 필드만을 가지고 생성자를 만들어 줌.
public class MemberService {

    private final MemberRepository memberRepository;

    /** 회원 가입 */
    @Transactional // 여기엔 readOnly = true를 넣으면 안됨.
    public Long join(Member member) {
        validateDuplicateMember(member); // 중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        // Exception : 이것도 완변하게 중복을 방지해주지 않기 때문에 디비쪽에도 unique 설정을 해줘야 함.
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    /** 회원 전체 조회 */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Member findOne(Long memberId) {
        return memberRepository.findOne(memberId);
    }

    @Transactional
    public void update(Long id, String name) {
        Member member = memberRepository.findOne(id);
        member.setName(name);
    }
}
