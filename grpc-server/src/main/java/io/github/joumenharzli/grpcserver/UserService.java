package io.github.joumenharzli.grpcserver;

import io.github.joumenharzli.grpcserver.proto.UserProto;
import io.github.joumenharzli.grpcserver.proto.UserServiceGrpc;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService extends UserServiceGrpc.UserServiceImplBase {

    private final UserRepository repository;
    private final UserMapper mapper;

    @Override
    public void save(UserProto.User request, StreamObserver<UserProto.User> responseObserver) {

        User user = mapper.toEntity(request);

        repository.save(user)
                .map(mapper::toProto)
                .doOnNext(responseObserver::onNext)
                .subscribe(u -> responseObserver.onCompleted());

    }

    @Override
    public void findByFilters(UserProto.UserFilters request, StreamObserver<UserProto.User> responseObserver) {

        repository.findAll()
                .map(mapper::toProto)
                .doOnNext(responseObserver::onNext)
                .doOnComplete(responseObserver::onCompleted)
                .subscribe();

    }


}
