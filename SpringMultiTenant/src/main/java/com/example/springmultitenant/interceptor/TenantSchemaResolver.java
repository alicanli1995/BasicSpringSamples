package com.example.springmultitenant.interceptor;


import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class TenantSchemaResolver implements CurrentTenantIdentifierResolver {

    @Override
    public String resolveCurrentTenantIdentifier() {
        String t =  TenantContext.getCurrentTenant();
        return Objects.requireNonNullElse(t, "public");
    }

    @Override
    public boolean validateExistingCurrentSessions() {
        return true;
    }
}