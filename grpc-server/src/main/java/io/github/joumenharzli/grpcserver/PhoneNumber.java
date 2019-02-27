package io.github.joumenharzli.grpcserver;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

enum PhoneType {
    MOBILE,
    HOME,
    WORK,
    UNRECOGNIZED
}

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PhoneNumber {
    private String number;
    private PhoneType type;

}
