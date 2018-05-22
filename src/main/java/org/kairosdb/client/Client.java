package org.kairosdb.client;

import org.kairosdb.client.builder.MetricBuilder;
import org.kairosdb.client.builder.QueryBuilder;
import org.kairosdb.client.builder.QueryTagBuilder;
import org.kairosdb.client.builder.RollupBuilder;
import org.kairosdb.client.response.GetResponse;
import org.kairosdb.client.response.QueryResponse;
import org.kairosdb.client.response.QueryTagResponse;
import org.kairosdb.client.response.Response;
import org.kairosdb.client.response.RollupResponse;

import java.io.IOException;
import java.net.URISyntaxException;

public interface Client
{
	RollupResponse createRollup(RollupBuilder builder)
			throws IOException;

	Response deleteRollup(String id)
			throws IOException;

	RollupResponse getRollupTasks()
			throws IOException;

	RollupResponse getRollupTask(String id)
			throws IOException;

	/**
	 * Returns a list of all metric names.
	 *
	 * @return list of all metric names
	 * @throws IOException if the JSON returned could not be properly processed
	 */
	GetResponse getMetricNames() throws IOException;

	/**
	 * Returns a list of all tag names.
	 *
	 * @return list of all tag names
	 * @throws IOException if the JSON returned could not be properly processed
	 */
	GetResponse getTagNames() throws IOException;

	/**
	 * Returns a list of all tag values.
	 *
	 * @return list of all tag values
	 * @throws IOException if the JSON returned could not be properly processed
	 */
	GetResponse getTagValues() throws IOException;

	/**
	 * Returns status of Kairos Instance.
	 *
	 * @return status of Kairos instance
	 * @throws IOException if the JSON returned could not be properly processed
	 */
	GetResponse getStatus() throws IOException;

	/**
	 * Queries KairosDB using the query built by the builder.
	 *
	 * @param builder query builder
	 * @return response from the server
	 * @throws URISyntaxException if the host or post is invalid
	 * @throws IOException        problem occurred querying the server
	 */
	QueryResponse query(QueryBuilder builder) throws URISyntaxException, IOException;

	/**
	 * Queries KairosDB tags using the query built by the builder.
	 *
	 * @param builder query tag builder
	 * @return response from the server
	 * @throws URISyntaxException if the host or post is invalid
	 * @throws IOException        problem occurred querying the server
	 */
	QueryTagResponse queryTag(QueryTagBuilder builder) throws URISyntaxException, IOException;


	/**
	 * Sends metrics from the builder to the KairosDB server.
	 *
	 * @param builder metrics builder
	 * @return response from the server
	 * @throws URISyntaxException if the host or post is invalid
	 * @throws IOException        problem occurred sending to the server
	 */
	Response pushMetrics(MetricBuilder builder) throws URISyntaxException, IOException;

	/**
	 * Deletes a metric. This is the metric and all its data points.
	 *
	 * @param name the metric to delete
	 * @return response from the server
	 * @throws IOException problem occurred sending to the server
	 */
	Response deleteMetric(String name) throws IOException;

	/**
	 * Deletes data in KairosDB using the query built by the builder.
	 *
	 * @param builder query builder
	 * @return response from the server
	 * @throws URISyntaxException if the host or post is invalid
	 * @throws IOException        problem occurred querying the server
	 */
	Response delete(QueryBuilder builder) throws URISyntaxException, IOException;

	/**
	 * Returns the number of retries.
	 *
	 * @return number of retries
	 */
	@SuppressWarnings("UnusedDeclaration")
	int getRetryCount();

	/**
	 * Shuts down the client. Should be called when done using the client.
	 *
	 * @throws IOException if could not shutdown the client
	 */
	void shutdown() throws IOException;

	/**
	 * Registers a new custom data type. The assumption is that this data type already exists on the server. The
	 * dataPointValueClass is used to serialize and deserialize the custom type. This is simply a POJO.
	 *
	 * @param groupType           type used to deserialize the json on the client
	 * @param dataPointValueClass class that is the value of a data point
	 */
	void registerCustomDataType(String groupType, Class dataPointValueClass);

	/**
	 * Returns the data point value class for the given group type or null if one is not registered for the group type
	 *
	 * @param groupType group type
	 * @return data point class associated with the group type
	 */
	Class getDataPointValueClass(String groupType);
}