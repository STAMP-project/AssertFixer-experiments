# Changelist

## 4.13.0
- Start using sdk 3.11 that uses AttributeValue object.

## 4.12.2
- Fixes an issue where having a selectIn on a query with no results would give
  a server error.

## 4.12.1
- Adds a more explicit error when an empty array of relation targets is given,
  an explicit '*' target is required.

## 4.12.0
- Interpret json with write operations in batches on write call.

## 4.11.0
- Returns stored data types instead of derived data types.

## 4.10.8
- Fixes an issue where certain count operations would take the limit into
  account.
- Fixes a concurrent modification exception that would result in multiple
  subqueries not being handled.

## 4.10.6
- Fixes countPerGraph for withRelation and withAttributes queries

## 4.10.5
- Allows to limit results after ordering

## 4.10.4
- Fixes an issue where multiple recursive relation out conditions could not be
  combined

## 4.10.3
- Fixes an issue that would occur if selectIn was combined with selectRelation

## 4.10.2
- Fixes using selectIn with a wildcard relation id ("\*")

## 4.10.1
- Fixes an issue where multiple selectOut paths would interfere

## 4.10.0
- Adds the selectIn option to weaver query, which allows nodes with relations
  to the query result node to be loaded.
- Adds totalConnectorTime to query responses which includes all subqueries and
  processing for more clear profiling

## 4.9.0
- Adds the selectRelation option to weaver query, which, when specified,
  restricts the relations returned with nodes to those specified.

## 4.8.1
- Fixes cascade delete performance

## 4.8.0
- Adds the redirect graph operation which takes all relations from one graph to
  a second, and adds relations to the same nodes in a third graph

## 4.7.2
- Fixes truncate graph performance by improving its queries

## 4.7.1
- Fixes relation source, target, and key not being returned if a relation had
  an attribute

## 4.7.0
- Adds relation source, target, and key information for relations returned from queries.
- Adds truncate graph operation

## 4.6.0
- Removes the ability for an attribute to have multiple values for a different
  node.
- Extends legal database name length
- Fixes bug where database name legality was not checked on database creation

## 4.5.4
- Fixes a bug where relations could not be set on a node that reuses a uid

## 4.5.3
- Fixes nested weaver queries more than one level deep

## 4.5.2
- Improves performance of queries across the board
- Fixes count being wrong when multiple nodes in the result set had a relation
  to the same node reaching the limit and using the default graph

## 4.5.1
- Fixes count being wrong when multiple nodes in the result set had a relation
  to the same node

## 4.5.0
- On snapshot and snapshotGraph return graph, source_graph and target_graph
  in write operations json
- On snapshotGraph allow filters on multiple values for graph, source_graph
  and target_graph

## 4.4.0
- Allows node uid's to be reused after deleting a node with the same uid and
  graph

## 4.3.1
- Fixes the old query template (used when querying `.withRelations()`) where
  checks on (no) relations in would restrict on out instead.

## 4.3.0
- Adds endpoint to check existence of nodes quickly
- Adds the option to specify more than one restriction type on a relation, so
  now it is possible to find 'end' nodes by combining hasRelationIn with
  hasNoRelationOut.
- Fixes a bug where alwaysLoadRelations would not include the graph in their
  target
- Fixes a bug where multiple conditions on the same relation would be reduced
  to a single condition if the target is a subquery
- Fixes a bug where alwaysLoadRelations would only return the first target it
  encountered
