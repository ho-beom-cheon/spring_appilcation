package com.hohojoin.admin.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;

@Getter
@NoArgsConstructor
/*
* 테이블과 링크될 클래스임을 나타낸다.
* 기본값으로 클래스의 카멜케이스 이름을 언더스코어 네이밍(_)으로 테이블 이름을 매칭한다.
* */
@Entity
public class Posts {
    /*
    * [ @Id ]
    * 해당 테이블의 PK 필드를 나타낸다.
    *
    * [ @GeneratedValue ]
    * PK의 생성 규칙을 나타냅니다.
    * 스프링 부트 2.0 에서는 GenerationType.IDENTITY 옵션을 추가해야만 auto_increment가 된다.
    * */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // pk는 Long타입의 Auto_increment를 사용하는 것을 권장

    /*
    * 테이블의 칼럼을 나타내며 굳이 선언하지 않더라도 해당 클래스의 필드는 모두 칼럼이 된다.
    * 사용이유 : 기본값 외에 추가로 변경이 필요한 옵션이 있으면 사용한다.
    * */
    @Column(length = 200, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    /*
    * 해당 클래스의 빌더 패턴 클래스를 생성
    * 생성자 상단에 선언 시 생성장에 포함된 필드만 빌더에 포함
    * */
    @Builder
    public Posts(String title, String content, String author){

        this.title = title;
        this.content = content;
        this.author = author;
    }
}
