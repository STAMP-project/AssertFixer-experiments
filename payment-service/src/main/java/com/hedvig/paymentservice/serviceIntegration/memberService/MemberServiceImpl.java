package com.hedvig.paymentservice.serviceIntegration.memberService;

import com.hedvig.paymentservice.serviceIntegration.memberService.dto.Member;
import com.hedvig.paymentservice.serviceIntegration.memberService.dto.SanctionStatus;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientResponseException;

@Service
public class MemberServiceImpl implements MemberService {

  private final Logger log = LoggerFactory.getLogger(MemberServiceImpl.class);
  private final MemberServiceClient memberServiceClient;

  public MemberServiceImpl(
      MemberServiceClient memberServiceClient) {
    this.memberServiceClient = memberServiceClient;
  }

  @Override
  public Optional<Member> getMember(String memberId) {
    try {
      ResponseEntity<Member> response = memberServiceClient.getMember(memberId);
      return Optional.of(response.getBody());
    } catch (RestClientResponseException ex) {
      if (ex.getRawStatusCode() == 404) {
        return Optional.empty();
      }
      log.error("Could not find member {} , {}", memberId, ex);
      throw ex;
    }
  }

  @Override
  public SanctionStatus getMemberSanctionStatus(String memberId) {
    try {
      ResponseEntity<SanctionStatus> response = memberServiceClient
          .getSanctionListStatus(memberId);
      return response.getBody();
    } catch (RestClientResponseException ex) {
      if (ex.getRawStatusCode() == 404) {
        return SanctionStatus.Undetermined;
      }
      log.error("Could not check sanction list for member {} , {}", memberId, ex);
      throw ex;
    }
  }
}
