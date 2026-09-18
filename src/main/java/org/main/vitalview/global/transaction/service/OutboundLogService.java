package org.main.vitalview.global.transaction.service;

import lombok.RequiredArgsConstructor;
import org.main.vitalview.global.transaction.entity.OutboundHistoryEntity;
import org.main.vitalview.global.transaction.repository.OutboundHistoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OutboundLogService {

    private final OutboundHistoryRepository outboundHistoryRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveLog(OutboundHistoryEntity history) {
        outboundHistoryRepository.save(history);
    }
}