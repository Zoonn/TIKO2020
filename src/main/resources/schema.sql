
CREATE TABLE asiakas (
   asiakasid SERIAL,
   nimi VARCHAR (255) NOT NULL,
   puhelinnumero INT,
   sahkoposti VARCHAR (255),
   osoite VARCHAR (255),
   yritys VARCHAR (255),
   PRIMARY KEY(asiakasid)
);

CREATE TABLE sopimus (
   sopimusid SERIAL,
   kuvaus VARCHAR (5000), --kuvaus työkeikasta
  -- kotivahennyskelpoisuus DECIMAL(19, 4), --rahaa (Pystyy varmaankin johtamaan?)
   osoite VARCHAR (255),
   asiakasid INT,
   PRIMARY KEY(sopimusid),
   FOREIGN KEY (asiakasid) REFERENCES asiakas(asiakasid)
);

CREATE TABLE tarvikkeet (
   tarvikeid SERIAL,
   tarvikenimi VARCHAR (255),
   yksikko VARCHAR (255),--kpl (esim. pistorasia) vai metri (esim. sähköjohto)
   mitta DECIMAL (20, 2), --numeerista tietoa yksikölle
   varastotilanne INT, --paljonko kyseistä tarviketta on varastossa
   sisaanottohinta DECIMAL(19, 4), --tarvikkeen hinta ostettaessa -> rahaa
   vero INT DEFAULT (24), --veron määrä tarvikkeelle (yleensä 24 ->prosentti 0-100
   PRIMARY KEY(tarvikeid)
);

CREATE TABLE tarvikeluettelo (
   sopimusid INT,
   tarvikeid INT,
   maara INT, --tarvikkeen määrä työhön
   alennus INT, --alennus tarvikkeesta -> prosentti 0-100
   veroton_hinta DECIMAL(19, 4), --rahaa 
   PRIMARY KEY(sopimusid, tarvikeid),
   FOREIGN KEY (sopimusid) REFERENCES sopimus(sopimusid),
   FOREIGN KEY (tarvikeid) REFERENCES tarvikkeet(tarvikeid)
);
CREATE TABLE tyo (
   tyoid SERIAL,
   tyonnimi VARCHAR (255),
   vero INT DEFAULT 24, --veroprosentti työstä -> prosentti 0-100
   PRIMARY KEY(tyoid)
);

CREATE TABLE tyoluettelo (
   sopimusid INT,
   tyoid INT,
   maara INT,
   alennus INT, --alennusprosentti kyseisestä työstä -> prosentti 0-100
   PRIMARY KEY(sopimusid, tyoid),
   FOREIGN KEY (sopimusid) REFERENCES sopimus(sopimusid),
   FOREIGN KEY (tyoid) REFERENCES tyo(tyoid)
);

CREATE TABLE lasku (
   laskuid SERIAL,
   sopimusid INT,
   paivamaara DATE DEFAULT CURRENT_DATE,
   erapaiva DATE,
   laskutuslisa DECIMAL(19, 4), --rahaa
   tila BOOLEAN, --onko lasku maksettu
   PRIMARY KEY(laskuid),
   FOREIGN KEY (laskuid) REFERENCES lasku(laskuid),
   FOREIGN KEY (sopimusid) REFERENCES sopimus(sopimusid)
);
