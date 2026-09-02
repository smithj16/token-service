-- Seed data for tokens table (idempotent)
CREATE TABLE IF NOT EXISTS tokens (
    id BIGSERIAL PRIMARY KEY,
    accountId VARCHAR(40) NOT NULL,
    transactionId UUID,
    tokentier VARCHAR(50) NOT NULL,
    duration INTEGER NOT NULL,
    createdAt TIMESTAMP NOT NULL,
    redeemed BOOLEAN NOT NULL,
    redeemedAt TIMESTAMP
);

CREATE UNIQUE INDEX IF NOT EXISTS uq_tokens_transaction ON tokens(transactionId);

-- Tokens 1-10 are linked to the seeded transactions (see transaction-service seed data); tokens 11-19 are standalone
INSERT INTO tokens (id, accountId, transactionId, tokentier, duration, createdAt, redeemed, redeemedAt)
VALUES (1, 'f47ac10b-58cc-4372-a567-0e02b2c3d479', 'a1b2c3d4-e5f6-4a7b-8c9d-0e1f2a3b4c5d', 'bronze', 7, '2024-10-15 10:30:00', false, NULL);

INSERT INTO tokens (id, accountId, transactionId, tokentier, duration, createdAt, redeemed, redeemedAt)
VALUES (2, '550e8400-e29b-41d4-a716-446655440000', 'b2c3d4e5-f6a7-4b8c-9d0e-1f2a3b4c5d6e', 'gold', 31, '2024-09-20 14:45:00', false, NULL);

INSERT INTO tokens (id, accountId, transactionId, tokentier, duration, createdAt, redeemed, redeemedAt)
VALUES (3, '6ba7b810-9dad-11d1-80b4-00c04fd430c8', 'c3d4e5f6-a7b8-4c9d-0e1f-2a3b4c5d6e7f', 'platinum', 126, '2024-08-10 09:15:00', false, NULL);

INSERT INTO tokens (id, accountId, transactionId, tokentier, duration, createdAt, redeemed, redeemedAt)
VALUES (4, '6ba7b811-9dad-11d1-80b4-00c04fd430c8', 'd4e5f6a7-b8c9-4d0e-1f2a-3b4c5d6e7f8a', 'diamond', 63, '2024-11-01 16:20:00', false, NULL);

INSERT INTO tokens (id, accountId, transactionId, tokentier, duration, createdAt, redeemed, redeemedAt)
VALUES (5, 'f47ac10b-58cc-4372-a567-0e02b2c3d479', 'e5f6a7b8-c9d0-4e1f-2a3b-4c5d6e7f8a9b', 'bronze', 7, '2024-10-25 11:00:00', false, NULL);

INSERT INTO tokens (id, accountId, transactionId, tokentier, duration, createdAt, redeemed, redeemedAt)
VALUES (6, '550e8400-e29b-41d4-a716-446655440000', 'f6a7b8c9-d0e1-4f2a-3b4c-5d6e7f8a9b0c', 'gold', 31, '2024-07-18 13:30:00', false, NULL);

INSERT INTO tokens (id, accountId, transactionId, tokentier, duration, createdAt, redeemed, redeemedAt)
VALUES (7, '6ba7b810-9dad-11d1-80b4-00c04fd430c8', 'a7b8c9d0-e1f2-4a3b-4c5d-6e7f8a9b0c1d', 'platinum', 126, '2024-06-05 08:45:00', false, NULL);

INSERT INTO tokens (id, accountId, transactionId, tokentier, duration, createdAt, redeemed, redeemedAt)
VALUES (8, '6ba7b811-9dad-11d1-80b4-00c04fd430c8', 'b8c9d0e1-f2a3-4b4c-5d6e-7f8a9b0c1d2e', 'bronze', 7, '2024-09-12 15:10:00', false, NULL);

INSERT INTO tokens (id, accountId, transactionId, tokentier, duration, createdAt, redeemed, redeemedAt)
VALUES (9, 'f47ac10b-58cc-4372-a567-0e02b2c3d479', 'c9d0e1f2-a3b4-4c5d-6e7f-8a9b0c1d2e3f', 'diamond', 63, '2024-05-22 10:00:00', false, NULL);

INSERT INTO tokens (id, accountId, transactionId, tokentier, duration, createdAt, redeemed, redeemedAt)
VALUES (10, '550e8400-e29b-41d4-a716-446655440000', 'd0e1f2a3-b4c5-4d6e-7f8a-9b0c1d2e3f4a', 'platinum', 126, '2024-08-30 12:25:00', false, NULL);

INSERT INTO tokens (id, accountId, transactionId, tokentier, duration, createdAt, redeemed, redeemedAt)
VALUES (11, '6ba7b810-9dad-11d1-80b4-00c04fd430c8', NULL, 'gold', 31, '2024-10-08 09:50:00', false, NULL);

INSERT INTO tokens (id, accountId, transactionId, tokentier, duration, createdAt, redeemed, redeemedAt)
VALUES (12, '6ba7b811-9dad-11d1-80b4-00c04fd430c8', NULL, 'bronze', 7, '2024-11-05 14:15:00', false, NULL);

INSERT INTO tokens (id, accountId, transactionId, tokentier, duration, createdAt, redeemed, redeemedAt)
VALUES (13, 'f47ac10b-58cc-4372-a567-0e02b2c3d479', NULL, 'gold', 31, '2024-07-03 11:40:00', false, NULL);

INSERT INTO tokens (id, accountId, transactionId, tokentier, duration, createdAt, redeemed, redeemedAt)
VALUES (14, '550e8400-e29b-41d4-a716-446655440000', NULL, 'diamond', 63, '2024-09-28 16:55:00', false, NULL);

INSERT INTO tokens (id, accountId, transactionId, tokentier, duration, createdAt, redeemed, redeemedAt)
VALUES (15, '6ba7b810-9dad-11d1-80b4-00c04fd430c8', NULL, 'bronze', 7, '2024-10-19 08:20:00', false, NULL);

INSERT INTO tokens (id, accountId, transactionId, tokentier, duration, createdAt, redeemed, redeemedAt)
VALUES (16, 'f47ac10b-58cc-4372-a567-0e02b2c3d479', NULL, 'master', 365, '2024-10-15 10:30:00', false, NULL);

INSERT INTO tokens (id, accountId, transactionId, tokentier, duration, createdAt, redeemed, redeemedAt)
VALUES (17, '550e8400-e29b-41d4-a716-446655440000', NULL, 'master', 365, '2024-09-20 14:45:00', false, NULL);

INSERT INTO tokens (id, accountId, transactionId, tokentier, duration, createdAt, redeemed, redeemedAt)
VALUES (18, '6ba7b810-9dad-11d1-80b4-00c04fd430c8', NULL, 'master', 365, '2024-08-10 09:15:00', false, NULL);

INSERT INTO tokens (id, accountId, transactionId, tokentier, duration, createdAt, redeemed, redeemedAt)
VALUES (19, '6ba7b811-9dad-11d1-80b4-00c04fd430c8', NULL, 'master', 365, '2024-11-01 16:20:00', false, NULL);
