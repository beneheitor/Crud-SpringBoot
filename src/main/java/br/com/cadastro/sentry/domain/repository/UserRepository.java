package br.com.cadastro.sentry.domain.repository;


import br.com.cadastro.sentry.domain.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<Users, UUID> {

    Users findByName(String name);
}
