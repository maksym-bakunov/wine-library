--liquibase formatted sql
--changeset Maksym:1
INSERT  INTO  users  (login, status, created, updated)  VALUES  ('GUEST',1,curdate(), curdate());

INSERT  INTO  countries  (name, status, created, updated)  VALUES  ('Австралія',1,curdate(), curdate());
INSERT  INTO  countries  (name, status, created, updated)  VALUES  ('Іспанія',1,curdate(), curdate());
INSERT  INTO  countries  (name, status, created, updated)  VALUES  ('Італія',1,curdate(), curdate());
INSERT  INTO  countries  (name, status, created, updated)  VALUES  ('Німечина',1,curdate(), curdate());
INSERT  INTO  countries  (name, status, created, updated)  VALUES  ('Франція',1,curdate(), curdate());
INSERT  INTO  countries  (name, status, created, updated)  VALUES  ('Чилі',1,curdate(), curdate());

INSERT  INTO  regions  (name, country_id, status, created, updated)  VALUES  ('Новий Південний Уельс. Ріверіна',1,1,curdate(), curdate());
INSERT  INTO  regions  (name, country_id, status, created, updated)  VALUES  ('Ріоха',2,1,curdate(), curdate());
INSERT  INTO  regions  (name, country_id, status, created, updated)  VALUES  ('Каталонія',2,1,curdate(), curdate());
INSERT  INTO  regions  (name, country_id, status, created, updated)  VALUES  ('Венето',3,1,curdate(), curdate());
INSERT  INTO  regions  (name, country_id, status, created, updated)  VALUES  ('Марке',3,1,curdate(), curdate());
INSERT  INTO  regions  (name, country_id, status, created, updated)  VALUES  ('Бордо',5,1,curdate(), curdate());
INSERT  INTO  regions  (name, country_id, status, created, updated)  VALUES  ('Лангедок Руссільон',5,1,curdate(), curdate());
INSERT  INTO  regions  (name, country_id, status, created, updated)  VALUES  ('Прованс',5,1,curdate(), curdate());
INSERT  INTO  regions  (name, country_id, status, created, updated)  VALUES  ('Долина Лейда',6,1,curdate(), curdate());
INSERT  INTO  regions  (name, country_id, status, created, updated)  VALUES  ('Центральна долина',5,1,curdate(), curdate());
INSERT  INTO  regions  (name, country_id, status, created, updated)  VALUES  ('Сицилія',3,1,curdate(), curdate());
INSERT  INTO  regions  (name, country_id, status, created, updated)  VALUES  ('П''ємонт',3,1,curdate(), curdate());
INSERT  INTO  regions  (name, country_id, status, created, updated)  VALUES  ('Ельзас',5,1,curdate(), curdate());
INSERT  INTO  regions  (name, country_id, status, created, updated)  VALUES  ('Мозель',4,1,curdate(), curdate());

INSERT  INTO  colors  (name, status, created, updated)  VALUES  ('Біле',1,curdate(), curdate());
INSERT  INTO  colors  (name, status, created, updated)  VALUES  ('Червоне',1,curdate(), curdate());
INSERT  INTO  colors  (name, status, created, updated)  VALUES  ('Рожеве',1,curdate(), curdate());

INSERT  INTO  sweetness  (name, status, created, updated)  VALUES  ('Сухе',1,curdate(), curdate());
INSERT  INTO  sweetness  (name, status, created, updated)  VALUES  ('Солодке',1,curdate(), curdate());
INSERT  INTO  sweetness  (name, status, created, updated)  VALUES  ('Рожеве',1,curdate(), curdate());

