package boa.fund_transfer_service_cicd.Controller;


import boa.fund_transfer_service_cicd.Models.FundTransfer;
import boa.fund_transfer_service_cicd.Service.FundTransferServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/fund-transfers")
public class FundTransferController {


    private final FundTransferServiceImpl fundTransferService;

    public FundTransferController(FundTransferServiceImpl fundTransferService) {
        this.fundTransferService = fundTransferService;
    }

    @PostMapping
    public ResponseEntity<FundTransfer> initiateFundTransfer(@RequestBody FundTransfer fundTransfer) {
        FundTransfer fundTransfers = fundTransferService.initiateTransfer(fundTransfer);
        return ResponseEntity.status(HttpStatus.CREATED).body(fundTransfer);
    }

    @GetMapping
    public ResponseEntity<List<FundTransfer>> getAllTransfers() {
        return ResponseEntity.ok(fundTransferService.getAllFundTransfer());
    }


    @GetMapping("/sender/{senderAccount}")
    public ResponseEntity<List<FundTransfer>> getTransfersBySender(@PathVariable Long senderAccount) {
        return ResponseEntity.ok(fundTransferService.getTransfersBySender(senderAccount));
    }

    @GetMapping("/receiver/{receiverAccount}")
    public ResponseEntity<List<FundTransfer>> getTransfersByReceiver(@PathVariable Long receiverAccount) {
        return ResponseEntity.ok(fundTransferService.getTransfersByReceiver(receiverAccount));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<FundTransfer>> getTransfersByStatus(@PathVariable String status) {
        return ResponseEntity.ok(fundTransferService.getTransfersByStatus(status));
    }


    @GetMapping("/{transferId}")
    public ResponseEntity<Optional<FundTransfer>> getTransferById(@PathVariable Long transferId) {
        return ResponseEntity.ok(fundTransferService.getFundTransferByTranferId(transferId));
    }



    public List<FundTransfer> getPendingTransfers() {
        return fundTransferService.getPendingTransfers();
    }


}
