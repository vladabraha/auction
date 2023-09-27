package com.vb.auction.singletons

import java.math.BigDecimal

class Auction(
    val startingPrice: BigDecimal,
    val minBid: BigDecimal,
    var currentBid: BigDecimal,
    val auctionName: String
) {

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
