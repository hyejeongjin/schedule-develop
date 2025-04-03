CREATE TABLE schedule
(
    schedule_id     BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '일정 식별자',
    user_id         BIGINT	NOT NULL COMMENT '유저 식별자',
    title	        VARCHAR(50)	NOT NULL COMMENT '제목',
    content	        VARCHAR(2000)	NOT NULL COMMENT '내용',
    createdAt	    DATETIME DEFAULT CURRENT_TIMESTAMP	NOT NULL COMMENT '작성일',
    modifiedAt	    DATETIME DEFAULT CURRENT_TIMESTAMP	NOT NULL COMMENT '수정일',
    CONSTRAINT  schedule_fk1 FOREIGN KEY (user_id) REFERENCES  user (user_id)
);

CREATE TABLE user
(
    user_id         BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '유저 식별자',
    username	    VARCHAR(25)	NOT NULL COMMENT '유저명',
    password	    VARCHAR(10)	NOT NULL COMMENT '비밀번호',
    email	        VARCHAR(50)	NOT NULL COMMENT '이메일',
    createdAt	    DATETIME DEFAULT CURRENT_TIMESTAMP	NOT NULL COMMENT '작성일',
    modifiedAt	    DATETIME DEFAULT CURRENT_TIMESTAMP	NOT NULL COMMENT '수정일'
);