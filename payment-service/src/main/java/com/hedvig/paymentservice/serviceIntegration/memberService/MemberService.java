package com.hedvig.paymentservice.serviceIntegration.memberService;

import com.hedvig.paymentservice.serviceIntegration.memberService.dto.Member;
import com.hedvig.paymentservice.serviceIntegration.memberService.dto.SanctionStatus;
import java.util.Optional;

public interface MemberService {

  Optional<Member> getMember(String memberId);

  SanctionStatus getMemberSanctionStatus(String memberId);
}