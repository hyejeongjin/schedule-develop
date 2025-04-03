CREATE TABLE schedule
(
    schedule_id     BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '일정 식별자',
    user_id     BIGINT	NOT NULL FOREIGN KEY COMMENT '유저 식별자',
    title	    VARCHAR(50)	NOT NULL COMMENT '제목',
    author	    VARCHAR(25)	NOT NULL COMMENT '유저명',
    pw	VARCHAR(10)	NOT NULL COMMENT '비밀번호',
    created	    DATETIME DEFAULT CURRENT_TIMESTAMP	NOT NULL COMMENT '작성일',
    modified	DATETIME DEFAULT CURRENT_TIMESTAMP	NOT NULL COMMENT '수정일'
);