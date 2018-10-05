CREATE index nodes_deleted_by ON nodes (deleted_by);

DROP index nodes_created_by_idx;
DROP index nodes_created_on_idx;