INSERT  INTO  manufacturers  (name, status, created, updated)  VALUES  ('Calabria Family Wines',1,curdate(), curdate());
INSERT  INTO  manufacturers  (name, status, created, updated)  VALUES  ('Castillo Perelada',1,curdate(), curdate());
INSERT  INTO  manufacturers  (name, status, created, updated)  VALUES  ('Chateau La Negly',1,curdate(), curdate());
INSERT  INTO  manufacturers  (name, status, created, updated)  VALUES  ('ColleStefano',1,curdate(), curdate());
INSERT  INTO  manufacturers  (name, status, created, updated)  VALUES  ('Duca di Salaparuta',1,curdate(), curdate());
INSERT  INTO  manufacturers  (name, status, created, updated)  VALUES  ('Ferragu',1,curdate(), curdate());
INSERT  INTO  manufacturers  (name, status, created, updated)  VALUES  ('Fleury Wins',1,curdate(), curdate());
INSERT  INTO  manufacturers  (name, status, created, updated)  VALUES  ('Fontanafredda',1,curdate(), curdate());
INSERT  INTO  manufacturers  (name, status, created, updated)  VALUES  ('Heymann Löwenstein',1,curdate(), curdate());
INSERT  INTO  manufacturers  (name, status, created, updated)  VALUES  ('Leon Beyer',1,curdate(), curdate());
INSERT  INTO  manufacturers  (name, status, created, updated)  VALUES  ('Marques de Vargas',1,curdate(), curdate());
INSERT  INTO  manufacturers  (name, status, created, updated)  VALUES  ('Redentore',1,curdate(), curdate());
INSERT  INTO  manufacturers  (name, status, created, updated)  VALUES  ('Tutiac',1,curdate(), curdate());
INSERT  INTO  manufacturers  (name, status, created, updated)  VALUES  ('Undurraga',1,curdate(), curdate());
INSERT  INTO  manufacturers  (name, status, created, updated)  VALUES  ('Domaime de Rimauresq',1,curdate(), curdate());

INSERT  INTO  sorts  (name, status, created, updated)  VALUES  ('Каберне Фран',1,curdate(), curdate());
INSERT  INTO  sorts  (name, status, created, updated)  VALUES  ('Каріньян',1,curdate(), curdate());
INSERT  INTO  sorts  (name, status, created, updated)  VALUES  ('Сіра',1,curdate(), curdate());
INSERT  INTO  sorts  (name, status, created, updated)  VALUES  ('Темпранильо',1,curdate(), curdate());
INSERT  INTO  sorts  (name, status, created, updated)  VALUES  ('Бароло',1,curdate(), curdate());
INSERT  INTO  sorts  (name, status, created, updated)  VALUES  ('Гарнача',1,curdate(), curdate());
INSERT  INTO  sorts  (name, status, created, updated)  VALUES  ('Гевюрцтраминер',1,curdate(), curdate());
INSERT  INTO  sorts  (name, status, created, updated)  VALUES  ('Гренаш',1,curdate(), curdate());
INSERT  INTO  sorts  (name, status, created, updated)  VALUES  ('Каберне Совіньон',1,curdate(), curdate());
INSERT  INTO  sorts  (name, status, created, updated)  VALUES  ('Корвина',1,curdate(), curdate());
INSERT  INTO  sorts  (name, status, created, updated)  VALUES  ('Мальбек',1,curdate(), curdate());
INSERT  INTO  sorts  (name, status, created, updated)  VALUES  ('Мацуело',1,curdate(), curdate());
INSERT  INTO  sorts  (name, status, created, updated)  VALUES  ('Мурведр',1,curdate(), curdate());
INSERT  INTO  sorts  (name, status, created, updated)  VALUES  ('Негра',1,curdate(), curdate());
INSERT  INTO  sorts  (name, status, created, updated)  VALUES  ('Рислинг',1,curdate(), curdate());
INSERT  INTO  sorts  (name, status, created, updated)  VALUES  ('Совіньон Блан',1,curdate(), curdate());
INSERT  INTO  sorts  (name, status, created, updated)  VALUES  ('Шардоне',1,curdate(), curdate());

INSERT  INTO  payment_types  (name, status, created, updated)  VALUES  ('Готівкою при отриманні',1,curdate(), curdate());
INSERT  INTO  payment_types  (name, status, created, updated)  VALUES  ('Оплата карткою',1,curdate(), curdate());

INSERT  INTO  delivery_types  (name, status, created, updated)  VALUES  ('Самовивіз',1,curdate(), curdate());
INSERT  INTO  delivery_types  (name, status, created, updated)  VALUES  ('По Києву та області',1,curdate(), curdate());
INSERT  INTO  delivery_types  (name, status, created, updated)  VALUES  ('Нова Пошта',1,curdate(), curdate());

INSERT  INTO  wines  (name, color_id, sort_id, country_id, region_id, manufacturer_id, price, volume,
                      year, sweetness_id, rang, discount, composition, description, picture_id, status, created, updated)
