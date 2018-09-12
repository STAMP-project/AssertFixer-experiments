-- Add attribute
INSERT INTO attributes (node, source, "key", double_value, string_value, boolean_value, datetime_value, datatype)

VALUES ((SELECT id FROM nodes WHERE uid=? AND graph = (SELECT id FROM graphs WHERE uid IS NOT DISTINCT FROM ?) AND deleted_by = -1),
        (SELECT id FROM nodes WHERE uid=? AND graph = (SELECT id FROM graphs WHERE uid IS NOT DISTINCT FROM ?) AND deleted_by = -1),
        (SELECT id FROM attribute_keys WHERE label=?),
        ?, ?, ?, ?, ?
);
