package com.projetofinal.application.dtos;

import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class EmailMessageDTO {

    private String to;
    private String subject;
    private String body;

    public static EmailMessageDTO novo(String to, String subject, String body) {
        return new EmailMessageDTO(to, subject, body);
    }
}
