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
    idPartidasOitavas INT[] DEFAULT '{}'::INT[],
    idPartidasQuartas INT[] DEFAULT '{}'::INT[],
    idPartidasSemi INT[] DEFAULT '{}'::INT[],
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
    ('Equipe F');

select * from eventos;

select * from equipes;

select * from equipes_eventos;