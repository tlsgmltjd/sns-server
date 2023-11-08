package com.example.hellochat.global.jwt.repository;

import com.example.hellochat.global.jwt.entity.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    Optional<RefreshToken> findByRefreshToken(String refrshToken);
    void deleteByRefreshToken(String refreshToken);
    void deleteByUserId(Long userId);
    boolean existsByUserId(Long userId);

}
