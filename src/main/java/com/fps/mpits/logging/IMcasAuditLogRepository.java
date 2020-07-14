package com.fps.mpits.logging;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author HieuDT28 - (Hiếu Boy)
 * created 19/05/2020 - 17:30
 * @see <a href="https://docs.spring.io/spring-data/jpa/docs/2.0.7.RELEASE/reference/html/#jpa.query-methods.query-creation"></a>
 */

@Repository
public interface IMcasAuditLogRepository extends JpaRepository<McasAuditLogEntity, Long> {
}