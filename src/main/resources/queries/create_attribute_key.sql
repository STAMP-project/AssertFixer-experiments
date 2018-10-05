-- Add attribute key
INSERT INTO attribute_keys (label) VALUES (?) ON CONFLICT DO NOTHING;
