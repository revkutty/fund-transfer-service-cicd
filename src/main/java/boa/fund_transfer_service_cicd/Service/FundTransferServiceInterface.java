package boa.fund_transfer_service_cicd.Service;

import boa.fund_transfer_service_cicd.Models.FundTransfer;

import java.util.List;
import java.util.Optional;

public interface FundTransferServiceInterface {


     List<FundTransfer> getPendingTransfers();

     // Initiates a new fund transfer
     FundTransfer initiateTransfer(FundTransfer fundTransfer);

     // Retrieves all transfers initiated by a specific sender account
     List<FundTransfer> getTransfersBySender(Long senderAccount);

     // Retrieves all transfers received by a specific receiver account
     List<FundTransfer> getTransfersByReceiver(Long receiverAccount);

     // Retrieves all transfers with a specific status
     List<FundTransfer> getTransfersByStatus(String status);

     List<FundTransfer> getAllFundTransfer();
     Optional<FundTransfer> getFundTransferByTranferId(Long transferId);

}