VALUES  ('Leonard Road Chardonnay',1,17,1,1,1,380,0.75,2021,1,4,5,NULL,'Аромат: фруктовий з нотами персика і цитрусових. смак: інтенсивний з відтінками персика і цитруса, які забезпечують багату, м''яку текстуру і збалансовану кислотність',1,1,curdate(), curdate());


INSERT  INTO  wines  (name, color_id, sort_id, country_id, region_id, manufacturer_id, price, volume,
                      year, sweetness_id, rang, discount, composition, description, picture_id, status, created, updated)
VALUES  ('Marques de Vargas Reserva',2,6,2,2,11,2800,1.5,2020,1,5,NULL,NULL,'Аромат: складно насичений аромат вишні, червоной сливи і сухий троянди з нотами какао-бобів. смак: яскравий, добре збалансований, стиглий з хорошою структурою і шовковистим танінами',2,1,curdate(), curdate());

INSERT  INTO  wines  (name, color_id, sort_id, country_id, region_id, manufacturer_id, price, volume,
                      year, sweetness_id, rang, discount, composition, description, picture_id, status, created, updated)
VALUES  ('Masia Perelada Rosado',3,4,3,3,2,420,0.75,2017,1,4,NULL,NULL,'Аромат: червоних фруктів, з квітковими нотами. смак: свіжий, обволікає, ніжний, з приємним післясмаком',3,1,curdate(), curdate());


INSERT  INTO  wines  (name, color_id, sort_id, country_id, region_id, manufacturer_id, price, volume,
                      year, sweetness_id, rang, discount, composition, description, picture_id, status, created, updated)
VALUES  ('Redentore Sauvignon Blanc',1,16,3,4,12,480,0.75,2021,1,4,10,NULL,'Аромат: складний з нотами жасмину, персика і м''яти. смак: яскравий з чудовою кислотністю, пікантним післясмаком і збалансованою мінеральністю.',4,1,curdate(), curdate());

INSERT  INTO  wines  (name, color_id, sort_id, country_id, region_id, manufacturer_id, price, volume,
                      year, sweetness_id, rang, discount, composition, description, picture_id, status, created, updated)
VALUES  ('Rosa di Elena',3,16,3,5,4,660,0.75,2019,1,5,NULL,NULL,'Аромат: червоних ягід з нотками зеленого перцю. смак: легке, свіже вино з хорошою кислотністю і соковитим ягідним післясмаком.',5,1,curdate(), curdate());

INSERT  INTO  wines  (name, color_id, sort_id, country_id, region_id, manufacturer_id, price, volume,
                      year, sweetness_id, rang, discount, composition, description, picture_id, status, created, updated)
VALUES  ('Bordeaux Blanc',1,16,5,6,13,380,0.75,2020,1,5,NULL,NULL,'Аромат: виразний і типовий для совіньйон Ѓлан з нотами самшиту, цитрусових і грейпфрута. смак: округлий з нотами грейпфрута, лайма, лічі та мараку». вино демонструє приємну свіжість і стійкий післясмак',6,1,curdate(), curdate());


INSERT  INTO  wines  (name, color_id, sort_id, country_id, region_id, manufacturer_id, price, volume,
                      year, sweetness_id, rang, discount, composition, description, picture_id, status, created, updated)
VALUES  ('Chateau Tour de Buch',2,11,5,6,7,480,0.75,2010,1,5,15,NULL,'Аромат: насичений з елегантними нотками підсмаженого хліба і пряними відтінками каберне. смак: добре збалансоване, зріле вино зі стиглими, округлими танінами і фруктовими нотками.',7,1,curdate(), curdate());


INSERT  INTO  wines  (name, color_id, sort_id, country_id, region_id, manufacturer_id, price, volume,
                      year, sweetness_id, rang, discount, composition, description, picture_id, status, created, updated)
VALUES  ('La Falaise',2,13,5,7,3,2100,0.75,2018,1,5,NULL,NULL,' Аромат: малини і ожини з нотами шоколаду і чорних оливок, лакриці і смажено» кави. смак: насичений, щільний з відтінками червоних ягід і стиглими танінами',8,1,curdate(), curdate());


INSERT  INTO  wines  (name, color_id, sort_id, country_id, region_id, manufacturer_id, price, volume,
                      year, sweetness_id, rang, discount, composition, description, picture_id, status, created, updated)
