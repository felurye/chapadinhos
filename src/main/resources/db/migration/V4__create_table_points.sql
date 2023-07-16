CREATE TABLE points
(
    id                  serial PRIMARY KEY,
    point_date          TIMESTAMP,
    chapadinho_round_id INTEGER,
    FOREIGN KEY (chapadinho_round_id) REFERENCES chapadinhos_round(id)
);