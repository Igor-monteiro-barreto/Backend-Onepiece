CREATE TABLE marinheiro(
    id SERIAL PRIMARY KEY,
    nome VARCHAR(77) NOT NULL,
    idade INT NOT NULL,
    cargo ENUM('Almirante', 'Vice_Almirante', 'Capitão', 'Recruta',
     'Almirante_de_Frota', 'vice_capitão',
     'Contra_Almirante', 'Aprendiz_de_Marinheiro', 'Tenente') NOT NULL,
    Akumado BOOLEAN NOT NULL
);
CREATE TYPE cargo_enum AS ENUM (
    'Almirante',
    'Vice_Almirante',
    'Capitão',
    'Recruta',
    'Almirante_de_Frota',
    'vice_capitão',
    'Contra_Almirante',
    'Aprendiz_de_Marinheiro',
    'Tenente'
);

ALTER TABLE marinheiros
ALTER COLUMN cargo TYPE cargo_enum
USING cargo::cargo_enum;