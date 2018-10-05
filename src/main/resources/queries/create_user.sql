-- Add user
INSERT INTO creators (uid) VALUES (?) ON CONFLICT DO NOTHING;
