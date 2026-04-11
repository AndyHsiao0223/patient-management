-- ============================================================
-- Mock data for 'users' table
-- BCrypt encoded passwords (using default strength 10):
--   'test1234'    => $2a$10$EdownnAIRqDGmFgnRGhmzuXA3JMTQO0kPJBpGFWbMM.LJxJUFGMa
--   'password123' => $2a$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lhWy
-- ============================================================

-- ★ Fixed test user for Postman testing (DO NOT change this row)
INSERT INTO users (id, email, password, role)
VALUES ('e1b2c3d4-5678-9abc-def0-1234567890ab', 'testuser@example.com',
        '$2a$10$EdownnAIRqDGmFgnRGhmzuXA3JMTQO0kPJBpGFWbMM.LJxJUFGMa', 'ADMIN')
ON CONFLICT (id) DO NOTHING;

-- Random mock users
INSERT INTO users (id, email, password, role)
VALUES ('a1b2c3d4-0001-4bbb-aaaa-000000000001', 'alice.wang@example.com',
        '$2a$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lhWy', 'DOCTOR')
ON CONFLICT (id) DO NOTHING;

INSERT INTO users (id, email, password, role)
VALUES ('a1b2c3d4-0002-4bbb-aaaa-000000000002', 'bob.chen@example.com',
        '$2a$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lhWy', 'DOCTOR')
ON CONFLICT (id) DO NOTHING;

INSERT INTO users (id, email, password, role)
VALUES ('a1b2c3d4-0003-4bbb-aaaa-000000000003', 'carol.liu@example.com',
        '$2a$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lhWy', 'NURSE')
ON CONFLICT (id) DO NOTHING;

INSERT INTO users (id, email, password, role)
VALUES ('a1b2c3d4-0004-4bbb-aaaa-000000000004', 'david.lin@example.com',
        '$2a$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lhWy', 'NURSE')
ON CONFLICT (id) DO NOTHING;

INSERT INTO users (id, email, password, role)
VALUES ('a1b2c3d4-0005-4bbb-aaaa-000000000005', 'eva.zhang@example.com',
        '$2a$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lhWy', 'PATIENT')
ON CONFLICT (id) DO NOTHING;

INSERT INTO users (id, email, password, role)
VALUES ('a1b2c3d4-0006-4bbb-aaaa-000000000006', 'frank.huang@example.com',
        '$2a$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lhWy', 'PATIENT')
ON CONFLICT (id) DO NOTHING;

INSERT INTO users (id, email, password, role)
VALUES ('a1b2c3d4-0007-4bbb-aaaa-000000000007', 'grace.wu@example.com',
        '$2a$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lhWy', 'ADMIN')
ON CONFLICT (id) DO NOTHING;

INSERT INTO users (id, email, password, role)
VALUES ('a1b2c3d4-0008-4bbb-aaaa-000000000008', 'henry.tsai@example.com',
        '$2a$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lhWy', 'DOCTOR')
ON CONFLICT (id) DO NOTHING;

INSERT INTO users (id, email, password, role)
VALUES ('a1b2c3d4-0009-4bbb-aaaa-000000000009', 'irene.yang@example.com',
        '$2a$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lhWy', 'PATIENT')
ON CONFLICT (id) DO NOTHING;