VALUES  ('Les Terrasses Rose',3,11,5,7,3,540,0.75,2019,1,4,NULL,NULL,'Аромат: дуже ніжний, ягідний з вершковими нотками. смак: Ћкруглий з легкої кислотністю і приємними ягідним післясмаком',9,1,curdate(), curdate());

INSERT  INTO  wines  (name, color_id, sort_id, country_id, region_id, manufacturer_id, price, volume,
                      year, sweetness_id, rang, discount, composition, description, picture_id, status, created, updated)
VALUES  ('Rose Classique Cru Classe',3,8,5,8,15,1120,0.75,2019,1,5,NULL,NULL,'Аромат: білого персика, дині і малини з цитрусовими нотами. смак: м''який, соковитий з відтінками полуниці, нектарина і апельсина, які поступово посилюються за допомогою аераці»',10,1,curdate(), curdate());

INSERT  INTO  wines  (name, color_id, sort_id, country_id, region_id, manufacturer_id, price, volume,
                      year, sweetness_id, rang, discount, composition, description, picture_id, status, created, updated)
VALUES  ('Sibaris Chardonnay Gran Reserva',1,11,6,9,14,700,0.75,2017,1,4,NULL,NULL,'Аромат: свіжий, тонкий з нотками цитрусових, груші, білого персика і меду. смак: мінеральний з добре збалансованою кислотністю',11,1,curdate(), curdate());

INSERT  INTO  wines  (name, color_id, sort_id, country_id, region_id, manufacturer_id, price, volume,
                      year, sweetness_id, rang, discount, composition, description, picture_id, status, created, updated)
VALUES  ('Gewurztraminer',1,7,6,10,14,360,0.75,2018,1,4,NULL,NULL,'Аромат: елегантний і свіжий з відтінками троянди, стиглих фруктів, лічі, персика. смак: яскравий, пряний, квітковий з довгим післясмаком',12,1,curdate(), curdate());


INSERT  INTO  wines  (name, color_id, sort_id, country_id, region_id, manufacturer_id, price, volume,
                      year, sweetness_id, rang, discount, composition, description, picture_id, status, created, updated)
VALUES  ('Sauvignon Blanc',1,16,6,10,14,560,0.75,2018,1,4,25,NULL,'Аромат: фруктовий з квітковими нотами. смак: свіжий і сухий',13,1,curdate(), curdate());


INSERT  INTO  wines  (name, color_id, sort_id, country_id, region_id, manufacturer_id, price, volume,
                      year, sweetness_id, rang, discount, composition, description, picture_id, status, created, updated)
VALUES  ('Cabernet Sauvignon',2,9,6,10,14,360,0.75,2018,1,4,NULL,NULL,'Аромат: букет із зрілих червоних ягід. смак: дуже м''який, з правильною кількістю танінів і нотами диких ягід',14,1,curdate(), curdate());


INSERT  INTO  wines  (name, color_id, sort_id, country_id, region_id, manufacturer_id, price, volume,
                      year, sweetness_id, rang, discount, composition, description, picture_id, status, created, updated)
VALUES  ('Passito Rosso Terre della Sorte',2,10,3,4,6,2820,0.75,2015,2,5,NULL,10,'Аромат: вишневого варення з п''яними і пряними нотками. смак: яскраве десертне вино з інтенсивними відтінками вишневого джему, але в якому присутній прекрасний баланс кислотності',15,1,curdate(), curdate());

INSERT  INTO  wines  (name, color_id, sort_id, country_id, region_id, manufacturer_id, price, volume,
                      year, sweetness_id, rang, discount, composition, description, picture_id, status, created, updated)
VALUES  ('Marsala Vecchio Dolce Superiore',1,11,3,11,5,660,0.75,2015,2,5,NULL,NULL,'Витримується марсала мінімум 30 місяців в дубових бочках різного об''єму. Після бутилювання вино дозріває не менше 3 місяців в прохолодному приміщенні. смак: ссмак: солодкий, теплий, багатий c приємним відтінком гіркого мигдалю і висушеного винограду',16,1,curdate(), curdate());


INSERT  INTO  wines  (name, color_id, sort_id, country_id, region_id, manufacturer_id, price, volume,
                      year, sweetness_id, rang, discount, composition, description, picture_id, status, created, updated)
VALUES  ('Barolo Chinato',2,5,3,12,8,2040,0.5,2017,2,5,NULL,NULL,'Аромат: інтенсивний, складний з відтінками кориці, гвоздики, мускатного горіха і ароматичних трав. Смак: складний, обволікає, ніжний, з приємним післясмаком',17,1,curdate(), curdate());


