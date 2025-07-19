CREATE TABLE pessoa (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    ativo BOOLEAN NOT NULL,
    logradouro VARCHAR(50) NOT NULL,
    numero VARCHAR(10) NOT NULL,
    complemento  VARCHAR(50) NOT NULL,
    bairro VARCHAR(50) NOT NULL,
    cep VARCHAR(20) NOT NULL,
    cidade VARCHAR(20) NOT NULL,
    estado VARCHAR(20) NOT NULL
);


insert into pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) values ('Dollll', TRUE, '5354 Harbort Lane', '66010', '6984 Texas Center', '0 Heffernan Junction', '59536127', 'Memphis', 'Tennessee');
insert into pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) values ('Orion', TRUE, '2 Packers Terrace', '6', '690 Chive Court', '11475 Cottonwood Street', '63079295', 'Suffolk', 'Virginia');
insert into pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) values ('Prince', FALSE, '984 Hovde Crossing', '1', '89557 Mariners Cove Trail', '50330 Gateway Place', '32471022', 'Albuquerque', 'New Mexico');
insert into pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) values ('Killie', TRUE, '14761 Oneill Place', '73999', '1051 Westridge Crossing', '063 Doe Crossing Drive', '14367474', 'Tulsa', 'Oklahoma');
insert into pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) values ('Germana', FALSE, '009 Ludington Place', '3962', '71 Oriole Hill', '7 Sundown Road', '45754324', 'Amarillo', 'Texas');
insert into pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) values ('Dionis', FALSE, '536 Golf Point', '75', '24270 Transport Alley', '50528 Mcbride Lane', '19542429', 'Louisville', 'Kentucky');
insert into pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) values ('Tani', TRUE, '040 Summerview Hill', '707', '88769 Packers Crossing', '48 Haas Park', '38283339', 'Petaluma', 'California');
insert into pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) values ('Abran', FALSE, '926 Vera Junction', '64', '2 Brentwood Junction', '4246 Bunker Hill Street', '70679069', 'Los Angeles', 'California');
insert into pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) values ('Wendel', TRUE, '0707 Goodland Street', '2', '4 Basil Junction', '232 Ridge Oak Road', '13001813', 'Houston', 'Texas');
insert into pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) values ('Beatrice', FALSE, '19 Beilfuss Crossing', '034', '27770 Ridgeway Terrace', '78057 Havey Point', '30285690', 'Columbus', 'Ohio');
