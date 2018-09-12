-- Clean up database
-- This is a stored function, see the structure definition
-- This function is used to clean up the database, it removes all the nodes which exist directly and indirectly in the 'removed_nodes', 'replaced_attributes/relations' tables
-- sig: clean_database()
SELECT clean_up_database();
