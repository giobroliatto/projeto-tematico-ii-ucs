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
);

CREATE TABLE equipes_eventos (
    id SERIAL PRIMARY KEY,
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

CREATE TABLE resultados (
    id SERIAL PRIMARY KEY,
    placarEquipeA INT,
    placarEquipeB INT,
    idEquipeVencedora INT
);

CREATE TABLE partidas (
    id SERIAL PRIMARY KEY,
    idResultado INT,
    idEvento INT,
    idEquipeA INT,
    idEquipeB INT,
    FOREIGN KEY (idResultado) REFERENCES resultados(id),
    FOREIGN KEY (idEvento) REFERENCES eventos(id),
    FOREIGN KEY (idEquipeA) REFERENCES equipes(id),
    FOREIGN KEY (idEquipeB) REFERENCES equipes(id)
);

INSERT INTO equipes (nome) VALUES
    ('Equipe A'),
    ('Equipe B'),
    ('Equipe C'),
    ('Equipe D'),
    ('Equipe E'),
    ('Equipe F'),
    ('Equipe G'),
    ('Equipe H'),
    ('Equipe I'),
    ('Equipe J'),
    ('Equipe K'),
    ('Equipe L'),
    ('Equipe M'),
    ('Equipe N'),
    ('Equipe O'),
    ('Equipe P');

select * from eventos;

select * from equipes;

select * from equipes_eventos;

select * from partidas;

select * from chaves;
