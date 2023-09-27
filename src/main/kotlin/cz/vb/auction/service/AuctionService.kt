package cz.vb.auction.service

import cz.vb.auction.entity.AuctionEntity
import cz.vb.auction.repository.AuctionEntityRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AuctionService @Autowired constructor(private val repository: AuctionEntityRepository) {

    fun save(entity: AuctionEntity): AuctionEntity {
        return repository.save(entity)
    }

    fun findById(id: Long): AuctionEntity? {
        return repository.findById(id).orElse(null)
    }

}