insert into asiakas(asiakasid, nimi, puhelinnumero, sahkoposti, osoite, yritys) 
    values(1,'Matti Meikalainen', 0401432001, 'matti.meikalainen@gmail.com', 'Paratiisikatu 2', 'Matti Solutions Oy');

insert into sopimus(sopimusid, kuvaus, osoite, asiakasid) 
    values (1, '2kk sulkisivuremontti', 'Unelmakuja 1', 1);

insert into tarvikkeet(tarvikeid, tarvikenimi, yksikko, mitta, varastotilanne, sisaanottohinta, vero)
    values (1, 'pistorasia', 'kpl', 1, 21, 5.50, 24);

insert into tarvikkeet(tarvikeid, tarvikenimi, yksikko, mitta, varastotilanne, sisaanottohinta, vero)
    values (2, 'sähköjohto', 'm', 1, 300, 10.50, 24);

insert into tarvikeluettelo (sopimusid, tarvikeid, maara, alennus, veroton_hinta) 
    values (1, 1, 1, 0, 15.00);

insert into tarvikeluettelo (sopimusid, tarvikeid, maara, alennus, veroton_hinta) 
    values (1, 2, 3, 0, 30.00);

insert into tyo(tyoid, tyonnimi, vero) 
    values (1, 'Asennustyöt', 24);

insert into tyo(tyoid, tyonnimi, vero) 
    values (2, 'Suunnittelu', 24);

insert into tyoluettelo(sopimusid, tyoid, maara, alennus)
    values (1, 1, 3, 0);

insert into tyoluettelo(sopimusid, tyoid, maara, alennus)
    values (1, 2, 12, 0);

insert into lasku (laskuid, sopimusid, paivamaara, erapaiva, laskutuslisa, tila)
    values (1, 1, '2020-03-20', '2020-05-30', 0, 'false');
