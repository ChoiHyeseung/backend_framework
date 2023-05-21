package net.skhu.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Department {
    @Id
//기본키(primary key)에 해당하는 멤버 변수
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//기본키가 Auto Increment 필드이거나 Identity 필드
    int id;

    String name;
    String shortName;
    String phone;

}
//데이터베이스 테이블의 레코드에 해당하는 Java 클래스이다.
//데에터베이스 조회 결과가 자동으로 엔터티 클래스 객체에 채워져 리턴된다.
