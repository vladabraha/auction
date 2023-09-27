package cz.vb.auction.dto

import java.math.BigDecimal
import java.time.ZonedDateTime

class AuctionDto(
    val startingPrice: BigDecimal,
    val minBid: BigDecimal,
    var currentBid: BigDecimal,
    val auctionName: String,
    val auctionStart: ZonedDateTime,
) {
}
