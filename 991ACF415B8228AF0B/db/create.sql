/**********************************/
/* Table Name: 사원정보 */
/**********************************/
CREATE TABLE TB_INSA_SAWON(
        sabun                               VARCHAR(20)      NOT NULL COMMENT '사번',
        name                                VARCHAR(50)      NOT NULL COMMENT '이름',
        phone                               VARCHAR(20)      NULL  COMMENT '전화번호',
        email                               VARCHAR(50)      NULL  COMMENT '이메일'
) COMMENT='사원정보';

ALTER TABLE TB_INSA_SAWON ADD CONSTRAINT IDX_TB_INSA_SAWON_PK PRIMARY KEY (sabun);

/**********************************/
/* Table Name: 포상 경력 */
/**********************************/
CREATE TABLE TB_INSA_PRIZE(
        sabun                               VARCHAR(20)      NOT NULL COMMENT '사번',
        seq                                 INT      NOT NULL COMMENT '일련번호',
        prize_name                          VARCHAR(100)         NOT NULL COMMENT '포상 명칭',
        prize_org                           VARCHAR(50)      NULL  COMMENT '수여기관'
) COMMENT='포상 경력';

ALTER TABLE TB_INSA_PRIZE ADD CONSTRAINT IDX_TB_INSA_PRIZE_PK PRIMARY KEY (sabun, seq);
ALTER TABLE TB_INSA_PRIZE ADD CONSTRAINT IDX_TB_INSA_PRIZE_FK0 FOREIGN KEY (sabun) REFERENCES TB_INSA_SAWON (sabun);

