CREATE TABLE eventos (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    local VARCHAR(255),
    datainicio DATE,
	datafim DATE,
    esporte VARCHAR(255)
);

CREATE TABLE equipes (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
);

CREATE TABLE equipes_eventos (
    id SERIAL PRIMARY KEY,
    equipeid INT,
    eventoid INT,
    datainicio DATE,
    datafim DATE,
    FOREIGN KEY (equipeid) REFERENCES equipes(id),
    FOREIGN KEY (eventoid) REFERENCES eventos(id)
);


INSERT INTO eventos (nome, local, datainicio, datafim, esporte) VALUES
    ('Evento de Futebol', 'Estádio A', '2023-10-01', '2023-11-01', 'Futebol'),
    ('Evento de Basquete', 'Ginásio B', '2023-11-15', '2023-12-15', 'Basquete'),
    ('Evento de Tênis', 'Clube de Tênis C', '2023-12-20', '2023-12-31', 'Tênis');

INSERT INTO equipes (nome, eventoid) VALUES
    ('Equipe A', 1),
    ('Equipe B', 1),
    ('Equipe C', 2),
    ('Equipe D', 2),
    ('Equipe E', 3),
    ('Equipe F', 3);


select * from eventos

select * from equipes

select * from equipes_eventos