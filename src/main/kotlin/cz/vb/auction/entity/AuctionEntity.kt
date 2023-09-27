package cz.vb.auction.entity

import cz.vb.auction.dto.AuctionDto
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.math.BigDecimal
import java.time.ZonedDateTime

data class AuctionEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,
    val startingPrice: BigDecimal,
    val minBid: BigDecimal,
    var currentBid: BigDecimal,
    val auctionName: String,
    val auctionStart: ZonedDateTime,
) {
    constructor(auctionDto: AuctionDto) : this(
        id = null,
        startingPrice = auctionDto.startingPrice,
        minBid = auctionDto.minBid,
        currentBid = auctionDto.currentBid,
        auctionName = auctionDto.auctionName,
        auctionStart = auctionDto.auctionStart
    ) {

    }

    init {
        require(startingPrice >= BigDecimal.ZERO) { "Starting price must be non-negative" }
        require(minBid >= BigDecimal.ZERO) { "Minimum bid must be non-negative" }
        require(currentBid >= startingPrice) { "Current bid must be at least the starting price" }
        require(auctionName.length >= 0) { "Auction have to have a name" }
    }

    fun bid(bid: BigDecimal) {
        if (minBid > bid) {
            throw RuntimeException("Minimum bid is $minBid")
        }

        currentBid = currentBid.add(bid)
    }

}
