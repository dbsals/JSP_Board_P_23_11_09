package ym.jsp.board.service;

import ym.jsp.board.container.Container;
import ym.jsp.board.dto.Member;
import ym.jsp.board.dto.ResultData;
import ym.jsp.board.repository.MemberRepository;
import ym.jsp.board.util.Ut;

public class MemberService {
  private MemberRepository memberRepository;

  public MemberService() {
    memberRepository = Container.memberRepository;
  }

  public ResultData join(String loginId, String loginPw, String name, String email) {
    Member oldMember = getMemberByLoginId(loginId);

    if(oldMember != null) {
      return ResultData.from("F-1", Ut.f("%s(은)는 이미 가입된 로그인 아이디입니다.", loginId));
    }

    oldMember = getMemberByNameAndEmail(name, email);

    if(oldMember != null) {
      return ResultData.from("F-2", Ut.f("%s(은)는 이미 가입된 이메일입니다.", email));
    }

    int id = memberRepository.join(loginId, loginPw, name, email);

    return ResultData.from("S-1", "회원 가입이 완료되었습니다.", "id", id);
  }

  private Member getMemberByNameAndEmail(String name, String email) {
    return memberRepository.getMemberByNameAndEmail(name, email);
  }

  private Member getMemberByLoginId(String loginId) {
    return memberRepository.getMemberByLoginId(loginId);
  }

  public ResultData login(String loginId, String loginPw) {
    Member member = getMemberByLoginId(loginId);

    if(member == null) {
      return ResultData.from("F-1", "존재하지 않는 로그인 아이디입니다.");
    }

    if(member.getLoginPw().equals(loginPw) == false) {
      return ResultData.from("F-2", "비밀번호가 일치하지 않습니다.");
    }

    return ResultData.from("S-1", Ut.f("\"%s\"님 로그인 되었습니다.", loginId), "member", member);
  }
}