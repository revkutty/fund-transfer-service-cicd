package boa.fund_transfer_service_cicd.Repository;

import boa.fund_transfer_service_cicd.Models.FundTransfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FundTransferRepository extends JpaRepository<FundTransfer, Long> {
    // Find all transfers initiated by a specific sender account
    List<FundTransfer> findBySenderAccount(Long senderAccount);

    // Find all transfers received by a specific receiver account
    List<FundTransfer> findByReceiverAccount(Long receiverAccount);

    // Find all transfers with a specific status
    List<FundTransfer> findByStatus(String status);
}
