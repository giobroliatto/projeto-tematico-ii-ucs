CREATE TABLE eventos (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    local VARCHAR(255),
    datainicio DATE,
    esporte VARCHAR(255)
);

CREATE TABLE equipes (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    eventoid INT,
    FOREIGN KEY (eventoid) REFERENCES eventos(id)
);

select * from eventos

select * from equipes