INSERT  INTO  wines  (name, color_id, sort_id, country_id, region_id, manufacturer_id, price, volume,
                      year, sweetness_id, rang, discount, composition, description, picture_id, status, created, updated)
VALUES  ('Quintessence Rose',3,8,5,8,15,1320,0.75,2015,1,5,20,NULL,'Аромат: дуже тонкий з нотами персика, квітів і солодки. смак: елегантне вино з шовковистою текстурою.',18,1,curdate(), curdate());

INSERT  INTO  wines  (name, color_id, sort_id, country_id, region_id, manufacturer_id, price, volume,
                      year, sweetness_id, rang, discount, composition, description, picture_id, status, created, updated)
VALUES  ('Gewurztraminer Vendange Tardive',1,7,5,13,10,3392,0.75,1998,3,5,NULL,NULL,'Аромат: насичений з нотами троянди, перцю, імбиру, меду, бджолиного воску, лічі, манго та ананасу. смак: насичений, солодкий, потужний, маслянистий, з гарною структурою та довгим медово-абрикосовим післясмаком',19,1,curdate(), curdate());

INSERT  INTO  wines  (name, color_id, sort_id, country_id, region_id, manufacturer_id, price, volume,
                      year, sweetness_id, rang, discount, composition, description, picture_id, status, created, updated)
VALUES  ('Schieferterrassen',1,15,4,14,9,1280,0.75,2016,1,5,NULL,NULL,'Аромат: букет з нотками білих квітів, молодої трави, сіна, диму. смак: в смаку відчувається чиста мінеральність з фруктовими відтінками грейпфрута і яблука',20,1,curdate(), curdate());

INSERT  INTO  wines  (name, color_id, sort_id, country_id, region_id, manufacturer_id, price, volume,
                      year, sweetness_id, rang, discount, composition, description, picture_id, status, created, updated)
VALUES  ('Uhlen Laubach',1,15,4,14,9,3160,0.75,2016,1,5,NULL,NULL,'Аромат: дині, квітів, фенхеля, шавлії з натяками на мед, фрукти і мінеральність. смак: інтенсивний злегка солоний, щільний і витончений, багатий, округлий і добре збалансований',21,1,curdate(), curdate());

INSERT  INTO  dish_categories  (name, status, created, updated)  VALUES  ('Салати',1,curdate(), curdate());
INSERT  INTO  dish_categories  (name, status, created, updated)  VALUES  ('Морепродукти',1,curdate(), curdate());
INSERT  INTO  dish_categories  (name, status, created, updated)  VALUES  ('Різотто',1,curdate(), curdate());
INSERT  INTO  dish_categories  (name, status, created, updated)  VALUES  ('Паста',1,curdate(), curdate());

INSERT  INTO  dishes  (name, dish_category_id, status, created, updated)  VALUES  ('Мясний',1,1,curdate(), curdate());
INSERT  INTO  dishes  (name, dish_category_id, status, created, updated)  VALUES  ('Овочевий',1,1,curdate(), curdate());
INSERT  INTO  dishes  (name, dish_category_id, status, created, updated)  VALUES  ('З морепродуктами',1,1,curdate(), curdate());
INSERT  INTO  dishes  (name, dish_category_id, status, created, updated)  VALUES  ('Гребінці',2,1,curdate(), curdate());
INSERT  INTO  dishes  (name, dish_category_id, status, created, updated)  VALUES  ('Кальмари',2,1,curdate(), curdate());
INSERT  INTO  dishes  (name, dish_category_id, status, created, updated)  VALUES  ('Креветки',2,1,curdate(), curdate());
INSERT  INTO  dishes  (name, dish_category_id, status, created, updated)  VALUES  ('Мідії',2,1,curdate(), curdate());
INSERT  INTO  dishes  (name, dish_category_id, status, created, updated)  VALUES  ('З овочами',3,1,curdate(), curdate());
INSERT  INTO  dishes  (name, dish_category_id, status, created, updated)  VALUES  ('З морепродуктами',3,1,curdate(), curdate());
INSERT  INTO  dishes  (name, dish_category_id, status, created, updated)  VALUES  ('З вершковим соусом',4,1,curdate(), curdate());
INSERT  INTO  dishes  (name, dish_category_id, status, created, updated)  VALUES  ('З морепродуктами',4,1,curdate(), curdate());

