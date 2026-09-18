package org.main.vitalview.global.transaction.repository;

import org.main.vitalview.global.transaction.entity.OutboundHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OutboundHistoryRepository extends JpaRepository<OutboundHistoryEntity, Long> {}
