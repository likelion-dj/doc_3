package com.ll.exam.doc_3.member.entity;

import com.ll.exam.doc_3.base.entity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;

import static lombok.AccessLevel.PROTECTED;

@Entity
@SuperBuilder
@Getter
@NoArgsConstructor(access = PROTECTED)
public class Member extends BaseEntity {
    private String username;
    @Setter
    private String email;
    @Setter
    private String password;

    @Setter
    private String name;
}
