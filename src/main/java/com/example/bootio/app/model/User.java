package com.example.bootio.app.model;

import lombok.*;

import javax.validation.constraints.*;

@ToString
@RequiredArgsConstructor
@Builder
@Data
public class User {
    @Email
    private final String email;
    @NotBlank
    private final String pw;
    @NotNull
    private final UserRole userRole;
    @Min(12)
    private final int age;
}
