package hello.core.member;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor // 생성자를 만들어준다! 생성자가 딱 1개 있으면 @Autowired가 생략 가능해서 가능해짐
public class MemberServiceImpl implements MemberService {

    private final MemberRespository memberRespository;

//    @Autowired
//    public MemberServiceImpl(MemberRespository memberRespository) {
//        this.memberRespository = memberRespository;
//    }

    @Override
    public void join(Member member) {
        memberRespository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRespository.findById(memberId);
    }
}
