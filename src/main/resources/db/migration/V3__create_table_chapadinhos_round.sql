CREATE TABLE chapadinhos_round
(
    id            SERIAL PRIMARY KEY,
    chapadinho_id INTEGER,
    round_id      INTEGER,
    FOREIGN KEY (chapadinho_id) REFERENCES chapadinhos (id),
    FOREIGN KEY (round_id) REFERENCES rounds (id),
    UNIQUE (chapadinho_id, round_id)
);