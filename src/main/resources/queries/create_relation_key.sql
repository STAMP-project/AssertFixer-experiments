-- Add relation key
INSERT INTO relation_keys (label) VALUES (?) ON CONFLICT DO NOTHING;
