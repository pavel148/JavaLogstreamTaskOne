CREATE TABLE Book (
    isbn VARCHAR(20) PRIMARY KEY,
    title VARCHAR(255)
);


insert into book(isbn,title )  values ('123567891782', 'War and Peace')
insert into book(isbn,title )  values ('121567191781', 'Crime and Punishment')
insert into book(isbn,title ) values('125567591751', 'The Master and Margarita')

SELECT * FROM book;