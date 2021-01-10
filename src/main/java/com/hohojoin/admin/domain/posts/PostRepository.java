package com.hohojoin.admin.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

/*
* [ JpaRepository ]
* (Mybatis : Dao = Jpa : Repository)
* JpaRepository<Entitu클래스, PK타입>를 상속하면, CRUD를 자동으로 생성
* Entity 클래스와 기본 Repository는 함께 움직여야 한다.(도메이 패키지)
* */
public interface PostRepository extends JpaRepository<Posts,Long> {

}
