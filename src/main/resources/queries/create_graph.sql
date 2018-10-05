-- Add graph
INSERT INTO graphs (uid) VALUES (?) ON CONFLICT DO NOTHING;
