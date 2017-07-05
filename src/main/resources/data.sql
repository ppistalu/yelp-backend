insert into users(id, email, first_name, last_name, password) values(1,'example@email.com','Petra','Pistalu','password');

insert into restaurants(id, address, email, logo, name, phone, url) values(3,'zurich','rest@email.com','logo','Petra','021','http');

insert into reviews(id, date_created, rating, text,restaurant_id, user_id) values(2,{ts '2017-01-01 00:00:00.00'},2,'great',3,1);
