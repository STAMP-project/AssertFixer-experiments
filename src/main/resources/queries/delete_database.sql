-- Delete database
REVOKE CONNECT ON DATABASE "%s" FROM public;
SELECT pid, pg_terminate_backend(pid)
FROM pg_stat_activity
WHERE datname = ? AND pid <> pg_backend_pid();
DROP DATABASE "%s"
