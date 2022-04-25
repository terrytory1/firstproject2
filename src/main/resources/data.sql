INSERT INTO article(id, title, content) VALUES (1, '가가가가', '1111');
INSERT INTO article(id, title, content) VALUES (2, '나나나나', '2222');
INSERT INTO article(id, title, content) VALUES (3, '다다다다', '3333');

INSERT INTO article(id, title, content) VALUES (4, '인생 영화', 'ㄱ');
INSERT INTO article(id, title, content) VALUES (5, '소울 푸드', 'ㄱㄱ');
INSERT INTO article(id, title, content) VALUES (6, '취미', 'ㄱㄱㄱ');

INSERT INTO comment(id, article_id, nickname, body) VALUES (1, 4, 'park', '베테랑');
INSERT INTO comment(id, article_id, nickname, body) VALUES (2, 4, 'kim', '변호사');
INSERT INTO comment(id, article_id, nickname, body) VALUES (3, 4, 'lee', '어게인');

INSERT INTO comment(id, article_id, nickname, body) VALUES (4, 5, 'park', '치킨');
INSERT INTO comment(id, article_id, nickname, body) VALUES (5, 5, 'kim', '피자');
INSERT INTO comment(id, article_id, nickname, body) VALUES (6, 5, 'lee', '김밥');

INSERT INTO comment(id, article_id, nickname, body) VALUES (7, 6, 'park', '조깅');
INSERT INTO comment(id, article_id, nickname, body) VALUES (8, 6, 'kim', '유튜브');
INSERT INTO comment(id, article_id, nickname, body) VALUES (9, 6, 'lee', '독서');