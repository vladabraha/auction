package cz.vb.auction.endpoints

import cz.vb.auction.dto.AuctionDto
import cz.vb.auction.entity.AuctionEntity
import cz.vb.singletons.AuctionManager
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping
class AuctionController {

    val auctionManager = AuctionManager.getAuctionManager();

    @GetMapping("/auction")
    fun getRunningAuctions(): String {
        val auctions = auctionManager.auctionsNames;
        return auctions.toString();

    }

    @GetMapping("/auction/detail")
    fun getAuctionDetail(@RequestParam auctionId: String): AuctionEntity? {
        val auctions = auctionManager.auctions;
        return auctions.get(auctionId);
    }

    @PostMapping("/auction")
    fun createAuction(@RequestBody auction: AuctionDto): AuctionEntity {
        return auctionManager.createAuction(auction);
    }
}