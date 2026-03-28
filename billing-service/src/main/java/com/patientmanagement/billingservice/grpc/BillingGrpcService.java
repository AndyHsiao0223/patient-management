package com.patientmanagement.billingservice.grpc;

import com.patientmanagement.billingservice.grpc.BillingServiceGrpc.BillingServiceImplBase;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@GrpcService
public class BillingGrpcService extends BillingServiceImplBase {
    private static final Logger log = LoggerFactory.getLogger(BillingGrpcService.class);

    @Override
    public void createBillingAccount(CreateBillingAccountRequest billingRequest, StreamObserver<CreateBillingAccountResponse> responseObserver) {
        log.info("createBillingAccount request received {}", billingRequest);

        // Business logic

        CreateBillingAccountResponse response = CreateBillingAccountResponse.newBuilder()
                .setAccountId("123")
                .setStatus("ACTIVE")
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
