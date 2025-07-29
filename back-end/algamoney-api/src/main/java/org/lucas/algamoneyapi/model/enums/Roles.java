package org.lucas.algamoneyapi.model.enums;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
@Getter
public enum Roles implements GrantedAuthority {
    ADMIN("ROLE_ADMIN"),
    USUARIO("ROLE_USUARIO");


   private final String authority;

   Roles(String authority){
       this.authority = authority;
   }

    @Override
    public String getAuthority() {
        return authority;
    }
}
