package com.example.salonmanagement.security;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RefreshTokenService {

    private final RefreshTokenRepository repo;

    // TTL = 7 days
    private static final long REFRESH_TTL_SECONDS = 60L * 60 * 24 * 7;

    public RefreshTokenEntity createRefreshToken(String email) {
        // remove old tokens (optional)
        repo.deleteByEmail(email);

        RefreshTokenEntity t = RefreshTokenEntity.builder()
                .token(UUID.randomUUID().toString())
                .email(email)
                .expiryDate(Instant.now().plusSeconds(REFRESH_TTL_SECONDS))
                .build();
        return repo.save(t);
    }

    public boolean isValid(RefreshTokenEntity token) {
        return token.getExpiryDate().isAfter(Instant.now());
    }

    public RefreshTokenEntity findByToken(String token) {
        return repo.findByToken(token).orElse(null);
    }

    public void delete(String token) {
        repo.findByToken(token).ifPresent(repo::delete);
    }
}
