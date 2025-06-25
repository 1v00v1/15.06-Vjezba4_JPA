insert into type ( name)
values ('GPU'),('CPU'),('STORAGE'),('RAM');

insert into hardware ( code, name,  stock, price, type_id)
    values
        ( '1234561', 'Asus TUF RTX 3080',  0, 1599.00,1),
        ( '1234562', 'EVGA XC3 RTX 3070 Ti',  0, 1299.00,1),
        ( '1234563', 'AMD Ryzen 5950X',  0, 899.00,2),
        ( '1234564', 'Samsung 980 PRO SSD 1TB', 0, 299.00,3),
        ( '1234565', 'Kingston FURY Beast DDR5 32GB',  0, 699.00,4);
