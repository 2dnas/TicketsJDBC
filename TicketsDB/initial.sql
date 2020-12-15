CREATE TABLE tickets (
                         id BIGSERIAL PRIMARY KEY,
                         row INT NOT NULL,
                         seat INT NOT NULL,
                         free BOOLEAN DEFAULT false
)