INSERT  INTO wines_dishes  (wine_id, dish_id, status, created, updated)  VALUES  (1,3,1,curdate(), curdate());
INSERT  INTO wines_dishes  (wine_id, dish_id, status, created, updated)  VALUES  (1,4,1,curdate(), curdate());
INSERT  INTO wines_dishes  (wine_id, dish_id, status, created, updated)  VALUES  (1,5,1,curdate(), curdate());
INSERT  INTO wines_dishes  (wine_id, dish_id, status, created, updated)  VALUES  (1,6,1,curdate(), curdate());
INSERT  INTO wines_dishes  (wine_id, dish_id, status, created, updated)  VALUES  (1,7,1,curdate(), curdate());
INSERT  INTO wines_dishes  (wine_id, dish_id, status, created, updated)  VALUES  (1,8,1,curdate(), curdate());
INSERT  INTO wines_dishes  (wine_id, dish_id, status, created, updated)  VALUES  (1,9,1,curdate(), curdate());
INSERT  INTO wines_dishes  (wine_id, dish_id, status, created, updated)  VALUES  (1,10,1,curdate(), curdate());
INSERT  INTO wines_dishes  (wine_id, dish_id, status, created, updated)  VALUES  (1,11,1,curdate(), curdate());
INSERT  INTO wines_dishes  (wine_id, dish_id, status, created, updated)  VALUES  (2,1,1,curdate(), curdate());
INSERT  INTO wines_dishes  (wine_id, dish_id, status, created, updated)  VALUES  (2,2,1,curdate(), curdate());
INSERT  INTO wines_dishes  (wine_id, dish_id, status, created, updated)  VALUES  (3,4,1,curdate(), curdate());
INSERT  INTO wines_dishes  (wine_id, dish_id, status, created, updated)  VALUES  (3,5,1,curdate(), curdate());
INSERT  INTO wines_dishes  (wine_id, dish_id, status, created, updated)  VALUES  (3,6,1,curdate(), curdate());
INSERT  INTO wines_dishes  (wine_id, dish_id, status, created, updated)  VALUES  (3,7,1,curdate(), curdate());
INSERT  INTO wines_dishes  (wine_id, dish_id, status, created, updated)  VALUES  (3,10,1,curdate(), curdate());
INSERT  INTO wines_dishes  (wine_id, dish_id, status, created, updated)  VALUES  (3,11,1,curdate(), curdate());
INSERT  INTO wines_dishes  (wine_id, dish_id, status, created, updated)  VALUES  (4,2,1,curdate(), curdate());
INSERT  INTO wines_dishes  (wine_id, dish_id, status, created, updated)  VALUES  (5,6,1,curdate(), curdate());
INSERT  INTO wines_dishes  (wine_id, dish_id, status, created, updated)  VALUES  (5,8,1,curdate(), curdate());
INSERT  INTO wines_dishes  (wine_id, dish_id, status, created, updated)  VALUES  (6,5,1,curdate(), curdate());
INSERT  INTO wines_dishes  (wine_id, dish_id, status, created, updated)  VALUES  (6,11,1,curdate(), curdate());
INSERT  INTO wines_dishes  (wine_id, dish_id, status, created, updated)  VALUES  (6,9,1,curdate(), curdate());
INSERT  INTO wines_dishes  (wine_id, dish_id, status, created, updated)  VALUES  (7,6,1,curdate(), curdate());
INSERT  INTO wines_dishes  (wine_id, dish_id, status, created, updated)  VALUES  (7,4,1,curdate(), curdate());
INSERT  INTO wines_dishes  (wine_id, dish_id, status, created, updated)  VALUES  (7,3,1,curdate(), curdate());
INSERT  INTO wines_dishes  (wine_id, dish_id, status, created, updated)  VALUES  (8,2,1,curdate(), curdate());
INSERT  INTO wines_dishes  (wine_id, dish_id, status, created, updated)  VALUES  (8,5,1,curdate(), curdate());
INSERT  INTO wines_dishes  (wine_id, dish_id, status, created, updated)  VALUES  (8,11,1,curdate(), curdate());
INSERT  INTO wines_dishes  (wine_id, dish_id, status, created, updated)  VALUES  (9,1,1,curdate(), curdate());
INSERT  INTO wines_dishes  (wine_id, dish_id, status, created, updated)  VALUES  (9,7,1,curdate(), curdate());
INSERT  INTO wines_dishes  (wine_id, dish_id, status, created, updated)  VALUES  (10,8,1,curdate(), curdate());
INSERT  INTO wines_dishes  (wine_id, dish_id, status, created, updated)  VALUES  (10,9,1,curdate(), curdate());
INSERT  INTO wines_dishes  (wine_id, dish_id, status, created, updated)  VALUES  (10,4,1,curdate(), curdate());
INSERT  INTO wines_dishes  (wine_id, dish_id, status, created, updated)  VALUES  (10,3,1,curdate(), curdate());
INSERT  INTO wines_dishes  (wine_id, dish_id, status, created, updated)  VALUES  (11,3,1,curdate(), curdate());
INSERT  INTO wines_dishes  (wine_id, dish_id, status, created, updated)  VALUES  (11,2,1,curdate(), curdate());
INSERT  INTO wines_dishes  (wine_id, dish_id, status, created, updated)  VALUES  (12,1,1,curdate(), curdate());
INSERT  INTO wines_dishes  (wine_id, dish_id, status, created, updated)  VALUES  (12,2,1,curdate(), curdate());
INSERT  INTO wines_dishes  (wine_id, dish_id, status, created, updated)  VALUES  (13,10,1,curdate(), curdate());
INSERT  INTO wines_dishes  (wine_id, dish_id, status, created, updated)  VALUES  (13,11,1,curdate(), curdate());
INSERT  INTO wines_dishes  (wine_id, dish_id, status, created, updated)  VALUES  (14,5,1,curdate(), curdate());
INSERT  INTO wines_dishes  (wine_id, dish_id, status, created, updated)  VALUES  (14,4,1,curdate(), curdate());
INSERT  INTO wines_dishes  (wine_id, dish_id, status, created, updated)  VALUES  (15,5,1,curdate(), curdate());
INSERT  INTO wines_dishes  (wine_id, dish_id, status, created, updated)  VALUES  (15,4,1,curdate(), curdate());
INSERT  INTO wines_dishes  (wine_id, dish_id, status, created, updated)  VALUES  (15,3,1,curdate(), curdate());
INSERT  INTO wines_dishes  (wine_id, dish_id, status, created, updated)  VALUES  (15,6,1,curdate(), curdate());
INSERT  INTO wines_dishes  (wine_id, dish_id, status, created, updated)  VALUES  (16,1,1,curdate(), curdate());
INSERT  INTO wines_dishes  (wine_id, dish_id, status, created, updated)  VALUES  (16,2,1,curdate(), curdate());
INSERT  INTO wines_dishes  (wine_id, dish_id, status, created, updated)  VALUES  (17,4,1,curdate(), curdate());
INSERT  INTO wines_dishes  (wine_id, dish_id, status, created, updated)  VALUES  (17,5,1,curdate(), curdate());
INSERT  INTO wines_dishes  (wine_id, dish_id, status, created, updated)  VALUES  (18,9,1,curdate(), curdate());
INSERT  INTO wines_dishes  (wine_id, dish_id, status, created, updated)  VALUES  (18,10,1,curdate(), curdate());
INSERT  INTO wines_dishes  (wine_id, dish_id, status, created, updated)  VALUES  (19,8,1,curdate(), curdate());
INSERT  INTO wines_dishes  (wine_id, dish_id, status, created, updated)  VALUES  (19,9,1,curdate(), curdate());
INSERT  INTO wines_dishes  (wine_id, dish_id, status, created, updated)  VALUES  (20,11,1,curdate(), curdate());
INSERT  INTO wines_dishes  (wine_id, dish_id, status, created, updated)  VALUES  (20,1,1,curdate(), curdate());
INSERT  INTO wines_dishes  (wine_id, dish_id, status, created, updated)  VALUES  (21,4,1,curdate(), curdate());
INSERT  INTO wines_dishes  (wine_id, dish_id, status, created, updated)  VALUES  (21,5,1,curdate(), curdate());
INSERT  INTO wines_dishes  (wine_id, dish_id, status, created, updated)  VALUES  (21,6,1,curdate(), curdate());
INSERT  INTO wines_dishes  (wine_id, dish_id, status, created, updated)  VALUES  (21,7,1,curdate(), curdate());