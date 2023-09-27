package cz.vb.auction.repository

import cz.vb.auction.entity.AuctionEntity
import org.springframework.data.repository.CrudRepository

interface AuctionEntityRepository : CrudRepository<AuctionEntity, Long> {
}