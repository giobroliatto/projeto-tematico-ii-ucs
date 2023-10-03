<<<<<<< Updated upstream
CREATE TABLE equipes (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL
);

CREATE TABLE eventos (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    local VARCHAR(100),
    dataInicio DATE,
	dataFim DATE,
    esporte VARCHAR(50)
=======
-- Tabela "esporte"
CREATE TABLE esporte (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL
);

-- Tabela "evento"
CREATE TABLE evento (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL
>>>>>>> Stashed changes
);

-- Tabela "esporte_evento" 
CREATE TABLE esporte_evento (
    id SERIAL PRIMARY KEY,
<<<<<<< Updated upstream
    idEquipe INT,
    idEvento INT,
    dataInicio DATE,
    dataFim DATE,
    FOREIGN KEY (idEquipe) REFERENCES equipes(id),
    FOREIGN KEY (idEvento) REFERENCES eventos(id)
);

CREATE TABLE chaves (
    id SERIAL PRIMARY KEY,
    idEvento INT NOT NULL,
    idPartida1Oitavas INT,
    idPartida2Oitavas INT,
    idPartida3Oitavas INT,
    idPartida4Oitavas INT,
    idPartida5Oitavas INT,
    idPartida6Oitavas INT,
    idPartida7Oitavas INT,
    idPartida8Oitavas INT,
    idPartida1Quartas INT,
    idPartida2Quartas INT,
    idPartida3Quartas INT,
    idPartida4Quartas INT,
    idPartida1Semi INT,
    idPartida2Semi INT,
    idPartidaFinal INT,
	FOREIGN KEY (idEvento) REFERENCES eventos(id)
);

CREATE TABLE partidas (
    id SERIAL PRIMARY KEY,
    idEvento INT,
    idEquipeA INT,
    idEquipeB INT,
	placarEquipeA INT,
    placarEquipeB INT,
    FOREIGN KEY (idEvento) REFERENCES eventos(id),
    FOREIGN KEY (idEquipeA) REFERENCES equipes(id),
    FOREIGN KEY (idEquipeB) REFERENCES equipes(id)
);

INSERT INTO equipes (nome) VALUES
    ('Os Leões'),
    ('Os Tigres'),
    ('As Águias'),
    ('Os Lobos'),
    ('Os Dragões'),
    ('As Serpentes'),
    ('Os Falcões'),
    ('As Panteras'),
    ('Os Tubarões'),
    ('As Cobras'),
    ('Os Ursos'),
    ('As Águias Reais'),
    ('Os Cavalos Selvagens'),
    ('Os Golfinhos'),
    ('As Orcas'),
    ('Os Elefantes');
	
INSERT INTO eventos (nome, local, dataInicio, dataFim, esporte) VALUES
    ('Evento Oitavas', 'Estádio A', '2023-10-10', '2023-10-15', 'Futebol'),
    ('Evento Quartas', 'Arena B', '2023-10-16', '2023-10-20', 'Basquetebol'),
    ('Evento Semi', 'Quadra C', '2023-10-21', '2023-10-25', 'Vôlei'),
    ('Evento Final', 'Ginásio D', '2023-10-26', '2023-10-30', 'Tênis de Mesa');

INSERT INTO equipes_eventos (idEquipe, idEvento, dataInicio, dataFim) VALUES
    (1, 1, '2023-10-10', '2023-10-15'),
    (2, 1, '2023-10-10', '2023-10-15'),
    (3, 1, '2023-10-10', '2023-10-15'),
    (4, 1, '2023-10-10', '2023-10-15'),
    (5, 1, '2023-10-10', '2023-10-15'),
    (6, 1, '2023-10-10', '2023-10-15'),
    (7, 1, '2023-10-10', '2023-10-15'),
    (8, 1, '2023-10-10', '2023-10-15'),
    (9, 1, '2023-10-10', '2023-10-15'),
    (10, 1, '2023-10-10', '2023-10-15'),
    (11, 1, '2023-10-10', '2023-10-15'),
    (12, 1, '2023-10-10', '2023-10-15'),
    (13, 1, '2023-10-10', '2023-10-15'),
    (14, 1, '2023-10-10', '2023-10-15'),
    (15, 1, '2023-10-10', '2023-10-15'),
    (16, 1, '2023-10-10', '2023-10-15');

INSERT INTO equipes_eventos (idEquipe, idEvento, dataInicio, dataFim) VALUES
    (1, 2, '2023-10-16', '2023-10-20'),
    (2, 2, '2023-10-16', '2023-10-20'),
    (3, 2, '2023-10-16', '2023-10-20'),
    (4, 2, '2023-10-16', '2023-10-20'),
    (5, 2, '2023-10-16', '2023-10-20'),
    (6, 2, '2023-10-16', '2023-10-20'),
    (7, 2, '2023-10-16', '2023-10-20'),
    (8, 2, '2023-10-16', '2023-10-20');

INSERT INTO equipes_eventos (idEquipe, idEvento, dataInicio, dataFim) VALUES
    (1, 3, '2023-10-21', '2023-10-25'),
    (2, 3, '2023-10-21', '2023-10-25'),
    (3, 3, '2023-10-21', '2023-10-25'),
    (4, 3, '2023-10-21', '2023-10-25');

INSERT INTO equipes_eventos (idEquipe, idEvento, dataInicio, dataFim) VALUES
    (1, 4, '2023-10-26', '2023-10-30'),
    (2, 4, '2023-10-26', '2023-10-30');

select * from eventos;

select * from equipes;

select * from equipes_eventos;

select * from partidas;

select * from chaves;

drop table equipes_eventos;
drop table partidas;
drop table chaves;
drop table equipes;
drop table eventos;
=======
    esporte_id INT REFERENCES esporte(id),
    evento_id INT REFERENCES evento(id)
);

INSERT INTO esporte (nome) VALUES
    ('Futebol'),
    ('Basquete'),
    ('Vôlei');

INSERT INTO evento (nome) VALUES
    ('Copa do Mundo'),
    ('Olimpíadas'),
    ('Final de Basquete');

INSERT INTO esporte_evento (esporte_id, evento_id) VALUES
    (1, 1),  
    (2, 1), 
    (2, 3),  
    (3, 2);
>>>>>>> Stashed changes
