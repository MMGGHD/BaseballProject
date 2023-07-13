## README
```sql
-- 데이터 베이스 생성
create database btmdb;

-- 데이터 베이스 선택
use btmdb;

-- 1.1 stadium 테이블 생성
create table stadium (
id int PRIMARY KEY auto_increment,
name varchar (50),
created_at timestamp
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


-- 1.2 team 테이블 생성
create table team (
id int PRIMARY KEY auto_increment,
stadium_id int,
name varchar(50),
created_at timestamp,
FOREIGN KEY(stadium_id) REFERENCES stadium(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 1.3 선수테이블(각 9명) 생성
create table player (
id int PRIMARY KEY auto_increment,
team_id int,
name varchar(30),
position varchar(30),
created_at timestamp,
FOREIGN KEY(team_id) REFERENCES team(id),
CONSTRAINT UKTP UNIQUE KEY (team_id, position)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 1.4 퇴출 선수 테이블 생성
create table out_player (
id int PRIMARY KEY auto_increment,
player_id int,
reason varchar(90),
created_at timestamp,
FOREIGN KEY(player_id) REFERENCES player(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


-- stadium 테이블 데이터 입력
INSERT INTO stadium(name, created_at) VALUES('사직 야구장', '1985-10-14');
INSERT INTO stadium(name, created_at) VALUES('인천 SSG 랜더스 필드', '2002-02-25');
INSERT INTO stadium(name, created_at) VALUES('창원 NC파크', '2019-03-18');


-- team 테이블 데이터 입력
INSERT INTO team(stadium_id, name, created_at) VALUES(1, '롯데 자이언츠', '1975-05-06');
INSERT INTO team(stadium_id, name, created_at) VALUES(2, 'SK 와이번스', '2000-03-31');
INSERT INTO team(stadium_id, name, created_at) VALUES(3, 'NC 다이노스', '2011-03-31');

-- 선수 테이블(롯데 자이언츠) 데이터 입력
INSERT INTO player(team_id, name, position, created_at) VALUES(1, '이대호', '3루수','1981-06-21');
INSERT INTO player(team_id, name, position, created_at) VALUES(1, '조경민', '유격수','2004-09-17');
INSERT INTO player(team_id, name, position, created_at) VALUES(1, '홍민기', '투수','2001-07-20');
INSERT INTO player(team_id, name, position, created_at) VALUES(1, '박명현', '1루수','2001-06-16');
INSERT INTO player(team_id, name, position, created_at) VALUES(1, '김진욱', '지명타자','2002-07-05');
INSERT INTO player(team_id, name, position, created_at) VALUES(1, '한현희', '포수','1993-06-25');
INSERT INTO player(team_id, name, position, created_at) VALUES(1, '최준용', '좌익수','2001-10-10');
INSERT INTO player(team_id, name, position, created_at) VALUES(1, '김강현', '중견수','1999-04-21');
INSERT INTO player(team_id, name, position, created_at) VALUES(1, '박세웅', '우익수','2005-07-21');

-- 선수 테이블(sk와이번스) 데이터 입력
INSERT INTO player(team_id, name, position, created_at) VALUES(2, '정성곤', '3루수','1992-10-02');
INSERT INTO player(team_id, name, position, created_at) VALUES(2, '김주온', '유격수','1996-12-08');
INSERT INTO player(team_id, name, position, created_at) VALUES(2, '고효준', '투수','1995-02-13');
INSERT INTO player(team_id, name, position, created_at) VALUES(2, '이건욱', '1루수','1997-03-14');
INSERT INTO player(team_id, name, position, created_at) VALUES(2, '서동민', '지명타자','1994-03-07');
INSERT INTO player(team_id, name, position, created_at) VALUES(2, '김주한', '포수','1993-02-03');
INSERT INTO player(team_id, name, position, created_at) VALUES(2, '서진용', '좌익수','1992-10-02');
INSERT INTO player(team_id, name, position, created_at) VALUES(2, '엘리아스', '중견수','1988-08-01');
INSERT INTO player(team_id, name, position, created_at) VALUES(2, '김광현', '우익수','1988-07-22');

-- 선수테이블(NC다이노스) 생성 데이터 입력
INSERT INTO player(team_id, name, position, created_at) VALUES(3, '심창민', '3루수','1998-03-21');
INSERT INTO player(team_id, name, position, created_at) VALUES(3, '정주영', '유격수','2004-06-08');
INSERT INTO player(team_id, name, position, created_at) VALUES(3, '서동욱', '투수','2004-02-26');
INSERT INTO player(team_id, name, position, created_at) VALUES(3, '송명기', '1루수','2000-08-09');
INSERT INTO player(team_id, name, position, created_at) VALUES(3, '페디', '지명타자','1993-02-25');
INSERT INTO player(team_id, name, position, created_at) VALUES(3, '전루건', '포수','1993-06-25');
INSERT INTO player(team_id, name, position, created_at) VALUES(3, '김태현', '좌익수','1998-03-21');
INSERT INTO player(team_id, name, position, created_at) VALUES(3, '김영규', '중견수','2000-09-12');
INSERT INTO player(team_id, name, position, created_at) VALUES(3, '신영우', '우익수','2004-04-21');


-- 퇴출 선수 테이블 데이터 입력
INSERT INTO out_player(player_id, reason, created_at) VALUES(4, '원정도박', '2014-01-14');
INSERT INTO out_player(player_id, reason, created_at) VALUES(6, '음주운전', '2018-02-24');
INSERT INTO out_player(player_id, reason, created_at) VALUES(10, '사기', '2020-03-09');
INSERT INTO out_player(player_id, reason, created_at) VALUES(14, '약물사용', '2021-04-01');
INSERT INTO out_player(player_id, reason, created_at) VALUES(18, '협박', '2022-05-29');
INSERT INTO out_player(player_id, reason, created_at) VALUES(22, '약물사용', '2023-11-10');

-- 3.4 전체 팀 목록
select
tm.name '구단명',
sm.name '경기장'
from team tm
left outer join stadium sm on tm.id = sm.id;


-- 3.8 선수 퇴출 목록 생성
select 
pr.id p_id,
pr.name p_name,
pr.position p_position,
op.reason o_reason,
op.created_at o_day
from player pr
left outer join out_player op on op.player_id = pr.id;

-- 3.10 포지션별 팀 야구 선수 페이지
select 
pr.position '포지션',
MAX(if(tm.id = 1, pr.name, null)) '롯데',
MAX(if(tm.id = 2, pr.name, null)) 'SK',
MAX(if(tm.id = 3, pr.name, null)) 'NC'
from player pr
left outer join team tm on pr.team_id = tm.id
group by pr.position;
```
