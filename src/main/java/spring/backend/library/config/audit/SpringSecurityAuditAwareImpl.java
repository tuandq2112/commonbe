package spring.backend.library.config.audit;

import java.util.Optional;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import spring.backend.library.config.userdetail.UserDetail;

class SpringSecurityAuditAwareImpl implements AuditorAware<Long> {

  @Override
  public Optional<Long> getCurrentAuditor() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

    if (authentication == null || !authentication.isAuthenticated()
        || authentication instanceof AnonymousAuthenticationToken) {
      return Optional.empty();
    }

    UserDetail userPrincipal = (UserDetail) authentication.getPrincipal();

    return Optional.ofNullable(userPrincipal.getUserId());
  }
}