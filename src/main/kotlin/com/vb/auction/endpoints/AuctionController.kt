package com.vb.auction.endpoints

import com.vb.auction.dto.AuctionDto
import com.vb.auction.singletons.Auction
import com.vb.auction.singletons.AuctionManager
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping
class AuctionController {


    @GetMapping("/alive")
    fun sayHello(): String {
        return "Alive!"
    }

    @GetMapping("/auction")
    fun getRunningAuctions(): MutableCollection<String> {
        val auctionManager = AuctionManager.getAuctionManager();
        val auctions = auctionManager.auctionsNames;
        return auctions.values;

    }

    @GetMapping("/auction/detail")
    fun getAuctionDetail(@RequestParam auctionId: String): Auction? {
        val auctionManager = AuctionManager.getAuctionManager();
        val auctions = auctionManager.auctions;
        return auctions.get(auctionId);

    }

    @PostMapping("/auction")
    fun createAuction(@RequestBody auction: Auction): AuctionDto {
        val auctionManager = AuctionManager.getAuctionManager();
        auctionManager.createAuction(auction);
    }
}