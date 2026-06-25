-- Seed data for tokens table (idempotent)
CREATE TABLE IF NOT EXISTS tokens (
    id BIGSERIAL PRIMARY KEY,
    accountId VARCHAR(40) NOT NULL,
    type VARCHAR(50) NOT NULL,
    duration INTEGER NOT NULL,
    createdAt TIMESTAMP NOT NULL,
    redeemed BOOLEAN NOT NULL,
    redeemedAt TIMESTAMP NOT NULL
);

INSERT INTO tokens (id, accountId, type, duration, createdAt, redeemed, redeemedAt)
VALUES (1, 'f47ac10b-58cc-4372-a567-0e02b2c3d479', 'bronze', 7, '2024-10-15 10:30:00', false, '9999-12-31 23:59:59');

INSERT INTO tokens (id, accountId, type, duration, createdAt, redeemed, redeemedAt)
VALUES (2, '550e8400-e29b-41d4-a716-446655440000', 'gold', 31, '2024-09-20 14:45:00', false, '9999-12-31 23:59:59');

INSERT INTO tokens (id, accountId, type, duration, createdAt, redeemed, redeemedAt)
VALUES (3, '6ba7b810-9dad-11d1-80b4-00c04fd430c8', 'platinum', 126, '2024-08-10 09:15:00', false, '9999-12-31 23:59:59');

INSERT INTO tokens (id, accountId, type, duration, createdAt, redeemed, redeemedAt)
VALUES (4, '6ba7b811-9dad-11d1-80b4-00c04fd430c8', 'diamond', 63, '2024-11-01 16:20:00', false, '9999-12-31 23:59:59');

INSERT INTO tokens (id, accountId, type, duration, createdAt, redeemed, redeemedAt)
VALUES (5, 'f47ac10b-58cc-4372-a567-0e02b2c3d479', 'bronze', 7, '2024-10-25 11:00:00', false, '9999-12-31 23:59:59');

INSERT INTO tokens (id, accountId, type, duration, createdAt, redeemed, redeemedAt)
VALUES (6, '550e8400-e29b-41d4-a716-446655440000', 'gold', 31, '2024-07-18 13:30:00', false, '9999-12-31 23:59:59');

INSERT INTO tokens (id, accountId, type, duration, createdAt, redeemed, redeemedAt)
VALUES (7, '6ba7b810-9dad-11d1-80b4-00c04fd430c8', 'platinum', 126, '2024-06-05 08:45:00', false, '9999-12-31 23:59:59');

INSERT INTO tokens (id, accountId, type, duration, createdAt, redeemed, redeemedAt)
VALUES (8, '6ba7b811-9dad-11d1-80b4-00c04fd430c8', 'bronze', 7, '2024-09-12 15:10:00', false, '9999-12-31 23:59:59');

INSERT INTO tokens (id, accountId, type, duration, createdAt, redeemed, redeemedAt)
VALUES (9, 'f47ac10b-58cc-4372-a567-0e02b2c3d479', 'diamond', 63, '2024-05-22 10:00:00', false, '9999-12-31 23:59:59');

INSERT INTO tokens (id, accountId, type, duration, createdAt, redeemed, redeemedAt)
VALUES (10, '550e8400-e29b-41d4-a716-446655440000', 'platinum', 126, '2024-08-30 12:25:00', false, '9999-12-31 23:59:59');

INSERT INTO tokens (id, accountId, type, duration, createdAt, redeemed, redeemedAt)
VALUES (11, '6ba7b810-9dad-11d1-80b4-00c04fd430c8', 'gold', 31, '2024-10-08 09:50:00', false, '9999-12-31 23:59:59');

INSERT INTO tokens (id, accountId, type, duration, createdAt, redeemed, redeemedAt)
VALUES (12, '6ba7b811-9dad-11d1-80b4-00c04fd430c8', 'bronze', 7, '2024-11-05 14:15:00', false, '9999-12-31 23:59:59');

INSERT INTO tokens (id, accountId, type, duration, createdAt, redeemed, redeemedAt)
VALUES (13, 'f47ac10b-58cc-4372-a567-0e02b2c3d479', 'gold', 31, '2024-07-03 11:40:00', false, '9999-12-31 23:59:59');

INSERT INTO tokens (id, accountId, type, duration, createdAt, redeemed, redeemedAt)
VALUES (14, '550e8400-e29b-41d4-a716-446655440000', 'diamond', 63, '2024-09-28 16:55:00', false, '9999-12-31 23:59:59');

INSERT INTO tokens (id, accountId, type, duration, createdAt, redeemed, redeemedAt)
VALUES (15, '6ba7b810-9dad-11d1-80b4-00c04fd430c8', 'bronze', 7, '2024-10-19 08:20:00', false, '9999-12-31 23:59:59');

INSERT INTO tokens (id, accountId, type, duration, createdAt, redeemed, redeemedAt)
VALUES (16, 'f47ac10b-58cc-4372-a567-0e02b2c3d479', 'master', 365, '2024-10-15 10:30:00', false, '9999-12-31 23:59:59');

INSERT INTO tokens (id, accountId, type, duration, createdAt, redeemed, redeemedAt)
VALUES (17, '550e8400-e29b-41d4-a716-446655440000', 'master', 365, '2024-09-20 14:45:00', false, '9999-12-31 23:59:59');

INSERT INTO tokens (id, accountId, type, duration, createdAt, redeemed, redeemedAt)
VALUES (18, '6ba7b810-9dad-11d1-80b4-00c04fd430c8', 'master', 365, '2024-08-10 09:15:00', false, '9999-12-31 23:59:59');

INSERT INTO tokens (id, accountId, type, duration, createdAt, redeemed, redeemedAt)
VALUES (19, '6ba7b811-9dad-11d1-80b4-00c04fd430c8', 'master', 365, '2024-11-01 16:20:00', false, '9999-12-31 23:59:59');
