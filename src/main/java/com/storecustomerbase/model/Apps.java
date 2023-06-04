package com.storecustomerbase.model;

import com.storecustomerbase.model.enums.AppsStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Apps {
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(length = 5000)
    private String text;
    private String tel;
    private String date;
    @Enumerated(EnumType.STRING)
    private AppsStatus status;
    @OneToOne(fetch = FetchType.LAZY)
    private Users owner;

    public Apps(String text,String tel, String date, Users owner) {
        this.text = text;
        this.tel = tel;
        this.date = date;
        this.owner = owner;
        status = AppsStatus.WAITING;
    }
}
