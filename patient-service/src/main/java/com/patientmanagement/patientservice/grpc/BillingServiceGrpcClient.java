package com.patientmanagement.patientservice.grpc;


import com.patientmanagement.billingservice.grpc.BillingServiceGrpc;
import com.patientmanagement.billingservice.grpc.CreateBillingAccountRequest;
import com.patientmanagement.billingservice.grpc.CreateBillingAccountResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class BillingServiceGrpcClient {
    private static final Logger log = LoggerFactory.getLogger(BillingServiceGrpcClient.class);
    private final BillingServiceGrpc.BillingServiceBlockingStub blockingStub;

    public BillingServiceGrpcClient(@Value("${billing.service.address:localhost}") String serverAddress, @Value("${billing.service.grpc.port:9001}") int serverPort) {
        log.info("Connecting to BillingService GRPC server at {}:{}", serverAddress, serverPort);

        ManagedChannel channel = ManagedChannelBuilder.forAddress(serverAddress, serverPort).usePlaintext().build();

        blockingStub = BillingServiceGrpc.newBlockingStub(channel);
    }

    public CreateBillingAccountResponse createBillingAccountResponse(String patientId, String name, String email) {
        CreateBillingAccountRequest request = CreateBillingAccountRequest.newBuilder().setPatientId(patientId).setName(name).setEmail(email).build();

        CreateBillingAccountResponse response = blockingStub.createBillingAccount(request);
        log.info("Received response from BillingService via GRPC: {}", response);

        return response;
    }
}
