package spring.backend.library.config.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UsernameAndPasswordDto {
  private String username;
  private String password;
}
