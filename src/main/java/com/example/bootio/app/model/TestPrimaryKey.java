package com.example.bootio.app.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Embeddable
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public final class TestPrimaryKey implements Serializable {
    @Column(name = "id")
    private String id;
}
