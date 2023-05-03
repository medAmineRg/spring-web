package ma.pfe.repositories;

import ma.pfe.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole, Long> {

    AppRole findByNameRole(String nameRole);
}
