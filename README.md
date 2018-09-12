# Build
```
# Builds the jar and uses it to create the functional docker image
docker build -t sysunite/weaver-database-postgresql:<version> .
```



### TODO
- better testing
	- split into units
	- check on asserts (read out the database)
	- throw errors when inserting failed (postgres is silent, unless RETURNING is used -> use VALUES((SELECT) because that throws a null error
	- more bad weather testing
- use a Java in memory key/value store to quickly get from uid -> id and label (attributeKey/relationKey) -> id
	- use https://github.com/OpenHFT/Chronicle-Map
- deep clone node route
- flyway for schema evolution
- performance testing
- query class convert to internal cache
- allow for sets of nodes (nodeset or just set)
- swap actual and expected in tests (currently wrong)
- make the tests run independently without order

### Indexes
-- Used for indexing with gin for faster full-text search on attribute value
-- See https://niallburkley.com/blog/index-columns-for-like-in-postgres/
CREATE INDEX attributes_string_value_idx ON attributes USING gin (string_value gin_trgm_ops);


## Possible missing constraints
- A node can have a relation to itself
- A relation / attribute can replace any other relation / attribute (even if sourceId differs)
- A remove-node can be removed again which conceptually doesn't make much sense

## Possible too enforcing constraints
- Creating a node that has been removed with same ID gives errors


