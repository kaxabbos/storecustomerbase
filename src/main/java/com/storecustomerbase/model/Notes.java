package com.storecustomerbase.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Notes {
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(length = 5000)
    private String text;
    private String date;
    @ManyToOne(fetch = FetchType.LAZY)
    private Users writer;
    @ManyToOne(fetch = FetchType.LAZY)
    private Users client;

    public Notes(String text, String date, Users writer, Users client) {
        this.text = text;
        this.date = date;
        this.writer = writer;
        this.client = client;
    }
}
