package io.github.joumenharzli.grpcserver;

import io.github.joumenharzli.grpcserver.proto.UserProto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    @Mapping(source = "phonesList", target = "phones")
    User toEntity(UserProto.User user);

    List<PhoneNumber> toPhoneNumbers(List<UserProto.User.PhoneNumber> phoneNumbers);

    PhoneNumber toPhoneNumber(UserProto.User.PhoneNumber phoneNumber);

    PhoneType toPhoneType(UserProto.User.PhoneType phoneType);

    @Mapping(source = "phones", target = "phonesList")
    UserProto.User toProto(User user);

    List<UserProto.User.PhoneNumber> toPhoneNumberProtos(List<PhoneNumber> phoneNumbers);

    UserProto.User.PhoneNumber toPhoneNumberProto(PhoneNumber phoneNumber);

    UserProto.User.PhoneType toPhoneTypeProto(PhoneType phoneType);


}
