package cz.vb.auction.repository

import cz.vb.auction.entity.AuctionEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository

@Repository
interface AuctionEntityRepository : CrudRepository<AuctionEntity, Long> {
}